package com.dawm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawm.model.dto.CursoDTO;
import com.dawm.model.mapper.CursoMapper;
import com.dawm.repository.CursoRepository;
import com.dawm.service.CursoService;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private CursoMapper cursoMapper;
    
    @Override
    public String insertCurso(CursoDTO cursoDTO) {
        return this.cursoRepository.save(
            this.cursoMapper.cursoDTOToCurso(cursoDTO)).getCodigo();
    }

}
