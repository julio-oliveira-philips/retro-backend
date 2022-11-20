package com.br.retrobackend.resource;

import com.br.retrobackend.entitys.Retrospective;
import com.br.retrobackend.service.RetrospectiveService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping(path = "/retrospective", produces = MediaType.APPLICATION_JSON_VALUE)
public class RetrospectiveResource {

    private final RetrospectiveService retrospectiveService;

    public RetrospectiveResource(RetrospectiveService retrospectiveService) {
        super();
        this.retrospectiveService = retrospectiveService;
    }


    @PostMapping(value = "/save",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Retrospective> save(@RequestBody Retrospective retrospective) {

        this.retrospectiveService.save(retrospective);
        return new ResponseEntity<>(retrospective, HttpStatus.OK);

    }

    @GetMapping()
    public ResponseEntity<List<Retrospective>> getAll() {

        List<Retrospective> retrospectives;
        retrospectives = this.retrospectiveService.getAll();
        return new ResponseEntity<>(retrospectives, HttpStatus.OK);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Retrospective>> getById(@PathVariable Integer id) {
        Optional<Retrospective> retrospective;

        try {

            retrospective = this.retrospectiveService.findById(id);
            return new ResponseEntity<>(retrospective, HttpStatus.OK);

        } catch(NoSuchElementException nsee) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Optional<Retrospective>> deleteById(@PathVariable Integer id) {

        try {

            this.retrospectiveService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (NoSuchElementException nsee) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Retrospective> update(@PathVariable Integer id, @RequestBody Retrospective newRetrospective) {

        return this.retrospectiveService.findById(id)
                .map(retrospective -> {
                    retrospective.setNameRetrospective(newRetrospective.getNameRetrospective());
                    retrospective.setStartDate(newRetrospective.getStartDate());
                    retrospective.setEndDate(newRetrospective.getEndDate());
                    retrospective.setFinished(newRetrospective.getFinished());
                    Retrospective retrospectiveUpdated = this.retrospectiveService.save(retrospective);
                    return ResponseEntity.ok().body(retrospectiveUpdated);
                }).orElse(ResponseEntity.notFound().build());
    }
}
