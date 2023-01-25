package com.dawm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dawm.model.entity.CursoUsuario;

@Repository
public interface CursoUsuarioRepository extends JpaRepository<CursoUsuario, Long> {

}
