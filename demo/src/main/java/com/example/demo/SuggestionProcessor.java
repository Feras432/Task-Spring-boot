package com.example.demo;

import com.example.demo.bo.CreateSuggestionRequest;
import com.example.demo.repository.GuestSuggestionRepository;

@FunctionalInterface
public interface SuggestionProcessor {
    void takeSuggestion(String suggestionText);


}
