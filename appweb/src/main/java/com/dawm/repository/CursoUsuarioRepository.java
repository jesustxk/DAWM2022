package com.dawm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dawm.model.entity.CursoUsuario;

@Repository
public interface CursoUsuarioRepository extends JpaRepository<CursoUsuario, Long> {

    @Query(value = "SELECT SUM(c.VALORACION) AS VALORACION FROM CURSO c WHERE c.ID_CURSO = :idCurso", nativeQuery = true)
    Integer getValoracionByIdCurso(@Param("idCurso") Long idCurso);

}
