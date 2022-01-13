package com.vowel.processor;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import com.vowel.pojo.WordDetail;

public class WordProcessor {

  Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

  public Set<String> identifyVowelsAndWordCount(List<String> words) {

    Map<String, List<WordDetail>> vowelToWordDetailMap = words.stream().map(w -> getWordDetails(w.toLowerCase()))
      .collect(Collectors.groupingBy(wordDetail -> wordDetail.getVowels()));

    return averageVowelsPerWord(vowelToWordDetailMap);

  }

  private WordDetail getWordDetails(String word) {
    Set<Character> vowel = new TreeSet<>();
    int wordCount = 0;
    for (int i = 0; i < word.length(); i++) {
      char character = word.charAt(i);
      if (character != '.') {
        wordCount++;
      }
      if (vowels.contains(character)) {
        vowel.add(character);
      }
    }
    return new WordDetail(vowel, wordCount);
  }


  private Set<String> averageVowelsPerWord(Map<String, List<WordDetail>> vowelToWordDetailMap) {
    Set<String> averageVowelPerWord = new LinkedHashSet<>();

    vowelToWordDetailMap.entrySet().forEach(e -> {
      e.getValue().forEach(value -> {
        StringBuilder openingBracket = new StringBuilder("(");
        openingBracket.append(value.getVowels()).append(",").append(value.getNoOfCharacters())
          .append(") -> ").append(value.getNoOfCharacters() / value.getVowelCount());
        averageVowelPerWord.add(openingBracket.toString());
      });

    });
    return averageVowelPerWord;
  }
}
