package com.dawm.model.mapper;

import org.mapstruct.Mapper;

import com.dawm.model.dto.AuthoritiesDTO;
import com.dawm.model.entity.Authorities;

@Mapper(componentModel = "spring")
public interface AuthoritiesMapper {
    
    Authorities asAuthorities(AuthoritiesDTO authoritiesDTO);

    AuthoritiesDTO asAuthoritiesDTO(Authorities authorities);

}
