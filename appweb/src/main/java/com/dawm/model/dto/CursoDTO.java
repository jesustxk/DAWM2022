package com.dawm.model.dto;

import java.io.Serializable;
import java.sql.Date;

import lombok.Data;

@Data
public class CursoDTO implements Serializable {
    
    private Long idCurso;

    private String codigo;

    private String titulo;

    private String descripcion;

	private Date fechaAlta;

    private byte[] imagen;

    private UsuarioDTO usuarioDTO;

    private Integer personasInscritas;

    private Integer valoracion;
    
}
