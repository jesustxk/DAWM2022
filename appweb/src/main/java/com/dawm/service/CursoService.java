package com.dawm.service;

import java.util.List;

import com.dawm.model.dto.CursoDTO;
import com.dawm.model.util.ListaCurso;

public interface CursoService {
    
    public String insertCurso(CursoDTO cursoDTO);

    public List<ListaCurso> getListaCursosDTO();

}
