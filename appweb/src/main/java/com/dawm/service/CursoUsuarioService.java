package com.dawm.service;

public interface CursoUsuarioService {
    
    public Integer getValoracionByIdCurso(Long idCurso);

    public Integer countMatriculados(Long idCurso);

}