package com.dawm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dawm.model.entity.CursosUsuario;

@Repository
public interface CursosUsuarioRepository extends JpaRepository<CursosUsuario, Long> {

}
