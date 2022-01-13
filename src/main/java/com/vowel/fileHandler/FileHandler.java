package com.vowel.fileHandler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class FileHandler {

  public List<String> loadFileData(String filePath) {
    List<String> words = new ArrayList<>();
    try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
      stream.forEach(w -> {
        words.addAll(Arrays.asList(w.toLowerCase().split(" ")));
      });
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
    return words;
  }

  public void writeFile(String outputFile, Set<String> outputText) {
    Path path = Paths.get(outputFile);

    outputText.forEach(words -> {
      try {
        Files.write(path, words.getBytes(), StandardOpenOption.APPEND);
      } catch (IOException e) {
        e.printStackTrace();
      }
    });


  }
}
