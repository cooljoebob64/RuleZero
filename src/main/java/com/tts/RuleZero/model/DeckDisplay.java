package com.tts.RuleZero.model;

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
public class DeckDisplay {
    private Long id;
    private User user;
    private String title;
    private String colors;
    private Date createdAt;
    private String deckImage;
    private String description;
    private int cardCount;
    private List<Quality> qualities;
    private List<Card> cards;
}
