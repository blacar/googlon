package com.blacar.apps.spike.googlon;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Application {

  public static void main(String[] args) {
    if (args[0] == null || args[0].trim().isEmpty()) {
      System.out.println("You need to specify a path!");
    } else {
      new SolutionPrinter(new TextAnalizer(getFileContent(args[0]))).print();
    }
  }

  private static String getFileContent(final String filename) {
    final StringBuilder contentBuilder = new StringBuilder();
    try (Stream<String> stream = Files.lines(
        new File(filename).toPath(), StandardCharsets.UTF_8)
    ) {
      stream.forEach(s -> contentBuilder.append(s).append(" "));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return contentBuilder.toString();
  }
}
