package com.dawm.model.util;

import java.util.ArrayList;
import java.util.List;

import com.dawm.model.dto.CursoDTO;

import lombok.Data;

@Data
public class ListaCurso {
    
    private List<CursoDTO> cursos = new ArrayList<>();

    public void addCursoDTO(CursoDTO cursoDTO) {
        this.cursos.add(cursoDTO);
    }

}
