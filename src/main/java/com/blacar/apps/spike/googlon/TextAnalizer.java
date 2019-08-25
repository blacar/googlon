package com.blacar.apps.spike.googlon;

import com.blacar.apps.spike.googlon.domain.Item;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TextAnalizer {

  public static final String alfabet = "sxocqnmwpfyheljrdgui";

  private List<String> words;

  private int prepositions;

  private int verbs;

  private int subjuntiverbs;

  private int prettyNumbers;

  private List<String> orderedwords;

  public TextAnalizer(final String text) {
    this.words = Arrays.asList(text.split(" "));
    this.analyze();
  }

  public int getPrepositions() {
    return prepositions;
  }

  public int getVerbs() {
    return verbs;
  }

  public int getSubjuntiverbs() {
    return subjuntiverbs;
  }

  public int getPrettyNumbers() {
    return prettyNumbers;
  }

  public List<String> getOrderedwords() {
    return orderedwords;
  }

  private void analyze() {
    final Set<Item> wordList = new HashSet<>();
    for (final String word: words) {
      final Item item = new Item(word);
      wordList.add(item);
      if (item.isPreposition()) {
        this.prepositions++;
        System.out.println("this is prep: " + item.getWord());
      }
      if (item.isVerb()) {
        this.verbs++;
      }
      if (item.isSubjuntiveVerb()) {
        this.subjuntiverbs++;
      }
      if (item.isPrettyNumber()) {
        this.prettyNumbers++;
      }
    }
    this.orderedwords = wordList.stream()
        .map(Item::getWord)
        .sorted(new GooglonLexComparator(alfabet))
        .collect(Collectors.toList());
  }
}
