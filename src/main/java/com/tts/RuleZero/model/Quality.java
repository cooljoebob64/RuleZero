package com.tts.RuleZero.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Quality {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="quality_id")
    private Long id;

    private String qualityName;

    private String qualityValue;

    @ManyToMany(mappedBy = "qualities")
    private List<Deck> decks;
}
