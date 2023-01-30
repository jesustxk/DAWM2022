package com.dawm.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "CURSO_USUARIO")
public class CursoUsuario {
    
    @Id
    @Column(name = "ID_CURSO_USUARIO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_curso_usuario")
    @SequenceGenerator(name = "seq_curso_usuario", sequenceName = "seq_curso_usuario", allocationSize = 1)
    private Long idCursoUsuario;

    @Column(name = "ID_CURSO", nullable = false)
    private Long idCurso;

    @Column(name = "ID_USUARIO", nullable = false)
    private Long idUsuario;

    @Column(name = "VALORACION")
    private Integer valoracion;

    @Column(name = "INICIADO")
    private Boolean iniciado;

    @Column(name = "COMPLETADO")
    private Boolean completado;

    @Column(name = "FECHA_ALTA", nullable = false)
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss.S")
	private Date fechaAlta;

}
