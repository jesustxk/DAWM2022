package com.dawm.model.mapper;

import org.mapstruct.Mapper;

import com.dawm.model.dto.CursoDTO;
import com.dawm.model.entity.Curso;

@Mapper(componentModel = "spring")
public interface CursoMapper {

    Curso asCurso(CursoDTO cursoDTO);
    
    CursoDTO asCursoDTO(Curso curso);

}
