package com.dawm.service;

import java.util.List;

public interface CursoUsuarioService {
    
    public Integer getValoracionByIdCurso(Long idCurso);

    public Integer countMatriculados(Long idCurso);

    public void inscribirse(Long idUsuario, Long idCurso);

    public Integer getValoracionByIdCursoAndIdUsuario(Long idCurso, Long idUsuario);

    public void deleteFromIdCursoUsuario(Long idCursoUsuario);

    public void deleteFromIdCursoUsuarioList(List<Long> idCursoUsuarioList);

    public List<Long> getCursoUsuarioByIdCurso(Long idCurso);

    public void comenzarCurso(Long idCurso, Long idUsuario);

    public void completarCurso(Long idCurso, Long idUsuario);

}
