package com.example.demo.service.guest;

import com.example.demo.repository.GuestSuggestionRepository;
import com.example.demo.service.suggestions.SuggestionService;
import org.springframework.stereotype.Service;

@Service
public class GuestSuggestionService implements SuggestionService {
    private final GuestSuggestionRepository guestSuggestionRepository;

    public GuestSuggestionService(GuestSuggestionRepository guestSuggestionRepository) {
        this.guestSuggestionRepository = guestSuggestionRepository;
    }

    @Override
    public void getSuggestionRate() {

    }

    @FunctionalInterface
   interface SuggestionProcessor{
        void processSuggestion(String suggestionText);

    }

}
