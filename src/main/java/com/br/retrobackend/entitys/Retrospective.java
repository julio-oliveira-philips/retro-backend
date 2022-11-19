package com.br.retrobackend.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Retrospective {

    @GeneratedValue
    @Id
    private int retrospectiveId;

    @Column(name = "retrospective_id")
    private String nameRetrospective;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "finished")
    private Boolean finished;

}
