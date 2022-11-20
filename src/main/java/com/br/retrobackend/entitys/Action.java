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
@Table(name = "action")
public class Action implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private int actionId;

    @NotNull
    @Column(name = "action_description")
    private String actionDescription;

    @NotNull
    @Column(name = "create_date")
    private LocalDate createDate;

    @NotNull
    @Column(name = "owner")
    private String owner;

    @NotNull
    @Column(name = "finished")
    private Boolean finished;

}
