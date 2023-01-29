package com.dawm.service.impl;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dawm.model.dto.UsuarioDTO;
import com.dawm.model.entity.Usuario;
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
        UsuarioDTO usuarioDTO = this.getUsuario(usuario.getUsername());

        usuarioDTO.setNombre(usuario.getNombre());
        usuarioDTO.setEmail(usuario.getEmail());
        usuarioDTO.setEdad(usuario.getEdad());
        usuarioDTO.setDescripcion(usuario.getDescripcion());

        if (usuario.getPassword4().equals("")) {
            if (usuario.getPassword5().equals("")
                && usuario.getPassword5().equals(usuario.getPassword6())) {
                    Usuario usuarioAux = this.usuarioRepository.save(this.usuarioMapper.asUsuario(usuarioDTO));
                    // Se actualiza usuario sin cambiar contraseña

                    return this.usuarioMapper.asUsuarioDTO(usuarioAux);
            }
        } else {
            if (passwordEncoder.matches(usuario.getPassword4(), usuarioDTO.getPassword())
                && usuario.getPassword5().equals(usuario.getPassword6())
                && !usuario.getPassword5().equals("")) {

                    usuarioDTO.setPassword(passwordEncoder.encode(usuario.getPassword5()));
                    Usuario usuarioAux = this.usuarioRepository.save(this.usuarioMapper.asUsuario(usuarioDTO));
                    // Se actualiza usuario cambiando contraseña

                    return this.usuarioMapper.asUsuarioDTO(usuarioAux);
            }
        }
        // Cualquier otro caso no se actualiza nada (recogemos de nuevo para que no le falten campos)
        return this.usuarioMapper.asUsuarioDTO(this.usuarioRepository.findByUsername(usuario.getUsername()));
    }

}
