package com.springBajo8.springBajo8.service.impl;

import com.springBajo8.springBajo8.domain.facturaDTO;
import com.springBajo8.springBajo8.repository.IfacturaDTORepository;
import com.springBajo8.springBajo8.service.IfacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class facturaDTOServiceImpl implements IfacturaService {

    @Autowired
    private IfacturaDTORepository ifacturaDTORepository;

    @Override
    public Flux<facturaDTO> findAll() {
        return ifacturaDTORepository.findAll();
    }

    @Override
    public Mono<facturaDTO> save(facturaDTO fDTO) {
        return ifacturaDTORepository.save(fDTO);
    }
}
