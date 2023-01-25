package com.dawm.model.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class CursoUsuarioDTO implements Serializable {
    
    private Long idCursoUsuario;
    
    private Integer idCurso;

    private Integer idUsuario;

    private Integer valoracion;

    private Boolean completado;
    
}
