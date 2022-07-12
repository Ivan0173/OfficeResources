package com.company.officeresources2.entity;

import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@JmixEntity
@Table(name = "CABINET")
@Entity
@PrimaryKeyJoinColumn(name = "ID", referencedColumnName = "ID")
public class Cabinet extends Resource {

    @Column(name = "PROJECTOR", nullable = false)
    @NotNull
    private Boolean projector = false;

    @Column(name = "INTERACTIVE_WHITEBOARD", nullable = false)
    @NotNull
    private Boolean interactiveWhiteboard = false;

    @Column(name = "NUMBER_SEATS", nullable = false)
    @NotNull
    private Integer numberSeats;


    public Integer getNumberSeats() {
        return numberSeats;
    }

    public void setNumberSeats(Integer numberSeats) {
        this.numberSeats = numberSeats;
    }

    public Boolean getInteractiveWhiteboard() {
        return interactiveWhiteboard;
    }

    public void setInteractiveWhiteboard(Boolean interactiveWhiteboard) {
        this.interactiveWhiteboard = interactiveWhiteboard;
    }

    public Boolean getProjector() {
        return projector;
    }

    public void setProjector(Boolean projector) {
        this.projector = projector;
    }

}