package com.sample.taxation.calculation;

import com.sample.taxation.model.TaxResponse;

public interface TaxCalculation {
  TaxResponse calculate(double playedAmount, double odd);
}