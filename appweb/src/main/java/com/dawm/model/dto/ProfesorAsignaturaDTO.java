package com.dawm.model.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class ProfesorAsignaturaDTO {
    
    private Long id;

    private String idProfesor;

    private String idAsignatura;

    private Date fechaAlta;

}
