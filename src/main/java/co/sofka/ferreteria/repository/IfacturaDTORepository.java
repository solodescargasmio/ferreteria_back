package co.sofka.ferreteria.repository;

import co.sofka.ferreteria.domain.facturaDTO;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface IfacturaDTORepository extends ReactiveMongoRepository<facturaDTO,String> {
    Flux<facturaDTO> findAll();

}
