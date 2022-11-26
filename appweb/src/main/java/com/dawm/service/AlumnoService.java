package com.dawm.service;

import com.dawm.model.dto.AlumnoDTO;
import com.dawm.model.entity.Alumno;

public interface AlumnoService {
    
    public Alumno insertAlumno(AlumnoDTO alumnoDTO);
    
}
