package com.br.retrobackend.resource;

import com.br.retrobackend.entitys.Action;
import com.br.retrobackend.service.ActionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping(path = "/action", produces = MediaType.APPLICATION_JSON_VALUE)
public class ActionResource {

    private final ActionService actionService;

    public ActionResource(ActionService actionService) {
        super();
        this.actionService = actionService;
    }


    @PostMapping(value = "/save",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Action> save(@RequestBody Action action) {

        this.actionService.save(action);
        return new ResponseEntity<>(action, HttpStatus.OK);

    }

    @GetMapping()
    public ResponseEntity<List<Action>> getAll() {

        List<Action> actions;
        actions = this.actionService.getAll();
        return new ResponseEntity<>(actions, HttpStatus.OK);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Action>> getById(@PathVariable Long id) {

        Optional<Action> action;

        try {

            action = this.actionService.findById(id);
            return new ResponseEntity<>(action, HttpStatus.OK);

        } catch(NoSuchElementException nsee) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Optional<Action>> deleteById(@PathVariable Long id) {

        try {

            this.actionService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (NoSuchElementException nsee) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Action> update(@PathVariable Long id, @RequestBody Action newAction) {

        return this.actionService.findById(id)
                .map(action -> {
                    action.setActionDescription(newAction.getActionDescription());
                    action.setOwner(newAction.getOwner());
                    action.setFinished(newAction.getFinished());
                    Action actionUpdated = this.actionService.save(action);
                    return ResponseEntity.ok().body(actionUpdated);
                }).orElse(ResponseEntity.notFound().build());
    }
}
