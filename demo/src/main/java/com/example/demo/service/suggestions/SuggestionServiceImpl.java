package com.example.demo.service.suggestions;

import com.example.demo.bo.CreateSuggestionRequest;
import com.example.demo.entity.GuestEntity;
import com.example.demo.repository.GuestSuggestionRepository;
import com.example.demo.suggestions.SuggestionProcessor;
import com.example.demo.util.enums.SuggestionStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SuggestionServiceImpl implements SuggestionService {
    private final GuestSuggestionRepository guestSuggestionRepository;

    public SuggestionServiceImpl(GuestSuggestionRepository guestSuggestionRepository) {
        this.guestSuggestionRepository = guestSuggestionRepository;
    }

    @Override
    public void createSuggestion(CreateSuggestionRequest createSuggestionRequest) {
        SuggestionProcessor function = suggestion -> {
            GuestEntity guestEntity = new GuestEntity();
            guestEntity.setSuggestionText(suggestion.getSuggestionText());
            guestEntity.setRate(suggestion.getRate());
            guestEntity.setStatus(SuggestionStatus.valueOf(suggestion.getStatus().toUpperCase()));
            guestSuggestionRepository.save(guestEntity);
        };
        function.processSuggestion(createSuggestionRequest);
    }

    @Override
    public List<GuestEntity> findSuggestions(String status) {
        List<GuestEntity> suggestions = guestSuggestionRepository.findAll()
                .stream()
                .filter(guestEntity -> guestEntity.getStatus().toString().equals(status))
                .collect(Collectors.toList());
        return suggestions;
    }
}
