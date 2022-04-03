package co.sofka.ferreteria.service;

import co.sofka.ferreteria.domain.volanteDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IvolanteService {
    Flux<volanteDTO> findAll();

    Mono<volanteDTO> findById(String id);

    Mono<volanteDTO> save(volanteDTO vDTO);

    Mono<volanteDTO> update(String id, volanteDTO vDTO);
    Mono<Void> delete(String id);

}
