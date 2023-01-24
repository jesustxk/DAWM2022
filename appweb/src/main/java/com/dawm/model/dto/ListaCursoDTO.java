package com.dawm.model.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ListaCursoDTO {
    
    private List<CursoDTO> cursos = new ArrayList<>();

    public void addCursoDTO(CursoDTO cursoDTO) {
        this.cursos.add(cursoDTO);
    }

}
