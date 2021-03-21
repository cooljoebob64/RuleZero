package com.tts.RuleZero.controller;

import com.tts.RuleZero.model.CardDownload;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="/scry")
public class ScryController {

    @GetMapping(value="/search")
    public ResponseEntity<List<CardDownload>> search(RestTemplate restTemplate, @RequestParam String q){
        String url = "https://api.scryfall.com/cards/search?q=" + q;
        String resp = restTemplate.getForObject(url, String.class);

//        System.out.println("Our response: " + resp);


        List<CardDownload> cardList = new ArrayList<>();
        JsonParser springParser = JsonParserFactory.getJsonParser();
        Object[] map = springParser.parseMap(resp).values().toArray();

        System.out.println("Our data object: " + map[3]);

//        int i=0;
//        for(Object card: springParser.parseList(map[3].toString())){
//            System.out.println("Card number " + i + ": " + card.toString());
//            i++;
//        }


//        if(map.size()>0) {
//            int i = 0;
//            for(Object card: map.){
//                System.out.println(card.toString());
//            }
//
//            return new ResponseEntity<>(HttpStatus.OK);
//        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value="/card/{id}")
    public ResponseEntity<CardDownload> getCardDetails(@PathVariable(value="id")String id, RestTemplate restTemplate){

        CardDownload card = restTemplate.getForObject("https://api.scryfall.com/cards/" + id, CardDownload.class);

//        return new ResponseEntity<>(card, HttpStatus.FOUND);
        return new ResponseEntity<>(HttpStatus.FOUND);

    }
}
