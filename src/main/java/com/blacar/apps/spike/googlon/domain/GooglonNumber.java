package com.blacar.apps.spike.googlon.domain;

public class GooglonNumber {

  private static final String alfabet = "sxocqnmwpfyheljrdgui";

  private static final int PRETTY_AMOUNT = 81827;

  private static final int PRETTY_DIVISOR = 3;

  private final StringBuilder number;

  public GooglonNumber(final String number) {
    this.number = new StringBuilder(number);
  }

  public long getValue() {
    long result = 0;
    for (int i = 0; i < number.length(); i++) {
      final long power = new Double(Math.pow(20, i)).longValue();
      final int digit = alfabet.indexOf(number.charAt(i));
      result = result + (digit*power);
    }
    return result;
  }

  public boolean isPretty() {
    boolean result = false;
    final long value = getValue();
    if (value >= PRETTY_AMOUNT) {
      if (value%PRETTY_DIVISOR == 0) {
        result = true;
      }
    }
    return result;
  }
}
