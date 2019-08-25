package com.blacar.apps.spike.googlon.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Letter {

  private static final Set<Character> foo = new HashSet<>(Arrays.asList('u','d','x','s','m','p','f'));

  public boolean isFooLetter(final char letter) {
    return foo.contains(letter);
  }
}
