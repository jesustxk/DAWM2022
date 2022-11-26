package com.dawm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawm.model.dto.CursoAsignaturaDTO;
import com.dawm.model.mapper.CursoAsignaturaMapper;
import com.dawm.repository.CursoAsignaturaRepository;
import com.dawm.service.CursoAsignaturaService;

@Service
public class CursoAsignaturaServiceImpl implements CursoAsignaturaService {

    @Autowired
    private CursoAsignaturaRepository cursoAsignaturaRepository;

    @Autowired
    private CursoAsignaturaMapper cursoAsignaturaMapper;
    
    @Override
    public Long insertCursoAsignatura(CursoAsignaturaDTO cursoAsignaturaDTO) {
        return this.cursoAsignaturaRepository.save(
            this.cursoAsignaturaMapper.cursoAsignaturaDTOToCursoAsignatura(cursoAsignaturaDTO)).getId();
    }

}
