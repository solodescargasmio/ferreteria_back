package com.springBajo8.springBajo8.repository;

import com.springBajo8.springBajo8.domain.volanteDTO;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface IvolanteDTORepository extends ReactiveMongoRepository<volanteDTO,String> {
    Flux<volanteDTO> findAll();
}
