package com.dawm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawm.model.dto.CursoUsuarioDTO;
import com.dawm.model.mapper.CursoUsuarioMapper;
import com.dawm.repository.CursoUsuarioRepository;
import com.dawm.service.CursoUsuarioService;

@Service
public class CursoUsuarioServiceImpl implements CursoUsuarioService {

    @Autowired
    private CursoUsuarioRepository cursoUsuarioRepository;

    @Autowired
    private CursoUsuarioMapper cursoUsuarioMapper;
    
    @Override
    public Integer getValoracionByIdCurso(Long idCurso) {
        return this.cursoUsuarioRepository.getValoracionByIdCurso(idCurso);
    }

    @Override
    public Integer countMatriculados(Long idCurso) {
        return this.cursoUsuarioRepository.countMatriculados(idCurso);
    }

    @Override
    public void inscribirse(Long idUsuario, Long idCurso) {

        CursoUsuarioDTO cursoUsuario = new CursoUsuarioDTO();
        cursoUsuario.setIdCurso(idCurso);
        cursoUsuario.setIdUsuario(idUsuario);

        if (this.cursoUsuarioRepository.findByIdCursoAndIdUsuario(idCurso, idUsuario) == null) {
            this.cursoUsuarioRepository.save(this.cursoUsuarioMapper.asCursoUsuario(cursoUsuario));
        }
    }

    @Override
    public Integer getValoracionByIdCursoAndIdUsuario(Long idCurso, Long idUsuario) {
        return this.cursoUsuarioRepository.findByIdCursoAndIdUsuario(idCurso, idUsuario).getValoracion();
    }

}
