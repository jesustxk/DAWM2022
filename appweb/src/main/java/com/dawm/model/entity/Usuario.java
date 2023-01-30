package com.dawm.model.entity;

import java.io.Serializable;
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
@Table(name = "USERS")
public class Usuario implements Serializable {

    @Id
    @Column(name = "ID_USUARIO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuario")
    @SequenceGenerator(name = "seq_usuario", sequenceName = "seq_usuario", allocationSize = 1)
    private Long idUsuario;
    
    @Column(name = "USERNAME", nullable = false, unique = true)
    private String username;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "ENABLED")
    private Boolean enabled;
    
    @Column(name = "EMAIL")
    private String email;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "EDAD")
    private Integer edad;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "FECHA_ALTA", nullable = false)
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss.S")
	private Date fechaAlta;
    
}
