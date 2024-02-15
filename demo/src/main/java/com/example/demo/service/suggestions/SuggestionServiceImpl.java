package com.example.demo.service.suggestions;

import com.example.demo.repository.GuestSuggestionRepository;

public class SuggestionServiceImpl implements SuggestionService {
    private final GuestSuggestionRepository guestSuggestionRepository;

    public SuggestionServiceImpl(GuestSuggestionRepository guestSuggestionRepository) {
        this.guestSuggestionRepository = guestSuggestionRepository;
    }

    @Override
    public void getSuggestionRate() {

    }
}
