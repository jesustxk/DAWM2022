package com.dawm.model.mapper;

import com.dawm.model.dto.CursoAsignaturaDTO;
import com.dawm.model.entity.CursoAsignatura;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-15T18:37:56+0100",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.200.v20221012-0724, environment: Java 17.0.5 (Eclipse Adoptium)"
)
@Component
public class CursoAsignaturaMapperImpl implements CursoAsignaturaMapper {

    @Override
    public CursoAsignatura asCursoAsignatura(CursoAsignaturaDTO cursoAsignaturaDTO) {
        if ( cursoAsignaturaDTO == null ) {
            return null;
        }

        CursoAsignatura cursoAsignatura = new CursoAsignatura();

        cursoAsignatura.setFechaAlta( cursoAsignaturaDTO.getFechaAlta() );
        cursoAsignatura.setId( cursoAsignaturaDTO.getId() );
        cursoAsignatura.setIdAsignatura( cursoAsignaturaDTO.getIdAsignatura() );
        cursoAsignatura.setIdCurso( cursoAsignaturaDTO.getIdCurso() );

        return cursoAsignatura;
    }

    @Override
    public CursoAsignaturaDTO asCursoAsignaturaDTO(CursoAsignatura cursoAsignatura) {
        if ( cursoAsignatura == null ) {
            return null;
        }

        CursoAsignaturaDTO cursoAsignaturaDTO = new CursoAsignaturaDTO();

        cursoAsignaturaDTO.setFechaAlta( cursoAsignatura.getFechaAlta() );
        cursoAsignaturaDTO.setId( cursoAsignatura.getId() );
        cursoAsignaturaDTO.setIdAsignatura( cursoAsignatura.getIdAsignatura() );
        cursoAsignaturaDTO.setIdCurso( cursoAsignatura.getIdCurso() );

        return cursoAsignaturaDTO;
    }
}
