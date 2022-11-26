package com.dawm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawm.model.dto.AlumnoAsignaturaDTO;
import com.dawm.model.mapper.AlumnoAsignaturaMapper;
import com.dawm.repository.AlumnoAsignaturaRepository;
import com.dawm.service.AlumnoAsignaturaService;

@Service
public class AlumnoAsignaturaServiceImpl implements AlumnoAsignaturaService {

    @Autowired
    private AlumnoAsignaturaRepository alumnoAsignaturaRepository;

    @Autowired
    private AlumnoAsignaturaMapper alumnoAsignaturaMapper;
    
    @Override
    public Long insertAlumnoAsignatura(AlumnoAsignaturaDTO alumnoAsignaturaDTO) {
        return this.alumnoAsignaturaRepository.save(
            alumnoAsignaturaMapper.alumnoAsignaturaDTOToAlumnoAsignatura(alumnoAsignaturaDTO)).getId();
    }
    
}
