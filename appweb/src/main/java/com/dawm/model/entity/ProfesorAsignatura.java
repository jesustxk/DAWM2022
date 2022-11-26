package com.dawm.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "PROFESOR_ASIGNATURA")
public class ProfesorAsignatura {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ID_PROFESOR")
    private String idProfesor;

    @Column(name = "ID_ASIGNATURA")
    private String idAsignatura;

}
