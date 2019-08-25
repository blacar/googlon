package com.blacar.apps.spike.googlon.domain;

import java.util.Objects;

public class Item {

  private final String item;

  private Word wordidentifier;

  private GooglonNumber numberidentifier;

  public Item(final String item) {
    this.item = item;
  }

  public boolean isPreposition() {
    if (this.wordidentifier == null) {
      this.wordidentifier = new Word(item);
    }
    return this.wordidentifier.isPreposition();
  }

  public boolean isVerb() {
    if (this.wordidentifier == null) {
      this.wordidentifier = new Word(item);
    }
    return this.wordidentifier.isVerb();
  }

  public boolean isSubjuntiveVerb() {
    if (this.wordidentifier == null) {
      this.wordidentifier = new Word(item);
    }
    return this.wordidentifier.isSubjuntiveVerb();
  }

  public boolean isPrettyNumber() {
    if (this.numberidentifier == null) {
      this.numberidentifier= new GooglonNumber(item);
    }
    return this.numberidentifier.isPretty();
  }

  public String getWord() {
    if (this.wordidentifier == null) {
      this.wordidentifier = new Word(item);
    }
    return this.wordidentifier.getWord();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Item item1 = (Item) o;
    return Objects.equals(item, item1.item);
  }

  @Override
  public int hashCode() {
    return Objects.hash(item);
  }
}
