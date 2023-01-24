package com.dawm.model.dto;

import java.util.List;

import lombok.Data;

@Data
public class CursosUsuarioDTO {
    
    private List<UsuarioDTO> usuarios;

    private List<CursoDTO> cursos;

    private Integer valoracion;
}
