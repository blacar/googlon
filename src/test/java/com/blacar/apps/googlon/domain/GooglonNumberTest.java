package com.blacar.apps.googlon.domain;

import com.blacar.apps.spike.googlon.domain.GooglonNumber;
import org.junit.Assert;
import org.junit.Test;

public class GooglonNumberTest {

  @Test
  public void testNumber() {
    final GooglonNumber number = new GooglonNumber("gxjrc");
    Assert.assertTrue(number.getValue() == 605637);
    Assert.assertTrue(number.isPretty());
  }

  @Test
  public void veryBigNumber() {
    final GooglonNumber number = new GooglonNumber("ylduwpsnh");
    Assert.assertTrue(number.getValue() == 288026870670L);
    Assert.assertTrue(number.isPretty());
  }
}
