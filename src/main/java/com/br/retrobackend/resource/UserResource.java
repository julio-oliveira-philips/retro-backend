package com.br.retrobackend.resource;

import com.br.retrobackend.entitys.User;
import com.br.retrobackend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping(path = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserResource {

    private final UserService userService;

    public UserResource(UserService userService) {
        super();
        this.userService = userService;
    }


    @PostMapping(value = "/save",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> save(@RequestBody User user) {

        this.userService.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);

    }

    @GetMapping()
    public ResponseEntity<List<User>> getAll() {

        List<User> users;
        users = this.userService.getAll();
        return new ResponseEntity<>(users, HttpStatus.OK);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<User>> getById(@PathVariable Integer id) {

        Optional<User> user;

        try {

            user = this.userService.findById(id);
            return new ResponseEntity<>(user, HttpStatus.OK);

        } catch(NoSuchElementException nsee) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Optional<User>> deleteById(@PathVariable Integer id) {

        try {

            this.userService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (NoSuchElementException nsee) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<User> update(@PathVariable Integer id, @RequestBody User newUser) {

        return this.userService.findById(id)
                .map(action -> {
                    action.setUserName(newUser.getUserName());
                    action.setEmail(newUser.getEmail());
                    action.setPassword(newUser.getPassword());
                    User userUpdated = this.userService.save(action);
                    return ResponseEntity.ok().body(userUpdated);
                }).orElse(ResponseEntity.notFound().build());
    }
}
