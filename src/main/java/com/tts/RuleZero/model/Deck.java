package com.tts.RuleZero.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Builder
public class Deck {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String description;

    private int cardCount;

    private String deckImage;

    private String[] colors;

    private List<Card> cardList;

    private List<Quality> qualityList;

}
