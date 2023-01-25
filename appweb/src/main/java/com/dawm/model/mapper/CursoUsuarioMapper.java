package com.dawm.model.mapper;

import org.mapstruct.Mapper;

import com.dawm.model.dto.CursoUsuarioDTO;
import com.dawm.model.entity.CursoUsuario;

@Mapper(componentModel = "spring")
public interface CursoUsuarioMapper {

    CursoUsuario asCursoUsuario(CursoUsuarioDTO cursoUsuarioDTO);

    CursoUsuarioDTO asCursoUsuarioDTO(CursoUsuario cursoUsuario);

}
