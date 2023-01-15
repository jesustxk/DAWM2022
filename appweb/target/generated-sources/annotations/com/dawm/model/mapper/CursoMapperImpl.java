package com.dawm.model.mapper;

import com.dawm.model.dto.CursoDTO;
import com.dawm.model.entity.Curso;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-15T18:37:56+0100",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.200.v20221012-0724, environment: Java 17.0.5 (Eclipse Adoptium)"
)
@Component
public class CursoMapperImpl implements CursoMapper {

    @Override
    public Curso asCurso(CursoDTO cursoDTO) {
        if ( cursoDTO == null ) {
            return null;
        }

        Curso curso = new Curso();

        curso.setCodigo( cursoDTO.getCodigo() );
        curso.setFechaAlta( cursoDTO.getFechaAlta() );
        curso.setId( cursoDTO.getId() );
        curso.setNombre( cursoDTO.getNombre() );

        return curso;
    }

    @Override
    public CursoDTO asCursoDTO(Curso curso) {
        if ( curso == null ) {
            return null;
        }

        CursoDTO cursoDTO = new CursoDTO();

        cursoDTO.setCodigo( curso.getCodigo() );
        cursoDTO.setFechaAlta( curso.getFechaAlta() );
        cursoDTO.setId( curso.getId() );
        cursoDTO.setNombre( curso.getNombre() );

        return cursoDTO;
    }
}
