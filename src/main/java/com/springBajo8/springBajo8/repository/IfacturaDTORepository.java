package com.springBajo8.springBajo8.repository;

import com.springBajo8.springBajo8.domain.facturaDTO;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface IfacturaDTORepository extends ReactiveMongoRepository<facturaDTO,String> {
    Flux<facturaDTO> findAll();
}
