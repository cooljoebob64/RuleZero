package com.tts.RuleZero.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="card_id")
    private Long id;

    @ManyToMany(mappedBy = "cards")
    private List<Deck> decks;





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
