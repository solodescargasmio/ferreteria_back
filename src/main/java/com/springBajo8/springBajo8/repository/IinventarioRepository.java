package com.springBajo8.springBajo8.repository;

import com.springBajo8.springBajo8.domain.inventarioDTO;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface IinventarioRepository extends ReactiveMongoRepository<inventarioDTO, String> {
    Flux<inventarioDTO> findAll();

}
