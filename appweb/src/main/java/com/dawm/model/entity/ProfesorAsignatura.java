package com.dawm.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(schema = "MATRICULA", name = "PROFESOR_ASIGNATURA")
public class ProfesorAsignatura {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ID_PROFESOR")
    private Long idProfesor;

    @Column(name = "ID_ASIGNATURA")
    private Long idAsignatura;

    @Column(name = "FECHA_ALTA", nullable = false)
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss.S")
	private Date fechaAlta;

}
