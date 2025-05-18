package com.sample.taxation.calculation.general;

import com.sample.taxation.calculation.TaxCalculation;
import com.sample.taxation.model.TaxResponse;
import static com.sample.taxation.util.FinancialCalculationsUtils.roundToTwoDecimalPlaces;

public class GeneralTaxByAmountCalculation implements TaxCalculation {

  private final double taxAmount;

  public GeneralTaxByAmountCalculation(double taxAmount) {
    this.taxAmount = taxAmount;
  }

  @Override
  public TaxResponse calculate(double playedAmount, double odd) {
    double possibleReturnAmountBefTax = roundToTwoDecimalPlaces(playedAmount * odd);
    double possibleReturnAmountAfterTax = roundToTwoDecimalPlaces(possibleReturnAmountBefTax - taxAmount);
    double effectiveTaxRate = roundToTwoDecimalPlaces(taxAmount / possibleReturnAmountBefTax);

    TaxResponse.Outgoing outgoing = new TaxResponse.Outgoing(
        possibleReturnAmountAfterTax,
        possibleReturnAmountBefTax,
        possibleReturnAmountAfterTax,
        effectiveTaxRate,
        taxAmount
    );

    TaxResponse response = new TaxResponse();
    response.setOutgoing(outgoing);
    return response;
  }

}
