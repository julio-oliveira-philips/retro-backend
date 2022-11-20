package com.br.retrobackend.entitys;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "retrospective")
public class Retrospective implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private int retrospectiveId;

    @NotNull
    @Column(name = "name_retrospective")
    private String nameRetrospective;

    @NotNull
    @Column(name = "start_date")
    private LocalDate startDate;

    @NotNull
    @Column(name = "end_date")
    private LocalDate endDate;

    @NotNull
    @Column(name = "finished")
    private Boolean finished;

}
