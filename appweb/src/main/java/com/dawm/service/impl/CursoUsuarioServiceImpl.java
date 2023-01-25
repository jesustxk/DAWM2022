package com.dawm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawm.repository.CursoUsuarioRepository;
import com.dawm.service.CursoUsuarioService;

@Service
public class CursoUsuarioServiceImpl implements CursoUsuarioService {

    @Autowired
    private CursoUsuarioRepository cursoUsuarioRepository;
    
    @Override
    public Integer getValoracionByIdCurso(Long idCurso) {
        return this.cursoUsuarioRepository.getValoracionByIdCurso(idCurso);
    }

    @Override
    public Integer countMatriculados(Long idCurso) {
        return this.cursoUsuarioRepository.countMatriculados(idCurso);
    }

}
