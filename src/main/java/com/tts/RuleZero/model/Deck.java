package com.tts.RuleZero.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

    private String description;

    private int cardCount;

    private String deckImage;

    private String[] colors;

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


    public String[] getColors(String colorInput) {
        StringBuilder colorOutput = new StringBuilder();

        for (int i = 0; i < colorInput.length(); i++) {
            if (!colorOutput.toString().contains("" + colorInput.charAt(i))) {
                colorOutput.append(colorInput.charAt(i));
            }
        }

        String[] newColorBlock = new String[colorOutput.length()];
        for(int i=0;i<colorOutput.length();i++){
            newColorBlock[i] = String.valueOf(colorOutput.charAt(i)).toUpperCase(Locale.ROOT);
        }

        return newColorBlock;
    }

    public void setColors(String colors){
        this.colors = getColors(colors);
    }

    public void setColors(String[] colors){
        this.colors = colors;
    }

}
