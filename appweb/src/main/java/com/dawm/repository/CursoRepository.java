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

    @Query(value = "SELECT c.* FROM CURSO c INNER JOIN CURSO_USUARIO cu ON c.ID_CURSO = cu.ID_CURSO WHERE cu.ID_USUARIO = :idUsuario", nativeQuery = true)
    List<Curso> getCursosMatriculados(@Param("idUsuario") Long idUsuario);

}
