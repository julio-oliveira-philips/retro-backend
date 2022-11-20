package com.br.retrobackend.resource;

import com.br.retrobackend.entitys.User;
import com.br.retrobackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthResource {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @PostMapping(value = "/login")
    public ResponseEntity<HttpStatus> login(@RequestBody User user) throws Exception {

        Authentication authObject = null;

        try {

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authObject);

        } catch (BadCredentialsException e) {

            throw new Exception("Invalid credentials");

        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/signup")
    public ResponseEntity<?> registerUser(@RequestBody User user){


        if(userService.existsByEmail(user.getEmail())){
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }

        User newUser = this.userService.save(user);

        return new ResponseEntity<>(newUser,  HttpStatus.OK);

    }

}