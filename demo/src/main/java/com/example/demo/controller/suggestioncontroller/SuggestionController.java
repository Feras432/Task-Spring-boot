package com.example.demo.controller.suggestioncontroller;

import com.example.demo.bo.CreateSuggestionRequest;
import com.example.demo.entity.GuestEntity;
import com.example.demo.service.suggestions.SuggestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/guest")
public class SuggestionController {
    private final SuggestionService suggestionsService;

    public SuggestionController(SuggestionService suggestionsService) {
        this.suggestionsService = suggestionsService;
    }


    @PostMapping("/create-suggestion")
    public ResponseEntity<Void> processSuggestion(@RequestBody CreateSuggestionRequest createSuggestionRequest){
        suggestionsService.createSuggestion(createSuggestionRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/suggestions")
    public ResponseEntity<List<GuestEntity>> getSuggestions(@RequestParam String status){
        List<GuestEntity> suggestions = suggestionsService.findSuggestions(status.toUpperCase());
        return ResponseEntity.ok().body(suggestions);
    }
}
