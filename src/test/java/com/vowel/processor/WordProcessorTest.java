package com.vowel.processor;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WordProcessorTest {

  private WordProcessor wordProcessor;
  @BeforeEach
  void setUp() {
    wordProcessor=new WordProcessor();
  }

  @Test
  void testIdentifyVowelsAndWordCount() {

    List<String> words= Arrays.asList("Platon");
    Assertions.assertEquals(new LinkedHashSet<>(Arrays.asList("({a,o},6) -> 3")),wordProcessor.identifyVowelsAndWordCount(words));
  }
}