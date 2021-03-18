package com.tts.RuleZero;

import com.tts.RuleZero.model.CardDownload;
import com.tts.RuleZero.model.Deck;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RuleZeroApplication {

	private static final Logger log = LoggerFactory.getLogger(RuleZeroApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RuleZeroApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder){
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception{
		return args -> {
			CardDownload card = restTemplate.getForObject("https://api.scryfall.com/cards/0fe79ee4-c3f3-4a6b-a967-203ca3b70ee5", CardDownload.class);
			log.info(card.toString());
			log.info(card.getName());
		};
	}


}
