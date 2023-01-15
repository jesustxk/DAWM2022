package com.dawm.model.mapper;

import com.dawm.model.dto.AlumnoAsignaturaDTO;
import com.dawm.model.entity.AlumnoAsignatura;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-15T19:11:48+0100",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.200.v20221012-0724, environment: Java 17.0.5 (Eclipse Adoptium)"
)
@Component
public class AlumnoAsignaturaMapperImpl implements AlumnoAsignaturaMapper {

    @Override
    public AlumnoAsignatura asAlumnoAsignatura(AlumnoAsignaturaDTO alumnoAsignaturaDTO) {
        if ( alumnoAsignaturaDTO == null ) {
            return null;
        }

        AlumnoAsignatura alumnoAsignatura = new AlumnoAsignatura();

        alumnoAsignatura.setFechaAlta( alumnoAsignaturaDTO.getFechaAlta() );
        alumnoAsignatura.setId( alumnoAsignaturaDTO.getId() );
        if ( alumnoAsignaturaDTO.getIdAlumno() != null ) {
            alumnoAsignatura.setIdAlumno( Long.parseLong( alumnoAsignaturaDTO.getIdAlumno() ) );
        }
        if ( alumnoAsignaturaDTO.getIdAsignatura() != null ) {
            alumnoAsignatura.setIdAsignatura( Long.parseLong( alumnoAsignaturaDTO.getIdAsignatura() ) );
        }

        return alumnoAsignatura;
    }

    @Override
    public AlumnoAsignaturaDTO asAlumnoAsignaturaDTO(AlumnoAsignatura alumnoAsignatura) {
        if ( alumnoAsignatura == null ) {
            return null;
        }

        AlumnoAsignaturaDTO alumnoAsignaturaDTO = new AlumnoAsignaturaDTO();

        alumnoAsignaturaDTO.setFechaAlta( alumnoAsignatura.getFechaAlta() );
        alumnoAsignaturaDTO.setId( alumnoAsignatura.getId() );
        if ( alumnoAsignatura.getIdAlumno() != null ) {
            alumnoAsignaturaDTO.setIdAlumno( String.valueOf( alumnoAsignatura.getIdAlumno() ) );
        }
        if ( alumnoAsignatura.getIdAsignatura() != null ) {
            alumnoAsignaturaDTO.setIdAsignatura( String.valueOf( alumnoAsignatura.getIdAsignatura() ) );
        }

        return alumnoAsignaturaDTO;
    }
}
