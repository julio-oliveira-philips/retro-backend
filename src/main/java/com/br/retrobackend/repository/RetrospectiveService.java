package com.br.retrobackend.repository;

import com.br.retrobackend.entitys.Retrospective;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RetrospectiveService extends JpaRepository<Retrospective, Integer> {
}
