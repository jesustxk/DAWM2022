package com.dawm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dawm.model.entity.Authorities;

@Repository
public interface AuthoritiesRepository extends JpaRepository<Authorities, Long> {
    
}
