package com.dawm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawm.model.dto.AsignaturaDTO;
import com.dawm.model.mapper.AsignaturaMapper;
import com.dawm.repository.AsignaturaRepository;
import com.dawm.service.AsignaturaService;

@Service
public class AsignaturaServiceImpl implements AsignaturaService {
    
    @Autowired
    private AsignaturaRepository asignaturaRepository;

    @Autowired
    private AsignaturaMapper asignaturaMapper;

    @Override
    public String insertAsignatura(AsignaturaDTO asignaturaDTO) {
        return this.asignaturaRepository.save(
            this.asignaturaMapper.asAsignatura(asignaturaDTO)).getCodigo();
    }

}
