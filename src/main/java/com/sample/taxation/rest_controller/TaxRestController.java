package com.sample.taxation.rest_controller;


import com.sample.taxation.model.TaxRequest;
import com.sample.taxation.model.TaxResponse;
import com.sample.taxation.service.TaxService;
import jakarta.validation.Valid;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/tax")
public class TaxRestController {

  @Autowired
  private TaxService taxService;

  @PostMapping
  @RequestMapping("/general")
  public ResponseEntity<TaxResponse> calculateGeneralTax(
      @RequestBody @Valid TaxRequest request,
      @RequestParam(value = "rate", required = false) Optional<Double> rate,
      @RequestParam(value = "amount", required = false) Optional<Double> amount
  ) {
    if (rate.isPresent() && amount.isEmpty()) {
      return ResponseEntity.ok(taxService.calculateGeneralTaxByRateCalculation(request, rate.get()));
    } else if (rate.isEmpty() && amount.isPresent()) {
      return ResponseEntity.ok(taxService.calculateGeneralTaxByAmountCalculation(request, amount.get()));
    }
    return ResponseEntity.badRequest().build();
  }



  @PostMapping
  @RequestMapping("/winnings")
  public ResponseEntity<TaxResponse> calculateWinningsTax(@RequestBody @Valid TaxRequest request,
      @RequestParam(value = "rate", required = false) Optional<Double> rate,
      @RequestParam(value = "amount", required = false) Optional<Double> amount
  ) {
    if (rate.isPresent() && amount.isEmpty()) {
      return ResponseEntity.ok(taxService.calculateWinningsTaxByRate(request, rate.get()));
    } else if (rate.isEmpty() && amount.isPresent()) {
      return ResponseEntity.ok(taxService.calculateWinningsTaxByAmount(request, amount.get()));
    }
    return ResponseEntity.badRequest().build();
  }
}
