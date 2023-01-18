package com.dawm.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "AUTHORITIES")
public class Authorities {

    @Id
    @Column(name = "USERNAME")
    private String username;

    @Column(name = "AUTHORITY")
    private String authority;
    
}
