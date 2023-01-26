package com.dawm.service;

import com.dawm.model.dto.UsuarioDTO;
import com.dawm.model.util.UserData;

public interface UsuarioService {
    
    public void addUsuario(UserData userData);

    public UsuarioDTO getUsuario(String username);
    
    public UsuarioDTO updateUsuario(UsuarioDTO usuario);
}
