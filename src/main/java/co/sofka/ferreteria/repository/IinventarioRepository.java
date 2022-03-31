package co.sofka.ferreteria.repository;

import co.sofka.ferreteria.domain.inventarioDTO;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface IinventarioRepository extends ReactiveMongoRepository<inventarioDTO, String> {
    Flux<inventarioDTO> findAll();

}
