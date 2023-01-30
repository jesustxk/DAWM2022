package com.dawm.service;

import java.util.List;

import com.dawm.model.dto.CursoDTO;
import com.dawm.model.dto.UsuarioDTO;
import com.dawm.model.util.ListaCurso;

public interface CursoService {

    public List<ListaCurso> getCursosNoMatriculadosNoPropietario(Long idUsuario);

    public List<CursoDTO> getCursosPendientes(Long idUsuario);

    public List<CursoDTO> getCursosEnProgreso(Long idUsuario);

    public List<CursoDTO> getCursosCompletados(Long idUsuario);

    public List<ListaCurso> getMisCursos(UsuarioDTO usuarioDTO);

    public List<ListaCurso> getTopCursos();

    public void addCurso(CursoDTO curso);

    public void editarCurso(CursoDTO curso);

    public void borrarCurso(CursoDTO curso);

}
