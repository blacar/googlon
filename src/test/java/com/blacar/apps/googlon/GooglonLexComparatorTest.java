package com.blacar.apps.googlon;

import com.blacar.apps.spike.googlon.GooglonLexComparator;
import com.blacar.apps.spike.googlon.TextAnalizer;
import org.junit.Assert;
import org.junit.Test;

public class GooglonLexComparatorTest {

  @Test
  public void comparatorTest1() {
    Assert.assertTrue(
        new GooglonLexComparator(TextAnalizer.alfabet).compare("hcgeox", "hc") == 1
    );
    Assert.assertTrue(
        new GooglonLexComparator(TextAnalizer.alfabet).compare("mwd", "mw") == 1
    );
  }

  @Test
  public void comparatorTest2() {
    Assert.assertTrue(
        new GooglonLexComparator(TextAnalizer.alfabet).compare("hcgeox", "hcgeox") == 0
    );
  }

}
