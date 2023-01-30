package com.dawm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dawm.model.entity.Curso;
import com.dawm.model.entity.Usuario;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

    List<Curso> findByUsuario(Usuario usuario);

    @Query(value = "SELECT c.* FROM CURSO c INNER JOIN CURSO_USUARIO cu ON c.ID_CURSO = cu.ID_CURSO WHERE c.ID_USUARIO != :idUsuario AND cu.ID_USUARIO != :idUsuario", nativeQuery = true)
    List<Curso> getCursosNoMatriculadosNoPropietario(@Param("idUsuario") Long idUsuario);

    @Query(value = "SELECT c.* FROM CURSO c INNER JOIN CURSO_USUARIO cu ON c.ID_CURSO = cu.ID_CURSO WHERE cu.ID_USUARIO = :idUsuario AND cu.INICIADO IS FALSE AND cu.COMPLETADO IS FALSE", nativeQuery = true)
    List<Curso> getCursosPendientes(@Param("idUsuario") Long idUsuario);

    @Query(value = "SELECT c.* FROM CURSO c INNER JOIN CURSO_USUARIO cu ON c.ID_CURSO = cu.ID_CURSO WHERE cu.ID_USUARIO = :idUsuario AND cu.INICIADO IS TRUE AND cu.COMPLETADO IS FALSE", nativeQuery = true)
    List<Curso> getCursosEnProgreso(@Param("idUsuario") Long idUsuario);

    @Query(value = "SELECT c.* FROM CURSO c INNER JOIN CURSO_USUARIO cu ON c.ID_CURSO = cu.ID_CURSO WHERE cu.ID_USUARIO = :idUsuario AND cu.INICIADO IS TRUE AND cu.COMPLETADO IS TRUE", nativeQuery = true)
    List<Curso> getCursosCompletados(@Param("idUsuario") Long idUsuario);

    @Query(value = "SELECT c.* FROM CURSO c INNER JOIN CURSO_USUARIO cu ON c.ID_CURSO = cu.ID_CURSO WHERE cu.VALORACION >= 4", nativeQuery = true)
    List<Curso> getTopCursos();
    

}
