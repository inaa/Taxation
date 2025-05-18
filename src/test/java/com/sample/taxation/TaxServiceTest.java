package com.sample.taxation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.sample.taxation.model.TaxRequest;
import com.sample.taxation.model.TaxResponse;
import com.sample.taxation.service.TaxService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TaxServiceTest {

  @Autowired
  private TaxService taxService;

  @Test
  public void testCalculateGeneralTaxByRateCalculation() {
    TaxResponse response =
        taxService.calculateGeneralTaxByRateCalculation(taxRequest(5.0d, 1.5d), 0.1d);
    assertEquals(0.75d, response.getOutgoing().getTaxAmount());
    assertEquals(6.75d, response.getOutgoing().getPossibleReturnAmountAfterTax());
  }

  @Test
  public void testCalculateGeneralTaxByAmountCalculation() {
    TaxResponse response =
        taxService.calculateGeneralTaxByAmountCalculation(taxRequest(5.0d, 1.5d), 2.0d);
    assertEquals(2d, response.getOutgoing().getTaxAmount());
    assertEquals(5.5d, response.getOutgoing().getPossibleReturnAmountAfterTax());
  }

  @Test
  public void testCalculateWinningsTaxByRateCalculation() {
    TaxResponse response =
        taxService.calculateWinningsTaxByRate(taxRequest(5.0d, 1.5d), 0.1d);
    assertEquals(0.25d, response.getOutgoing().getTaxAmount());
    assertEquals(7.25d, response.getOutgoing().getPossibleReturnAmountAfterTax());
  }

  @Test
  public void testCalculateWinningsTaxByAmountCalculation() {
    TaxResponse response =
        taxService.calculateWinningsTaxByAmount(taxRequest(5.0d, 1.5d), 1.0d);
    assertEquals(1d, response.getOutgoing().getTaxAmount());
    assertEquals(6.5d, response.getOutgoing().getPossibleReturnAmountAfterTax());
  }

  private TaxRequest taxRequest(double playedAmount, double odd) {
    TaxRequest.Incoming incoming = new TaxRequest.Incoming(0, playedAmount, odd);
    return new TaxRequest(incoming);
  }

}
