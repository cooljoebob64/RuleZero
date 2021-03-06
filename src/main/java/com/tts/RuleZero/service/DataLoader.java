package com.tts.RuleZero.service;

import com.tts.RuleZero.model.Deck;
import com.tts.RuleZero.model.Role;
import com.tts.RuleZero.model.User;
import com.tts.RuleZero.repository.DeckRepository;
import com.tts.RuleZero.repository.RoleRepository;
import com.tts.RuleZero.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.NoSuchElementException;
import java.util.Set;

@Component
public class DataLoader implements ApplicationRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final DeckService deckService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired

    public DataLoader(RoleRepository roleRepository, DeckRepository deckRepository, UserRepository userRepository, DeckService deckService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.deckService = deckService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void run(ApplicationArguments args) {

        try {

        Role userRole = new Role((long) 1, "USER");
        roleRepository.save(userRole);
        roleRepository.save(new Role((long) 2, "ADMIN"));

        User demoUser = new User();
        demoUser.setId((long)1);
        demoUser.setUsername("DemoUser");
        demoUser.setEmail("demo@demo.demo");
        demoUser.setRoles(Set.of(userRole));
        demoUser.setPassword(bCryptPasswordEncoder.encode("test123"));
        demoUser.setActive(1);
        userRepository.save(demoUser);


        Deck demoDeck = deckService.addNewDeck(demoUser);
        demoDeck.setTitle("Demo Deck");
        demoDeck.setDescription("This is a demo deck!");
        demoDeck.setColors("RU");
        deckService.save(demoDeck);

        } catch (NoSuchElementException e) {
            e.getStackTrace();
        }
    }
}