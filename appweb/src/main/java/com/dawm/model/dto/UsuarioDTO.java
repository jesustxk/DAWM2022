package com.dawm.model.dto;

import java.io.Serializable;
import java.sql.Date;

import lombok.Data;

@Data
public class UsuarioDTO implements Serializable {
    
    private Long idUsuario;

    private String username;

    private String password;

    private Boolean enabled;

    private String email;

    private String nombre;

    private Integer edad;

    private String descripcion;
    
	private Date fechaAlta;

}
