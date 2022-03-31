package co.sofka.ferreteria.service.impl;

import co.sofka.ferreteria.repository.IfacturaDTORepository;
import co.sofka.ferreteria.service.IfacturaService;
import co.sofka.ferreteria.domain.facturaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class facturaDTOServiceImpl implements IfacturaService {

    @Autowired
    private IfacturaDTORepository ifacturaDTORepository;

    @Override
    public Flux<facturaDTO> findAll() {
        return ifacturaDTORepository.findAll();
    }

    @Override
    public Mono<facturaDTO> save(facturaDTO fDTO) {
        return ifacturaDTORepository.save(fDTO);
    }
}
