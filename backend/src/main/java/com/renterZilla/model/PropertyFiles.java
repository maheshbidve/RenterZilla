package com.renterZilla.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "propertyFiles")
@NoArgsConstructor
@Getter
@Setter
public class PropertyFiles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer propertyFileId;

    @Column(length = 200)
    private String name;

    @ManyToOne
    @JoinColumn(name="propert_id", nullable=true)
    private Property property;

    public PropertyFiles(String name) {
        this.name = name;
    }
}

