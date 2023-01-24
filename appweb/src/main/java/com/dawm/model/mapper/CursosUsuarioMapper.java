package com.dawm.model.mapper;

import org.mapstruct.Mapper;

import com.dawm.model.dto.CursosUsuarioDTO;
import com.dawm.model.entity.CursosUsuario;

@Mapper(componentModel = "spring")
public interface CursosUsuarioMapper {
    
    CursosUsuario asCursosUsuario(CursosUsuarioDTO cursosUsuarioDTO);

    CursosUsuarioDTO asCursosUsuarioDTO(CursosUsuario cursosUsuario);

}
