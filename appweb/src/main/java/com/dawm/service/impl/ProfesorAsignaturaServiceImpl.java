package com.dawm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawm.model.dto.ProfesorAsignaturaDTO;
import com.dawm.model.mapper.ProfesorAsignaturaMapper;
import com.dawm.repository.ProfesorAsignaturaRepository;
import com.dawm.service.ProfesorAsignaturaService;

@Service
public class ProfesorAsignaturaServiceImpl implements ProfesorAsignaturaService {
    
    @Autowired
    private ProfesorAsignaturaRepository profesorAsignaturaRepository;

    @Autowired
    private ProfesorAsignaturaMapper profesorAsignaturaMapper;

    @Override
    public Long insertProfesorAsignatura(ProfesorAsignaturaDTO profesorAsignaturaDTO) {
        return this.profesorAsignaturaRepository.save(
            this.profesorAsignaturaMapper.profesorAsignaturaDTOToProfesorAsignatura(profesorAsignaturaDTO)).getId();
    }

}
