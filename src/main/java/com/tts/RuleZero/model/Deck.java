package com.tts.RuleZero.model;

import jdk.jfr.Timestamp;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Data
@Entity
@NoArgsConstructor
public class Deck {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "deck_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    private String title;

    public int active;

    private String description;

    private int cardCount;

    private String deckImage;

    private String colors;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "deck_card", joinColumns = @JoinColumn(name = "deck_id"),
            inverseJoinColumns = @JoinColumn(name = "card_id"))
    private List<Card> cards;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "deck_quality", joinColumns = @JoinColumn(name = "deck_id"),
            inverseJoinColumns = @JoinColumn(name = "quality_id"))
    private List<Quality> qualities;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date lastUpdatedAt;

    @Timestamp
    private Date lastAccessedAt;

    public String getColors(String colorInput) {
        StringBuilder colorOutput = new StringBuilder();

        for (int i = 0; i < colorInput.length(); i++) {
            if (!colorOutput.toString().contains("" + colorInput.charAt(i))) {
                colorOutput.append(colorInput.charAt(i));
            }
        }

        return colorOutput.toString();
    }

    public void setColors(String colors){
        this.colors = getColors(colors);
    }

}
