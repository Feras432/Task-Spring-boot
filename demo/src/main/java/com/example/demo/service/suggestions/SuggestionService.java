package com.example.demo.service.suggestions;

import com.example.demo.bo.CreateSuggestionRequest;
import com.example.demo.entity.GuestEntity;

import java.util.List;

public interface SuggestionService {
    void createSuggestion(CreateSuggestionRequest createSuggestionRequest);

    List<GuestEntity> findSuggestions(String status);
}
