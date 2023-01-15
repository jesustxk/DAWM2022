package com.dawm.model.mapper;

import org.mapstruct.Mapper;

import com.dawm.model.dto.AlumnoDTO;
import com.dawm.model.entity.Alumno;

@Mapper(componentModel = "spring")
public interface AlumnoMapper {

    Alumno asAlumno(AlumnoDTO alumnoDTO);
    
    AlumnoDTO asAlumnoDTO(Alumno alumno);

}
