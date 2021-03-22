package com.tts.RuleZero.controller;

import com.tts.RuleZero.model.User;
import com.tts.RuleZero.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthorizationController {

    private UserService userService;

    public AuthorizationController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping("/signup")
//    @ApiOperation(value="Get the signup page")
//    public String registration(Model model) {
//        User user = new User();
//        model.addAttribute("user", user);
//
//        return "registration";
//    }

    @PostMapping("/signup")
    @ApiOperation(value="Send form data with username, email, and password to create a new user")
    @ApiResponses({
            @ApiResponse(code=201, message = "Created - New user has been created"),
            @ApiResponse(code=401, message = "Unauthorized - New user was not created")
    })
    public ResponseEntity<String> createNewUser(@Valid User user,
                                BindingResult bindingResult,
                                Model model) {
        User userExists = userService.findByUsername(user.getUsername());
        if (userExists != null) {
            bindingResult.rejectValue("username", "error.user", "Username is already taken");
            return new ResponseEntity<>("Signup Failed!", HttpStatus.UNAUTHORIZED);
        }
        if (!bindingResult.hasErrors()) {
            userService.saveNewUser(user);
            model.addAttribute("success", "Sign up successful!");
            model.addAttribute("user", new User());
        }
        return new ResponseEntity<>("Sign-Up success! Welcome " + user.getUsername(), HttpStatus.CREATED);
    }

//    @GetMapping("/login")
//    public ResponseEntity<String> logIn(Model model){
//        return new ResponseEntity<>("login", HttpStatus.OK);
//    }
}
