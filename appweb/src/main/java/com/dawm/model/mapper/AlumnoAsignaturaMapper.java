package com.dawm.model.mapper;

import org.mapstruct.Mapper;

import com.dawm.model.dto.AlumnoAsignaturaDTO;
import com.dawm.model.entity.AlumnoAsignatura;

@Mapper(componentModel = "spring")
public interface AlumnoAsignaturaMapper {

    AlumnoAsignatura asAlumnoAsignatura(AlumnoAsignaturaDTO alumnoAsignaturaDTO);

    AlumnoAsignaturaDTO asAlumnoAsignaturaDTO(AlumnoAsignatura alumnoAsignatura);
    
}
