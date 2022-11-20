package com.br.retrobackend.service;

import com.br.retrobackend.entitys.Retrospective;
import com.br.retrobackend.repository.RetrospectiveRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RetrospectiveService {

    private final RetrospectiveRepository retrospectiveRepository;

    public RetrospectiveService(RetrospectiveRepository retrospectiveRepository) {
        super();
        this.retrospectiveRepository = retrospectiveRepository;
    }

    public Retrospective save(Retrospective retrospective) {
        return this.retrospectiveRepository.save(retrospective);
    }

    public List<Retrospective> getAll() {
        return this.retrospectiveRepository.findAll();
    }

    public Optional<Retrospective> findById(Long id) {
        return this.retrospectiveRepository.findById(id);
    }

    public void deleteById(Long id) {
        this.retrospectiveRepository.deleteById(id);
    }
}
