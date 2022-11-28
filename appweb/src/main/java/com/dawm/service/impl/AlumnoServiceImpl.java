package com.dawm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawm.model.dto.AlumnoDTO;
import com.dawm.model.mapper.AlumnoMapper;
import com.dawm.repository.AlumnoRepository;
import com.dawm.service.AlumnoService;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private AlumnoMapper alumnoMapper;

    @Override
    public String insertAlumno(AlumnoDTO alumnoDTO) {
        return this.alumnoRepository.save(
            this.alumnoMapper.asAlumno(alumnoDTO)).getDni();
    }

}
