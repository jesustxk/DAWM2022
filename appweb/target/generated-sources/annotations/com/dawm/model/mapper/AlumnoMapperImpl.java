package com.dawm.model.mapper;

import com.dawm.model.dto.AlumnoDTO;
import com.dawm.model.entity.Alumno;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-15T19:11:48+0100",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.200.v20221012-0724, environment: Java 17.0.5 (Eclipse Adoptium)"
)
@Component
public class AlumnoMapperImpl implements AlumnoMapper {

    @Override
    public Alumno asAlumno(AlumnoDTO alumnoDTO) {
        if ( alumnoDTO == null ) {
            return null;
        }

        Alumno alumno = new Alumno();

        alumno.setDni( alumnoDTO.getDni() );
        alumno.setEdad( alumnoDTO.getEdad() );
        alumno.setFechaAlta( alumnoDTO.getFechaAlta() );
        alumno.setId( alumnoDTO.getId() );
        alumno.setNombre( alumnoDTO.getNombre() );

        return alumno;
    }

    @Override
    public AlumnoDTO asAlumnoDTO(Alumno alumno) {
        if ( alumno == null ) {
            return null;
        }

        AlumnoDTO alumnoDTO = new AlumnoDTO();

        alumnoDTO.setDni( alumno.getDni() );
        alumnoDTO.setEdad( alumno.getEdad() );
        alumnoDTO.setFechaAlta( alumno.getFechaAlta() );
        alumnoDTO.setId( alumno.getId() );
        alumnoDTO.setNombre( alumno.getNombre() );

        return alumnoDTO;
    }
}
