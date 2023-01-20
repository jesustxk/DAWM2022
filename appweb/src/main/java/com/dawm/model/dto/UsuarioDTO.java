package com.dawm.model.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class UsuarioDTO {
    
    private String username;

    private String password;

    private Boolean enabled;
    
    private String email;

    private String nombre;

    private Integer edad;

    private Date fechaAlta;

}
