package com.dawm.model.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class AlumnoAsignaturaDTO {
    
    private Long id;

    private String idAlumno;

    private String idAsignatura;

    private Date fechaAlta;
    
}
