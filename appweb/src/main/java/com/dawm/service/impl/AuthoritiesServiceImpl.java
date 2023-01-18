package com.dawm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawm.model.dto.AuthoritiesDTO;
import com.dawm.model.mapper.AuthoritiesMapper;
import com.dawm.repository.AuthoritiesRepository;
import com.dawm.service.AuthoritiesService;

@Service
public class AuthoritiesServiceImpl implements AuthoritiesService {

    @Autowired
    private AuthoritiesRepository authoritiesRepository;

    @Autowired
    private AuthoritiesMapper authoritiesMapper;

    @Override
    public void addAuthority(String username) {
        AuthoritiesDTO authoritiesDTO = new AuthoritiesDTO();
        authoritiesDTO.setUsername(username);
        authoritiesDTO.setAuthority("read");

        this.authoritiesRepository.save(this.authoritiesMapper.asAuthorities(authoritiesDTO));
    }

}
