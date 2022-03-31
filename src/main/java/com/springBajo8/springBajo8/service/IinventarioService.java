package com.springBajo8.springBajo8.service;


import com.springBajo8.springBajo8.domain.inventarioDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

public interface IinventarioService {
    Flux<inventarioDTO> findAll();

    Mono<inventarioDTO> save(inventarioDTO iDTO);
}
