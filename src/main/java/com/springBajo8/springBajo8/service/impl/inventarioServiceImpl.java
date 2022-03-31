package com.springBajo8.springBajo8.service.impl;


import com.springBajo8.springBajo8.domain.inventarioDTO;
import com.springBajo8.springBajo8.repository.IinventarioRepository;
import com.springBajo8.springBajo8.service.IinventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class inventarioServiceImpl implements IinventarioService {

    @Autowired
    private IinventarioRepository iinventarioRepository;

    @Override
    public Flux<inventarioDTO> findAll() {
        return iinventarioRepository.findAll();
    }

    public Mono<inventarioDTO> save(inventarioDTO iDTO) {
        return iinventarioRepository.save(iDTO);
    }

}
