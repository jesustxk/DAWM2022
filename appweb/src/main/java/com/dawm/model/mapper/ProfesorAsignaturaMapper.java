package com.dawm.model.mapper;

import org.mapstruct.Mapper;

import com.dawm.model.dto.ProfesorAsignaturaDTO;
import com.dawm.model.entity.ProfesorAsignatura;

@Mapper(componentModel = "spring")
public interface ProfesorAsignaturaMapper {

    ProfesorAsignatura asProfesorAsignatura(ProfesorAsignaturaDTO profesorAsignaturaDTO);

    ProfesorAsignaturaDTO asProfesorAsignaturaDTO(ProfesorAsignatura profesorAsignatura);
    
}
