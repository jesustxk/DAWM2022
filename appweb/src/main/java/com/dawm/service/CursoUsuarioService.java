package com.dawm.service;

public interface CursoUsuarioService {
    
    public Integer getValoracionByIdCurso(Long idCurso);

    public Integer countMatriculados(Long idCurso);

    public void inscribirse(Long idUsuario, Long idCurso);

    public Integer getValoracionByIdCursoAndIdUsuario(Long idCurso, Long idUsuario);

    public void deleteFromIdCurso(Long idCurso);

}
