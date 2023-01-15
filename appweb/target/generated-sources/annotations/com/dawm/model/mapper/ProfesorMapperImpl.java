package com.dawm.model.mapper;

import com.dawm.model.dto.ProfesorDTO;
import com.dawm.model.entity.Profesor;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-15T19:11:48+0100",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.200.v20221012-0724, environment: Java 17.0.5 (Eclipse Adoptium)"
)
@Component
public class ProfesorMapperImpl implements ProfesorMapper {

    @Override
    public Profesor asProfesor(ProfesorDTO profesorDTO) {
        if ( profesorDTO == null ) {
            return null;
        }

        Profesor profesor = new Profesor();

        profesor.setDni( profesorDTO.getDni() );
        profesor.setEdad( profesorDTO.getEdad() );
        profesor.setFechaAlta( profesorDTO.getFechaAlta() );
        profesor.setId( profesorDTO.getId() );
        profesor.setNombre( profesorDTO.getNombre() );

        return profesor;
    }

    @Override
    public ProfesorDTO asProfesorDTO(Profesor profesor) {
        if ( profesor == null ) {
            return null;
        }

        ProfesorDTO profesorDTO = new ProfesorDTO();

        profesorDTO.setDni( profesor.getDni() );
        profesorDTO.setEdad( profesor.getEdad() );
        profesorDTO.setFechaAlta( profesor.getFechaAlta() );
        profesorDTO.setId( profesor.getId() );
        profesorDTO.setNombre( profesor.getNombre() );

        return profesorDTO;
    }
}
