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
@Table(name = "PROFESOR")
public class Profesor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DNI", nullable = false, unique = true)
    private String dni;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "EDAD")
    private Integer edad;
    
}
