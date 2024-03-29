package com.dawm.model.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "CURSO")
public class Curso implements Serializable {
    
    @Id
    @Column(name = "ID_CURSO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_curso")
    @SequenceGenerator(name = "seq_curso", sequenceName = "seq_curso", allocationSize = 1)
    private Long idCurso;

    @Column(name = "CODIGO", nullable = false, unique = true)
    private String codigo;

    @Column(name = "TITULO", nullable = false, unique = true)
    private String titulo;

    @Column(name = "DESCRIPCION", nullable = false, unique = true)
    private String descripcion;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "IMAGEN", columnDefinition = "LONGBLOB")
    private String imagen;

    @Column(name = "ENLACE")
    private String enlace;

    @JoinColumn(name = "ID_USUARIO")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;

    @Column(name = "FECHA_ALTA", nullable = false)
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss.S")
	private Date fechaAlta;

}
