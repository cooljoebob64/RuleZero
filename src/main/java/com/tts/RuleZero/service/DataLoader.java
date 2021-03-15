package com.tts.RuleZero.service;

import com.tts.RuleZero.model.Role;
import com.tts.RuleZero.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private RoleRepository roleRepository;

    @Autowired
    public DataLoader(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void run(ApplicationArguments args) {
        roleRepository.save(new Role((long)1, "USER"));
        roleRepository.save(new Role((long)2, "ADMIN"));
    }
}