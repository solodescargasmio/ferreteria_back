package com.springBajo8.springBajo8.service;

import com.springBajo8.springBajo8.domain.facturaDTO;
import com.springBajo8.springBajo8.domain.inventarioDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IfacturaService {
    Flux<facturaDTO> findAll();

    Mono<facturaDTO> save(facturaDTO fDTO);
}
