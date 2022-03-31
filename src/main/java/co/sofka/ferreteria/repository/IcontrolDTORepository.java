package co.sofka.ferreteria.repository;

import co.sofka.ferreteria.domain.controlDTO;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IcontrolDTORepository extends ReactiveMongoRepository<controlDTO,String> {
    Flux<controlDTO> findAll();


    @Query(value = "{'idItem':?0}")
    Mono<controlDTO> findByIdItem(String id);

}
