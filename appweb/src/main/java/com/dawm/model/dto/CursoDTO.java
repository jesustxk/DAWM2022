package com.dawm.model.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class CursoDTO {
    
    private Long id;

    private String codigo;

    private String titulo;

    private String descripcion;

    private Date fechaAlta;
    
}
