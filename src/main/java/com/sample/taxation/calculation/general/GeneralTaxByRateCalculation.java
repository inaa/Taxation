package com.sample.taxation.calculation.general;

import com.sample.taxation.calculation.TaxCalculation;
import com.sample.taxation.model.TaxResponse;
import static com.sample.taxation.util.FinancialCalculationsUtils.roundToTwoDecimalPlaces;


public class GeneralTaxByRateCalculation implements TaxCalculation {

  private final double taxRate;

  public GeneralTaxByRateCalculation(double taxRate) {
    this.taxRate = taxRate;
  }

  @Override
  public TaxResponse calculate(double playedAmount, double odd) {
    double possibleReturnAmountBefTax = roundToTwoDecimalPlaces(playedAmount * odd);
    double taxAmount = roundToTwoDecimalPlaces(possibleReturnAmountBefTax * taxRate);
    double possibleReturnAmountAfterTax = roundToTwoDecimalPlaces(possibleReturnAmountBefTax - taxAmount);

    TaxResponse.Outgoing outgoing = new TaxResponse.Outgoing(
        possibleReturnAmountAfterTax,
        possibleReturnAmountBefTax,
        possibleReturnAmountAfterTax,
        taxRate,
        taxAmount
    );

    TaxResponse response = new TaxResponse();
    response.setOutgoing(outgoing);
    return response;

  }

}
