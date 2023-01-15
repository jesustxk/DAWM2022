package com.dawm.model.mapper;

import com.dawm.model.dto.ProfesorAsignaturaDTO;
import com.dawm.model.entity.ProfesorAsignatura;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-15T19:11:48+0100",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.200.v20221012-0724, environment: Java 17.0.5 (Eclipse Adoptium)"
)
@Component
public class ProfesorAsignaturaMapperImpl implements ProfesorAsignaturaMapper {

    @Override
    public ProfesorAsignatura asProfesorAsignatura(ProfesorAsignaturaDTO profesorAsignaturaDTO) {
        if ( profesorAsignaturaDTO == null ) {
            return null;
        }

        ProfesorAsignatura profesorAsignatura = new ProfesorAsignatura();

        profesorAsignatura.setFechaAlta( profesorAsignaturaDTO.getFechaAlta() );
        profesorAsignatura.setId( profesorAsignaturaDTO.getId() );
        if ( profesorAsignaturaDTO.getIdAsignatura() != null ) {
            profesorAsignatura.setIdAsignatura( Long.parseLong( profesorAsignaturaDTO.getIdAsignatura() ) );
        }
        if ( profesorAsignaturaDTO.getIdProfesor() != null ) {
            profesorAsignatura.setIdProfesor( Long.parseLong( profesorAsignaturaDTO.getIdProfesor() ) );
        }

        return profesorAsignatura;
    }

    @Override
    public ProfesorAsignaturaDTO asProfesorAsignaturaDTO(ProfesorAsignatura profesorAsignatura) {
        if ( profesorAsignatura == null ) {
            return null;
        }

        ProfesorAsignaturaDTO profesorAsignaturaDTO = new ProfesorAsignaturaDTO();

        profesorAsignaturaDTO.setFechaAlta( profesorAsignatura.getFechaAlta() );
        profesorAsignaturaDTO.setId( profesorAsignatura.getId() );
        if ( profesorAsignatura.getIdAsignatura() != null ) {
            profesorAsignaturaDTO.setIdAsignatura( String.valueOf( profesorAsignatura.getIdAsignatura() ) );
        }
        if ( profesorAsignatura.getIdProfesor() != null ) {
            profesorAsignaturaDTO.setIdProfesor( String.valueOf( profesorAsignatura.getIdProfesor() ) );
        }

        return profesorAsignaturaDTO;
    }
}
