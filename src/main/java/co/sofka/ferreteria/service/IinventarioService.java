package co.sofka.ferreteria.service;


import co.sofka.ferreteria.domain.inventarioDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IinventarioService {
    Flux<inventarioDTO> findAll();

    Mono<inventarioDTO> save(inventarioDTO iDTO);

    Mono<Void> delete(String id);

}
