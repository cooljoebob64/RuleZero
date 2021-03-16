package com.tts.RuleZero.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long scryfallId;

    private String[] manaCost;

    private String[] colors;

    private String image;

    private String text;

    private String power;
    private String toughness;

    private String rarity;

    private String price;

    private String loyalty;

}
