package com.dawm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawm.model.dto.ProfesorDTO;
import com.dawm.model.mapper.ProfesorMapper;
import com.dawm.repository.ProfesorRepository;
import com.dawm.service.ProfesorService;

@Service
public class ProfesorServiceImpl implements ProfesorService {
    
    @Autowired
    private ProfesorRepository profesorRepository;

    @Autowired
    private ProfesorMapper profesorMapper;

    @Override
    public String insertProfesor(ProfesorDTO profesorDTO) {
        return this.profesorRepository.save(
            this.profesorMapper.profesorDTOToProfesor(profesorDTO)).getDni();
    }

}
