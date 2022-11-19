package com.br.retrobackend.service;

import com.br.retrobackend.entitys.Retrospective;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RetrospectiveService {

    private final com.br.retrobackend.repository.RetrospectiveService retrospectiveRepository;

    public RetrospectiveService(com.br.retrobackend.repository.RetrospectiveService retrospectiveRepository) {
        super();
        this.retrospectiveRepository = retrospectiveRepository;
    }

    public Retrospective save(Retrospective retrospective) {
        return this.retrospectiveRepository.save(retrospective);
    }

    public List<Retrospective> getAll() {
        return this.retrospectiveRepository.findAll();
    }

    public Optional<Retrospective> findById(int id) {
        return this.retrospectiveRepository.findById(id);
    }

    public void deleteById(int id) {
        this.retrospectiveRepository.deleteById(id);
    }
}
