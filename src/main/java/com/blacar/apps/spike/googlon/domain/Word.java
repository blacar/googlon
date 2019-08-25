package com.blacar.apps.spike.googlon.domain;

public class Word {

  private static final String EXCLUDED_LETTER = "u";

  private static final int VERB_MIN_LETTERS = 6;

  private static final int PREP_LENGTH = 6;

  private final String word;

  public Word(final String word) {
    this.word = word;
  }

  public String getWord() {
    return word;
  }

  public boolean isPreposition() {
    boolean result = false;
    if (this.word.length() == PREP_LENGTH) {
      if (!this.word.contains(EXCLUDED_LETTER)) {
        result = new Letter().isFooLetter(word.charAt(5));
      }
    }
    return result;
  }

  public boolean isVerb() {
    boolean result = false;
    if (this.word.length() >= VERB_MIN_LETTERS) {
      final char lastChar = word.charAt(this.word.length() - 1);
      if (!new Letter().isFooLetter(lastChar)) {
        result = true;
      }
    }
    return result;
  }

  public boolean isSubjuntiveVerb() {
    boolean result = false;
    if (isVerb()) {
      final char startChar = word.charAt(0);
      if (!new Letter().isFooLetter(startChar)) {
        result = true;
      }
    }
    return result;
  }
}
