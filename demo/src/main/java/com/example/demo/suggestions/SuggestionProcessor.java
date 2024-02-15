package com.example.demo.suggestions;

import com.example.demo.bo.CreateSuggestionRequest;
import com.example.demo.repository.GuestSuggestionRepository;

@FunctionalInterface
public interface SuggestionProcessor {
    void processSuggestion(CreateSuggestionRequest createSuggestionRequest);


}
