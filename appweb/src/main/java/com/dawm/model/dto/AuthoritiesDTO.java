package com.dawm.model.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class AuthoritiesDTO implements Serializable {
    
    private String username;

    private String authority;
    
}
