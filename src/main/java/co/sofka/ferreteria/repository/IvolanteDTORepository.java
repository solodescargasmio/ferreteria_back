package co.sofka.ferreteria.repository;

import co.sofka.ferreteria.domain.volanteDTO;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface IvolanteDTORepository extends ReactiveMongoRepository<volanteDTO,String> {
    Flux<volanteDTO> findAll();
}
