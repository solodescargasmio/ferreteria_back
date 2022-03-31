package com.springBajo8.springBajo8.service;

import com.springBajo8.springBajo8.domain.volanteDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IvolanteService {
    Flux<volanteDTO> findAll();

    Mono<volanteDTO> save(volanteDTO vDTO);

}
