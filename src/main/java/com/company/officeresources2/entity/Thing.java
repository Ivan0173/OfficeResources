package com.company.officeresources2.entity;

import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@JmixEntity
@Table(name = "THING")
@Entity
@PrimaryKeyJoinColumn(name = "ID", referencedColumnName = "ID")
public class Thing extends Resource {

    @InstanceName
    @Column(name = "DESCRIPTION")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}