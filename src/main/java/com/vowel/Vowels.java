package com.vowel;

import java.util.List;
import java.util.Set;

import com.vowel.fileHandler.FileHandler;
import com.vowel.processor.WordProcessor;

public class Vowels {

  public static void main(String[] args) {

    String inputFile = "D://INPUT.txt";
    FileHandler fileHandler = new FileHandler();

    WordProcessor wordProcessor = new WordProcessor();

    List<String> words = fileHandler.loadFileData(inputFile);

    Set<String> outputText = wordProcessor.identifyVowelsAndWordCount(words);

    String outputFile = "D://OUTPUT.txt";

    fileHandler.writeFile(outputFile, outputText);


  }
}
