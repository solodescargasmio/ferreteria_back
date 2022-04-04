package co.sofka.ferreteria.service;

import co.sofka.ferreteria.domain.controlDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IControlService {
    Flux<controlDTO> findAll();
    Mono<controlDTO> findById(String id);
    Mono<controlDTO> save(controlDTO con);
    Mono<controlDTO> delete(String id);
    Mono<controlDTO> update(String id,controlDTO con);

}
