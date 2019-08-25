package com.blacar.apps.spike.googlon;

import java.util.Comparator;

public class GooglonLexComparator implements Comparator<String> {

  private final String alfabet;

  public GooglonLexComparator(final String alfabet) {
    this.alfabet = alfabet;
  }

  @Override
  public int compare(String o1, String o2) {
    if (o1.length() == 0)
      return -1;
    if (o2.length() == 0)
      return 1;
    if(o1.equals(o2)) {
      return 0;
    }
    int firstO1Letter = alfabet.indexOf(o1.charAt(0));
    int firstO2Letter = alfabet.indexOf(o2.charAt(0));
    if (firstO1Letter == firstO2Letter) {
      return compare(o1.substring(1), o2.substring(1));
    } else {
      return firstO1Letter - firstO2Letter;
    }
  }
}
