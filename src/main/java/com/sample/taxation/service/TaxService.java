package com.sample.taxation.service;

import com.sample.taxation.calculation.general.GeneralTaxByAmountCalculation;
import com.sample.taxation.calculation.general.GeneralTaxByRateCalculation;
import com.sample.taxation.calculation.winnings.WinningsTaxByAmountCalculation;
import com.sample.taxation.calculation.winnings.WinningsTaxByRateCalculation;
import com.sample.taxation.model.TaxRequest;
import com.sample.taxation.model.TaxResponse;
import org.springframework.stereotype.Service;

@Service
public class TaxService {

  public TaxResponse calculateGeneralTaxByRateCalculation(TaxRequest taxRequest, Double taxRate) {
    return new GeneralTaxByRateCalculation(taxRate).calculate(taxRequest.getIncoming().getPlayedAmount(), taxRequest.getIncoming().getOdd());
  }

  public TaxResponse calculateGeneralTaxByAmountCalculation(TaxRequest taxRequest, Double amount) {
    return new GeneralTaxByAmountCalculation(amount).calculate(taxRequest.getIncoming().getPlayedAmount(), taxRequest.getIncoming().getOdd());
  }

  public TaxResponse calculateWinningsTaxByRate(TaxRequest taxRequest, Double taxRate) {
    return new WinningsTaxByRateCalculation(taxRate).calculate(taxRequest.getIncoming().getPlayedAmount(), taxRequest.getIncoming().getOdd());
  }

  public TaxResponse calculateWinningsTaxByAmount(TaxRequest taxRequest, Double amount) {
    return new WinningsTaxByAmountCalculation(amount).calculate(taxRequest.getIncoming().getPlayedAmount(), taxRequest.getIncoming().getOdd());
  }
}
