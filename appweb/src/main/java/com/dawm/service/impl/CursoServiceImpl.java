package com.dawm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawm.model.dto.CursoDTO;
import com.dawm.model.dto.UsuarioDTO;
import com.dawm.model.mapper.CursoMapper;
import com.dawm.model.mapper.UsuarioMapper;
import com.dawm.model.util.ListaCurso;
import com.dawm.repository.CursoRepository;
import com.dawm.service.CursoService;
import com.dawm.service.CursoUsuarioService;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoUsuarioService cursoUsuarioService;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Autowired
    private CursoMapper cursoMapper;
    
    @Override
    public String insertCurso(CursoDTO cursoDTO) {
        return this.cursoRepository.save(
            this.cursoMapper.asCurso(cursoDTO)).getCodigo();
    }

    @Override
    public List<ListaCurso> getAllCursos() {

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

    @Override
    public List<ListaCurso> getCursosMatriculados(Long idUsuario) {

        List<ListaCurso> tablaCursos = new ArrayList<>();
        tablaCursos.add(new ListaCurso());

        List<CursoDTO> cursos = this.cursoMapper.asCursoDTOList(this.cursoRepository.getCursosMatriculados(idUsuario));

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

    @Override
    public List<ListaCurso> getCursosPropietario(UsuarioDTO usuarioDTO) {

        List<ListaCurso> tablaCursos = new ArrayList<>();
        tablaCursos.add(new ListaCurso());

        List<CursoDTO> cursos = this.cursoMapper.asCursoDTOList(this.cursoRepository.findByUsuario(this.usuarioMapper.asUsuario(usuarioDTO)));

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

    @Override
    public List<ListaCurso> getTopCursos() {

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

            curso.setValoracion(this.cursoUsuarioService.getValoracionByIdCurso(curso.getIdCurso()));
    		
    		tablaCursos.get(cont).addCursoDTO(curso);
    		
    		cont2++;
        }
        
        return tablaCursos;
    }

}
