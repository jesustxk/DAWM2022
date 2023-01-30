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
@Table(name = "AUTHORITIES")
public class Authorities implements Serializable {

    @Id
    @Column(name = "ID_AUTHORITIES")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_auth")
    @SequenceGenerator(name = "seq_auth", sequenceName="seq_auth", allocationSize = 1)
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "AUTHORITY")
    private String authority;

    @Column(name = "FECHA_ALTA", nullable = false)
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss.S")
	private Date fechaAlta;
    
}
