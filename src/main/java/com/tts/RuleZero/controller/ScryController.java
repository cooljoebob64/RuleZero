package com.tts.RuleZero.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tts.RuleZero.model.Card;
import com.tts.RuleZero.model.CardDownload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="/scry")
public class ScryController {

    @Autowired
    ObjectMapper objectMapper;

    @GetMapping(value="/search")
    public ResponseEntity<List<CardDownload>> search(RestTemplate restTemplate, @RequestParam String q) throws IOException {
        String url = "https://api.scryfall.com/cards/search?q=" + q;
        String resp = restTemplate.getForObject(url, String.class);

        List<CardDownload> cardList = new ArrayList<>();
        JsonParser springParser = JsonParserFactory.getJsonParser();
        List<Object> dataList =  (ArrayList)springParser.parseMap(resp).get("data");

        for(Object card: dataList){
            CardDownload thisCard = objectMapper.convertValue(card, CardDownload.class);
            System.out.println("This card: " + thisCard.toString());
            System.out.println("This card: " + thisCard.getId());
            cardList.add(thisCard);
        }

        if(cardList.size()>0){
            return new ResponseEntity<>(cardList, HttpStatus.FOUND);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value="/card/{id}")
    public ResponseEntity<CardDownload> getCardDetails(@PathVariable(value="id")String id, RestTemplate restTemplate){

        CardDownload card = restTemplate.getForObject("https://api.scryfall.com/cards/" + id, CardDownload.class);

//        return new ResponseEntity<>(card, HttpStatus.FOUND);
        return new ResponseEntity<>(HttpStatus.FOUND);

    }
}
