package com.tts.RuleZero.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class UriList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="card_download_id")
    private CardDownload card;

    private String small;
    private String normal;
    private String large;
    private String png;
    private String art_crop;
    private String border_crop;
}
