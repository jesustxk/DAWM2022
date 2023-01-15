package com.dawm.model.mapper;

import org.mapstruct.Mapper;

import com.dawm.model.dto.ProfesorDTO;
import com.dawm.model.entity.Profesor;

@Mapper(componentModel = "spring")
public interface ProfesorMapper {

    Profesor asProfesor(ProfesorDTO profesorDTO);

    ProfesorDTO asProfesorDTO(Profesor profesor);
    
}
