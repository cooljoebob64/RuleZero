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
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private RoleRepository roleRepository;
    private DeckRepository deckRepository;
    private UserRepository userRepository;

    @Autowired
    public DataLoader(RoleRepository roleRepository, DeckRepository deckRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.deckRepository = deckRepository;
        this.userRepository = userRepository;
    }

    public void run(ApplicationArguments args) {
        roleRepository.save(new Role((long)1, "USER"));
        roleRepository.save(new Role((long)2, "ADMIN"));

        User demoUser = userRepository.findById((long)3).get();
        Deck demoDeck = new Deck();
        demoDeck.setUser(demoUser);
        demoDeck.setTitle("Demo Deck");
        demoDeck.setDescription("This is a demo deck!");
        demoDeck.setColors(new String[]{"W", "B", "G"});
        deckRepository.save(demoDeck);
    }
}