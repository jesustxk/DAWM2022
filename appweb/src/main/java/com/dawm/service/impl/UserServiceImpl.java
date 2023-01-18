package com.dawm.service.impl;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dawm.model.UserData;
import com.dawm.model.dto.UsuarioDTO;
import com.dawm.model.mapper.UsuarioMapper;
import com.dawm.repository.UsuarioRepository;
import com.dawm.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioMapper usuarioMapper;
    

    @Override
    public void addUser(UserData userData) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setUsername(userData.getUsername());
        usuarioDTO.setPassword(passwordEncoder.encode(userData.getPassword()));
        usuarioDTO.setEnabled(true);
        usuarioDTO.setEmail(userData.getEmail());
        usuarioDTO.setFechaAlta(new Date(System.currentTimeMillis()));

        this.usuarioRepository.save(usuarioMapper.asUsuario(usuarioDTO));
    }

}
