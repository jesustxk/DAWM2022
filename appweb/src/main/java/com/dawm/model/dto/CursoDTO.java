package com.dawm.model.dto;

import java.io.Serializable;
import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class CursoDTO implements Serializable {
    
    private Long idCurso;

    private String codigo;

    private String titulo;

    private String descripcion;

	private Date fechaAlta;

    private MultipartFile imagen;

    private String enlace;

    private UsuarioDTO usuarioDTO;

    private Integer personasInscritas;

    private Integer valoracion;
    
}
