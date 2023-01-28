package com.dawm.model.dto;

import java.io.Serializable;
import java.sql.Date;

import lombok.Data;

@Data
public class AuthoritiesDTO implements Serializable {

    private Long id;
    
    private String username;

    private String authority;

    private Date fechaAlta;
    
}
