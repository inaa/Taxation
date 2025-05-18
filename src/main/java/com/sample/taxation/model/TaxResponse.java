package com.sample.taxation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaxResponse {

  private Outgoing outgoing;

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  public static class Outgoing {
    private double possibleReturnAmount;
    private double possibleReturnAmountBefTax;
    private double possibleReturnAmountAfterTax;
    private double taxRate;
    private double taxAmount;
  }


}
