package com.dawm.model.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class CursoAsignaturaDTO {

    private Long id;

    private Long idCurso;

    private Long idAsignatura;

    private Date fechaAlta;

}
