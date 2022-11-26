package com.dawm.model.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class AlumnoDTO {
    
    private Long id;

    private String dni;

    private String nombre;

    private Integer edad;

    private Date fechaAlta;
    
}
