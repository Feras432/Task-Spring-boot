package com.example.demo.entity;

import com.example.demo.util.enums.SuggestionStatus;

import javax.persistence.*;

@Entity
@Table
public class GuestEntity {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String suggestionText;
    private Long rate;
    private String title;
    @Enumerated(EnumType.STRING)
    private SuggestionStatus status;
    public SuggestionStatus getStatus() {
        return status;
    }

    public void setStatus(SuggestionStatus status) {
        this.status = status;
    }

    public GuestEntity(){}
    public GuestEntity(String suggestionText, long rate, SuggestionStatus status) {
        this.suggestionText = suggestionText;
        this.rate = rate;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSuggestionText() {
        return suggestionText;
    }

    public void setSuggestionText(String suggestionText) {
        this.suggestionText = suggestionText;
    }

    public long getRate() {
        return rate;
    }

    public void setRate(long rate) {
        this.rate = rate;
    }

}
