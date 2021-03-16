package com.tts.RuleZero.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class Quality {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String qualityName;

    private String qualityValue;
}
