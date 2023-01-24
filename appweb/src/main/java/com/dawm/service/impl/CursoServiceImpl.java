package com.dawm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawm.model.dto.CursoDTO;
import com.dawm.model.mapper.CursoMapper;
import com.dawm.model.util.ListaCurso;
import com.dawm.repository.CursoRepository;
import com.dawm.service.CursoService;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private CursoMapper cursoMapper;
    
    @Override
    public String insertCurso(CursoDTO cursoDTO) {
        return this.cursoRepository.save(
            this.cursoMapper.asCurso(cursoDTO)).getCodigo();
    }

    @Override
    public List<ListaCurso> getListaCursosDTO() {

        List<ListaCurso> tablaCursos = new ArrayList<>();
        tablaCursos.add(new ListaCurso());

        List<CursoDTO> cursos = this.cursoMapper.asCursoDTOList(this.cursoRepository.findAll());

        int cont = 0;
        int cont2 = 0;

        for (CursoDTO curso : cursos) {
            if (cont2 == 4) {
    			cont2 = 0;
    			
    			tablaCursos.add(new ListaCurso());
                cont++;
    		}
    		
    		tablaCursos.get(cont).addCursoDTO(curso);
    		
    		cont2++;
        }
        
        return tablaCursos;
    }

}
