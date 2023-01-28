package com.dawm.service.impl;

import java.sql.Date;
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
        return this.prepararTablaCursos(
            this.cursoMapper.asCursoDTOList(this.cursoRepository.findAll()));
    }

    @Override
    public List<ListaCurso> getCursosMatriculados(Long idUsuario) {
        return this.prepararTablaCursos(
            this.cursoMapper.asCursoDTOList(this.cursoRepository.getCursosMatriculados(idUsuario)));
    }

    @Override
    public List<ListaCurso> getMisCursos(UsuarioDTO usuarioDTO) {
        return this.prepararTablaCursos(
            this.cursoMapper.asCursoDTOList(this.cursoRepository.findByUsuario(this.usuarioMapper.asUsuario(usuarioDTO))));
    }

    @Override
    public List<ListaCurso> getTopCursos() {
        return this.prepararTablaCursos(
            this.cursoMapper.asCursoDTOList(this.cursoRepository.getTopCursos()));
    }

    @Override
    public void addCurso(CursoDTO curso) {
        curso.setCodigo((int)((Math.random() * (1000 - 1)) + 1) + curso.getTitulo().substring(0, 3));
        curso.setFechaAlta(new Date(System.currentTimeMillis()));
        
        this.cursoRepository.save(this.cursoMapper.asCurso(curso));
    }

    @Override
    public void editarCurso(CursoDTO curso) {
        this.cursoRepository.save(this.cursoMapper.asCurso(curso));
    }

    @Override
    public void borrarCurso(CursoDTO curso) {
        this.cursoUsuarioService.deleteFromIdCurso(curso.getIdCurso());
        this.cursoRepository.delete(this.cursoMapper.asCurso(curso));
    }

    private List<ListaCurso> prepararTablaCursos(List<CursoDTO> cursos) {
        List<ListaCurso> tablaCursos = new ArrayList<>();
        tablaCursos.add(new ListaCurso());

        int cont = 0;
        int cont2 = 0;

        for (CursoDTO curso : cursos) {
            if (cont2 == cursos.size()) {
    			cont2 = 0;
    			
    			tablaCursos.add(new ListaCurso());
                cont++;
    		}

            // Info extra por cada curso
            this.setInfoExtraCurso(curso);
    		
    		tablaCursos.get(cont).addCursoDTO(curso);
    		
    		cont2++;
        }
        
        return tablaCursos;
    }

    private void setInfoExtraCurso(CursoDTO curso) {
        curso.setValoracion(this.cursoUsuarioService.getValoracionByIdCurso(curso.getIdCurso()));

        curso.setPersonasInscritas(this.cursoUsuarioService.countMatriculados(curso.getIdCurso()));
    }

}
