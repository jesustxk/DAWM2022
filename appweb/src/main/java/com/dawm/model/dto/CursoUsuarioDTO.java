package com.dawm.model.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class CursoUsuarioDTO implements Serializable {
    
    private Long idCursoUsuario;
    
    private Long idCurso;

    private Long idUsuario;

    private Integer valoracion;

    private Boolean iniciado;

    private Boolean completado;
    
}
