package com.tts.RuleZero.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeckDisplay {
    private Long id;
    private User user;
    private String title;
    private int active;
    private String colors;
    private Date createdAt;
    private Date lastUpdatedAt;
    private Date lastAccessedAt;
    private String deckImage;
    private String description;
    private int cardCount;
    private List<Quality> qualities;
    private List<Card> cards;
}
