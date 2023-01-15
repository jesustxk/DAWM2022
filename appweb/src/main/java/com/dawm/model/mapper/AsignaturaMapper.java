package com.dawm.model.mapper;

import org.mapstruct.Mapper;

import com.dawm.model.dto.AsignaturaDTO;
import com.dawm.model.entity.Asignatura;

@Mapper(componentModel = "spring")
public interface AsignaturaMapper {

    Asignatura asAsignatura(AsignaturaDTO asignaturaDTO);

    AsignaturaDTO asAsignaturaDTO(Asignatura asignatura);
    
}
