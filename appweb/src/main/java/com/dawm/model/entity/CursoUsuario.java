package com.dawm.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "CURSO_USUARIO")
public class CursoUsuario {
    
    @Id
    @Column(name = "ID_CURSO_USUARIO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCursoUsuario;

    @Column(name = "ID_CURSO", nullable = false)
    private Long idCurso;

    @Column(name = "ID_USUARIO", nullable = false)
    private Long idUsuario;

    @Column(name = "VALORACION")
    private Integer valoracion;

    @Column(name = "COMPLETADO")
    private Boolean completado;

}
