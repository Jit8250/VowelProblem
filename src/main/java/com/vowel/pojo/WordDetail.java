package com.vowel.pojo;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class WordDetail {

  private Set<Character> vowels;
  private int noOfCharacters;


  public WordDetail(Set<Character> vowels, int noOfCharacters) {
    this.vowels = vowels;
    this.noOfCharacters = noOfCharacters;
  }

  public String getVowels() {
    StringBuilder startBracket = new StringBuilder("{");
    String s = vowels.stream().map(character -> character.toString())
      .collect(Collectors.joining(","));
    startBracket.append(s).append("}");
    return startBracket.toString();
  }

  public void setVowels(Set<Character> vowels) {
    this.vowels = vowels;
  }

  public int getNoOfCharacters() {
    return noOfCharacters;
  }

  public void setNoOfCharacters(int noOfCharacters) {
    this.noOfCharacters = noOfCharacters;
  }

  public int getVowelCount() {
    return vowels.size();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    WordDetail that = (WordDetail) o;
    return noOfCharacters == that.noOfCharacters && Objects.equals(vowels, that.vowels);
  }

  @Override
  public int hashCode() {
    return Objects.hash(vowels, noOfCharacters);
  }

  @Override
  public String toString() {
    return "WordDetail{" +
      "vowels=" + vowels +
      ", noOfCharacters=" + noOfCharacters +
      '}';
  }
}
