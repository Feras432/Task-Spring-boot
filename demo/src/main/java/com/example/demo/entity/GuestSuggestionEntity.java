package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "guest_suggestion")
public class GuestSuggestionEntity {
   @Id
   @Column(name = "id", nullable = false)
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private Long rate;
   private String suggestionText;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public Long getRate() {
      return rate;
   }

   public void setRate(Long rate) {
      this.rate = rate;
   }

   public String getSuggestionText() {
      return suggestionText;
   }

   public void setSuggestionText(String suggestionText) {
      this.suggestionText = suggestionText;
   }



}