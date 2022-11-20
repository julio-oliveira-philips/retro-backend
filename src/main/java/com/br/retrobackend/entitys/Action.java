package com.br.retrobackend.entitys;

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
@Table(name = "action")
public class Action implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private int actionId;

    @Column(name = "action_description")
    private String actionDescription;

    @Column(name = "create_date")
    private LocalDate createDate;

    @Column(name = "owner")
    private String owner;

    @Column(name = "finished")
    private Boolean finished;

}
