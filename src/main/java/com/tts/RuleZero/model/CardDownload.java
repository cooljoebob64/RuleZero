package com.tts.RuleZero.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CardDownload {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_download_id")
    private String id;

    @JsonProperty(value="id")
    private String scryfallId;

    private String oracle_id;
    private int[] multiverse_ids;
    private int mtgo_id;
    private int tcgplayer_id;
    private int cardmarket_id;
    private String name;
    private String lang;
    private String released_at;
    private String uri;
    private String scryfall_uri;
    private String layout;
    private boolean highres_image;
    private String image_status;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "card")
    private UriList image_uris;

    private String mana_cost;
    private double cmc;
    private String type_line;
    private String oracle_text;
    private String power;
    private String toughness;
    private String[] colors;
    private String[] color_identity;
    private String[] keywords;
//    private Object legalities;
    private String[] games;
    private boolean reserved;
    private boolean foil;
    private boolean oversized;
    private boolean promo;
    private boolean reprint;
    private boolean variation;
    private String set;
    private String set_name;
    private String set_type;
    private String set_uri;
    private String set_search_uri;
    private String scryfall_set_url;
    private String rulings_uri;
    private String prints_search_uri;
    private String collector_number;
    private boolean digital;
    private String rarity;
    private String flavor_text;
    private String card_back_id;
    private String artist;
    private String[] artist_ids;
    private String illustration_id;
    private String border_color;
    private String frame;
    private String[] frame_effects;
    private boolean full_art;
    private boolean textless;
    private boolean booster;
    private boolean story_spotlight;
    private int edhrec_rank;
//    private Object preview;
//    private Object prices;
//    private Object related_uris;
//    private Object purchase_uris;

    @UpdateTimestamp
    private Date updatedAt;

    @Override
    public String toString(){
        return name;
    }

}
