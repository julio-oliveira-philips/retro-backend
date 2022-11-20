package com.br.retrobackend.service;

import com.br.retrobackend.entitys.Action;
import com.br.retrobackend.repository.ActionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ActionService {

    private final ActionRepository actionRepository;

    public ActionService(ActionRepository actionRepository) {
        super();
        this.actionRepository = actionRepository;
    }

    public Action save(Action action) {
        action.setCreateDate(LocalDate.now());
        return this.actionRepository.save(action);
    }

    public List<Action> getAll() {
        return this.actionRepository.findAll();
    }

    public Optional<Action> findById(Integer id) {
        return this.actionRepository.findById(id);
    }

    public void deleteById(Integer id) {
        this.actionRepository.deleteById(id);
    }
}
