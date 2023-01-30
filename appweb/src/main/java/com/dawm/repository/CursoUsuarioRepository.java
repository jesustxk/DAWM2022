package com.dawm.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dawm.model.entity.CursoUsuario;

@Repository
public interface CursoUsuarioRepository extends JpaRepository<CursoUsuario, Long> {

    CursoUsuario findByIdCursoAndIdUsuario(Long idCurso, Long idUsuario);

    @Query(value = "SELECT COALESCE(AVG(cu.VALORACION), 0) AS VALORACION FROM CURSO_USUARIO cu WHERE cu.ID_CURSO = :idCurso", nativeQuery = true)
    Integer getValoracionByIdCurso(@Param("idCurso") Long idCurso);

    @Query(value = "SELECT COALESCE(COUNT(cu.ID_CURSO_USUARIO), 0) AS VALORACION FROM CURSO_USUARIO cu WHERE cu.ID_CURSO = :idCurso AND cu.COMPLETADO IS NULL", nativeQuery = true)
    Integer countMatriculados(@Param("idCurso") Long idCurso);

    @Query(value = "SELECT cu.ID_CURSO_USUARIO FROM CURSO_USUARIO cu WHERE cu.ID_CURSO = :idCurso", nativeQuery = true)
    List<Long> getCursoUsuarioByIdCurso(@Param("idCurso") Long idCurso);

    @Query(value = "SELECT COALESCE(COUNT(cu.ID_CURSO_USUARIO), 0) AS INSCRITO FROM CURSO_USUARIO cu WHERE cu.ID_USUARIO = :idUsuario AND cu.ID_CURSO = :idCurso", nativeQuery = true)
    Integer isInscrito(@Param("idUsuario")Long idUsuario, @Param("idCurso")Long idCurso);

    @Transactional
    @Modifying
    @Query(value = "UPDATE CURSO_USUARIO cu SET cu.INICIADO = TRUE WHERE cu.ID_CURSO = :idCurso AND cu.ID_USUARIO = :idUsuario", nativeQuery = true)
    void comenzarCurso(@Param("idCurso") Long idCurso, @Param("idUsuario") Long idUsuario);

    @Transactional
    @Modifying
    @Query(value = "UPDATE CURSO_USUARIO cu SET cu.COMPLETADO = TRUE WHERE cu.ID_CURSO = :idCurso AND cu.ID_USUARIO = :idUsuario", nativeQuery = true)
    void completarCurso(@Param("idCurso") Long idCurso, @Param("idUsuario") Long idUsuario);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM CURSO_USUARIO cu WHERE cu.ID_CURSO = :idCurso AND cu.ID_USUARIO = :idUsuario", nativeQuery = true)
    void desinscribirse(@Param("idUsuario") Long idUsuario, @Param("idCurso") Long idCurso);

}
