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
    public List<ListaCurso> getCursosNoMatriculadosNoPropietario(Long idUsuario) {
        List<ListaCurso> tablaCursos = new ArrayList<>();
        tablaCursos.add(new ListaCurso());

        int cont = 0;
        int cont2 = 0;

        List<CursoDTO> cursos = this.cursoMapper.asCursoDTOList(this.cursoRepository.getCursosNoPropietario(idUsuario));

        for (CursoDTO curso : cursos) {
            if (cont2 == cursos.size()) {
                cont2 = 0;

                tablaCursos.add(new ListaCurso());
                cont++;
            }

            // Info extra por cada curso
            this.setInfoExtraCurso(curso);

            // Para bloquear el inscribirse
            this.isInscrito(curso, idUsuario, curso.getIdCurso());

            tablaCursos.get(cont).addCursoDTO(curso);

            cont2++;
        }

        return tablaCursos;
    }

    @Override
    public List<CursoDTO> getCursosPendientes(Long idUsuario) {
        return this.prepararListaCursos(
                this.cursoMapper.asCursoDTOList(this.cursoRepository.getCursosPendientes(idUsuario)));
    }

    @Override
    public List<CursoDTO> getCursosEnProgreso(Long idUsuario) {
        return this.prepararListaCursos(
                this.cursoMapper.asCursoDTOList(this.cursoRepository.getCursosEnProgreso(idUsuario)));
    }

    @Override
    public List<CursoDTO> getCursosCompletados(Long idUsuario) {
        return this.prepararListaCursos(
                this.cursoMapper.asCursoDTOList(this.cursoRepository.getCursosCompletados(idUsuario)));
    }

    @Override
    public List<ListaCurso> getMisCursos(UsuarioDTO usuarioDTO) {
        return this.prepararTablaCursos(
                this.cursoMapper
                        .asCursoDTOList(this.cursoRepository.findByUsuario(this.usuarioMapper.asUsuario(usuarioDTO))));
    }

    @Override
    public List<ListaCurso> getTopCursos() {
        return this.prepararTablaCursos(
                this.cursoMapper.asCursoDTOList(this.cursoRepository.getTopCursos()));
    }

    @Override
    public void addCurso(CursoDTO curso) {
        curso.setCodigo((int) ((Math.random() * (1000 - 1)) + 1) + curso.getTitulo().substring(0, 3));
        curso.setFechaAlta(new Date(System.currentTimeMillis()));

        this.cursoRepository.save(this.cursoMapper.asCurso(curso));
    }

    @Override
    public void editarCurso(CursoDTO curso) {
        this.cursoRepository.save(this.cursoMapper.asCurso(curso));
    }

    @Override
    public void borrarCurso(CursoDTO curso) {
        this.cursoUsuarioService
                .deleteFromIdCursoUsuarioList(this.cursoUsuarioService.getCursoUsuarioByIdCurso(curso.getIdCurso()));
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

    private List<CursoDTO> prepararListaCursos(List<CursoDTO> cursos) {
        for (CursoDTO curso : cursos) {
            // Info extra por cada curso
            this.setInfoExtraCurso(curso);
        }

        return cursos;
    }

    private void isInscrito(CursoDTO curso, Long idUsuario, Long idCurso) {
        curso.setInscrito(this.cursoUsuarioService.isInscrito(idUsuario, idCurso));
    }

}
