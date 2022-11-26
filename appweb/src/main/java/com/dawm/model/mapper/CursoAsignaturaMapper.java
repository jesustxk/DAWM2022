package com.dawm.model.mapper;

import org.mapstruct.Mapper;

import com.dawm.model.dto.CursoAsignaturaDTO;
import com.dawm.model.entity.CursoAsignatura;

@Mapper(componentModel = "spring")
public interface CursoAsignaturaMapper {
    
    CursoAsignaturaDTO cursoAsignaturaToCursoAsignaturaDTO(CursoAsignatura cursoAsignatura);

    CursoAsignatura cursoAsignaturaDTOToCursoAsignatura(CursoAsignaturaDTO cursoAsignaturaDTO);
    
}
