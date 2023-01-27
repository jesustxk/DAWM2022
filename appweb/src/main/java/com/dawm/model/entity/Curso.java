package com.dawm.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "CURSO")
public class Curso {
    
    @Id
    @Column(name = "ID_CURSO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCurso;

    @Column(name = "CODIGO", nullable = false, unique = true)
    private String codigo;

    @Column(name = "TITULO")
    private String titulo;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "FECHA_ALTA", nullable = false)
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss.S")
	private Date fechaAlta;

    @Lob
    @Column(name = "IMAGEN")
    private byte[] imagen;

    @Column(name = "ENLACE")
    private String enlace;

    @JoinColumn(name = "ID_USUARIO")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;

}
