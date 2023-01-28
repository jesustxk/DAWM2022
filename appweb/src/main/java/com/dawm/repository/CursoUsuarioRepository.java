package com.dawm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
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

    @Query(value = "DELETE FROM CURSO_USUARIO cu WHERE cu.ID_CURSO = :idCurso", nativeQuery = true)
    Long deleteByIdCurso(@Param("idCurso") Long idCurso);

}
