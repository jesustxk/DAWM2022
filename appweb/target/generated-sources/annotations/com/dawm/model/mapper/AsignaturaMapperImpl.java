package com.dawm.model.mapper;

import com.dawm.model.dto.AsignaturaDTO;
import com.dawm.model.entity.Asignatura;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-15T19:11:48+0100",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.200.v20221012-0724, environment: Java 17.0.5 (Eclipse Adoptium)"
)
@Component
public class AsignaturaMapperImpl implements AsignaturaMapper {

    @Override
    public Asignatura asAsignatura(AsignaturaDTO asignaturaDTO) {
        if ( asignaturaDTO == null ) {
            return null;
        }

        Asignatura asignatura = new Asignatura();

        asignatura.setCodigo( asignaturaDTO.getCodigo() );
        asignatura.setFechaAlta( asignaturaDTO.getFechaAlta() );
        asignatura.setId( asignaturaDTO.getId() );
        asignatura.setNombre( asignaturaDTO.getNombre() );

        return asignatura;
    }

    @Override
    public AsignaturaDTO asAsignaturaDTO(Asignatura asignatura) {
        if ( asignatura == null ) {
            return null;
        }

        AsignaturaDTO asignaturaDTO = new AsignaturaDTO();

        asignaturaDTO.setCodigo( asignatura.getCodigo() );
        asignaturaDTO.setFechaAlta( asignatura.getFechaAlta() );
        asignaturaDTO.setId( asignatura.getId() );
        asignaturaDTO.setNombre( asignatura.getNombre() );

        return asignaturaDTO;
    }
}
