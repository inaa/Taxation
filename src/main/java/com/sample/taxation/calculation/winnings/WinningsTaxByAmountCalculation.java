package com.sample.taxation.calculation.winnings;

import com.sample.taxation.calculation.TaxCalculation;
import com.sample.taxation.model.TaxResponse;
import static com.sample.taxation.util.FinancialCalculationsUtils.roundToTwoDecimalPlaces;


public class WinningsTaxByAmountCalculation implements TaxCalculation {
  private final double taxAmount;

  public WinningsTaxByAmountCalculation(double taxAmount) {
    this.taxAmount = taxAmount;
  }

  @Override
  public TaxResponse calculate(double playedAmount, double odd) {
    double possibleReturnAmountBefTax = roundToTwoDecimalPlaces(playedAmount * odd);
    double winningsAmount = possibleReturnAmountBefTax - playedAmount;
    
    // If winnings are less than tax amount, adjust tax amount
    double actualTaxAmount = Math.min(winningsAmount, taxAmount);
    double possibleReturnAmountAfterTax = roundToTwoDecimalPlaces(possibleReturnAmountBefTax - actualTaxAmount);
    
    // Calculated effective tax rate
    double effectiveTaxRate = roundToTwoDecimalPlaces(actualTaxAmount / possibleReturnAmountBefTax);

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