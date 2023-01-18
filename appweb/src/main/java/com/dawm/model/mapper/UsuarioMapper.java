package com.dawm.model.mapper;

import org.mapstruct.Mapper;

import com.dawm.model.dto.UsuarioDTO;
import com.dawm.model.entity.Usuario;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioDTO asUsuarioDTO(Usuario usuario);

    Usuario asUsuario(UsuarioDTO usuarioDTO);
    
}
