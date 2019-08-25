package com.blacar.apps.spike.googlon;

import java.util.Arrays;
import java.util.Collections;

public class SolutionPrinter {

  private final TextAnalizer analizer;

  public SolutionPrinter(final TextAnalizer analizer) {
    this.analizer = analizer;
  }

  public void print() {
    System.out.println(
        String.format(
            "There are %d prepositions in the list.", this.analizer.getPrepositions()
        )
    );
    System.out.println(
        String.format(
            "There are %d verbs in the text.", this.analizer.getVerbs()
        )
    );
    System.out.println(
        String.format(
            "There are %d subjuntive verbs in the text.", this.analizer.getSubjuntiverbs()

        )
    );

    System.out.println(
        String.format(
            "Vocabulary list: %s", this.analizer.getOrderedwords()
        )
    );
    System.out.println(
        String.format(
            "There are %d distinct pretty numbers in the text.", this.analizer.getPrettyNumbers()
        )
    );
  }
}
