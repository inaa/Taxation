package com.sample.taxation.calculation.winnings;

import com.sample.taxation.calculation.TaxCalculation;
import com.sample.taxation.model.TaxResponse;
import static com.sample.taxation.util.FinancialCalculationsUtils.roundToTwoDecimalPlaces;


public class WinningsTaxByRateCalculation implements TaxCalculation {
  private final double taxRate;

  public WinningsTaxByRateCalculation(double taxRate) {
    this.taxRate = taxRate;
  }

  @Override
  public TaxResponse calculate(double playedAmount, double odd) {
    double possibleReturnAmountBefTax = roundToTwoDecimalPlaces(playedAmount * odd);
    double winningsAmount = possibleReturnAmountBefTax - playedAmount;
    double taxAmount = roundToTwoDecimalPlaces(winningsAmount * taxRate);
    double possibleReturnAmountAfterTax = roundToTwoDecimalPlaces(possibleReturnAmountBefTax - taxAmount);
    
    // Calculate effective tax rate (tax amount divided by total return before tax)
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