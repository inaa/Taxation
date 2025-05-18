package com.sample.taxation.model;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaxRequest {

  @Valid
  @NotNull(message = "Incoming is required")
  private Incoming incoming;

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  public static class Incoming {

    @NotNull(message = "Trader ID is required")
    private Integer traderId;

    @NotNull(message = "Played Amount is required")
    @DecimalMin(value = "0.01", message = "Played amount must be greater than zero")
    private Double playedAmount;

    @NotNull(message = "Odd is required")
    @DecimalMin(value = "0.01", message = "Odd must be greater than then zero")
    private Double odd;
  }


}
