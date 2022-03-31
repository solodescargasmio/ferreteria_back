package co.sofka.ferreteria.service;

import co.sofka.ferreteria.domain.facturaDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IfacturaService {
    Flux<facturaDTO> findAll();

    Mono<facturaDTO> save(facturaDTO fDTO);
}
