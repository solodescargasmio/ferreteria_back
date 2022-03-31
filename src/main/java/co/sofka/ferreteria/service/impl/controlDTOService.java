package co.sofka.ferreteria.service.impl;

import co.sofka.ferreteria.domain.controlDTO;
import co.sofka.ferreteria.repository.IcontrolDTORepository;
import co.sofka.ferreteria.service.IControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class controlDTOService implements IControlService {
    @Autowired
    private IcontrolDTORepository icontrolDTORepository;


    @Override
    public Flux<controlDTO> findAll() {
        return icontrolDTORepository.findAll();
    }

    @Override
    public Mono<controlDTO> save(controlDTO cDTO) {
        return icontrolDTORepository.save(cDTO);
    }
}
