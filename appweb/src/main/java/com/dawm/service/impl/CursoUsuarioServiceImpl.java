package com.dawm.service.impl;

import java.sql.Date;
import java.util.List;

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
        cursoUsuario.setFechaAlta(new Date(System.currentTimeMillis()));
        cursoUsuario.setIniciado(false);
        cursoUsuario.setCompletado(false);

        if (this.cursoUsuarioRepository.findByIdCursoAndIdUsuario(idCurso, idUsuario) == null) {
            this.cursoUsuarioRepository.save(this.cursoUsuarioMapper.asCursoUsuario(cursoUsuario));
        }
    }

    @Override
    public Integer getValoracionByIdCursoAndIdUsuario(Long idCurso, Long idUsuario) {
        return this.cursoUsuarioRepository.findByIdCursoAndIdUsuario(idCurso, idUsuario).getValoracion();
    }

    @Override
    public void deleteFromIdCursoUsuario(Long idCursoUsuario) {
        this.cursoUsuarioRepository.deleteById(idCursoUsuario);
    }

    @Override
    public void deleteFromIdCursoUsuarioList(List<Long> idCursoUsuarioList) {
        this.cursoUsuarioRepository.deleteAllByIdInBatch(idCursoUsuarioList);
    }

    @Override
    public List<Long> getCursoUsuarioByIdCurso(Long idCurso) {
        return this.cursoUsuarioRepository.getCursoUsuarioByIdCurso(idCurso);
    }

    @Override
    public void comenzarCurso(Long idCurso, Long idUsuario) {
        this.cursoUsuarioRepository.comenzarCurso(idCurso, idUsuario);
    }

    @Override
    public void completarCurso(Long idCurso, Long idUsuario) {
        this.cursoUsuarioRepository.completarCurso(idCurso, idUsuario);
    }

}
