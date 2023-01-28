package com.dawm.service.impl;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dawm.model.dto.UsuarioDTO;
import com.dawm.model.mapper.UsuarioMapper;
import com.dawm.model.util.UserData;
import com.dawm.repository.UsuarioRepository;
import com.dawm.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioMapper usuarioMapper;
    

    @Override
    public void addUsuario(UserData userData) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setUsername(userData.getUsername());
        usuarioDTO.setPassword(passwordEncoder.encode(userData.getPassword()));
        usuarioDTO.setEnabled(true);
        usuarioDTO.setEmail(userData.getEmail());
        usuarioDTO.setFechaAlta(new Date(System.currentTimeMillis()));

        this.usuarioRepository.save(usuarioMapper.asUsuario(usuarioDTO));
        
    }

    @Override
    public UsuarioDTO getUsuario(String username) {
        return this.usuarioMapper.asUsuarioDTO(this.usuarioRepository.findByUsername(username));
    }

    @Override
    public UsuarioDTO updateUsuario(UsuarioDTO usuario) {

        usuario.setNombre(usuario.getNombre());
        usuario.setUsername(usuario.getUsername());
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuario.setEmail(usuario.getEmail());
        usuario.setEdad(usuario.getEdad());

        this.usuarioRepository.save(this.usuarioMapper.asUsuario(usuario));
        return usuario;
    }

}
