package com.keyin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class SuggestionEngineTest {





    @Test
    @DisplayName("Testing For Exact Word Returns A Empty String")
    public void testGenerateSuggestion_ExistingWord() throws IOException {
        SuggestionEngine suggestionEngine = new SuggestionEngine();
        suggestionEngine.loadDictionaryData(Paths.get( ClassLoader.getSystemResource("words.txt").getPath()));

        String name = "aaron";
        String result = String.valueOf(suggestionEngine.generateSuggestions(name));

        Assertions.assertEquals("", result,"Expect Empty String");





    }

    @Test
    @DisplayName("Testing To See If Suggestions Work")
    public void testGenerateSuggestion_MissingOneLetter() throws IOException {
        SuggestionEngine suggestionEngine = new SuggestionEngine();
        suggestionEngine.loadDictionaryData(Paths.get( ClassLoader.getSystemResource("words.txt").getPath()));
        String word = "Abot";
        String expectedWord = "abbot";
        String result = String.valueOf(suggestionEngine.generateSuggestions(word));
        boolean containsWord = result.contains(expectedWord);
        Assertions.assertTrue(containsWord);


    }


    @Test
    @DisplayName("Testing To See If Suggestions Work For Switched Letters")
    public void testGenerateSuggestion_SwitchedLetters() throws IOException {
        SuggestionEngine suggestionEngine = new SuggestionEngine();
        suggestionEngine.loadDictionaryData(Paths.get( ClassLoader.getSystemResource("words.txt").getPath()));
        String word = "helol";
        String expectedWord = "hello";
        String result = String.valueOf(suggestionEngine.generateSuggestions(word));
        boolean containsWord = result.contains(expectedWord);
        Assertions.assertTrue(containsWord);


    }

    @Test
    @DisplayName("Testing To Check It Suggest Sensible Words")
    public void testGenerateSuggestion_SensibleWords() throws IOException {
        SuggestionEngine suggestionEngine = new SuggestionEngine();
        suggestionEngine.loadDictionaryData(Paths.get( ClassLoader.getSystemResource("words.txt").getPath()));
        String word = "hello";
        String notExpectedWord = "Elon";
        String result = String.valueOf(suggestionEngine.generateSuggestions(word));
        boolean containsWord = result.contains(notExpectedWord);
        Assertions.assertFalse(containsWord);

    }





}
