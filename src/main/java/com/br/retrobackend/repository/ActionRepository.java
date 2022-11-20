package com.br.retrobackend.repository;

import com.br.retrobackend.entitys.Action;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionRepository extends JpaRepository<Action, Integer> { }
