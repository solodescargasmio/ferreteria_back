package co.sofka.ferreteria.service.impl;


import co.sofka.ferreteria.repository.IinventarioRepository;
import co.sofka.ferreteria.service.IinventarioService;
import co.sofka.ferreteria.domain.inventarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class inventarioServiceImpl implements IinventarioService {

    @Autowired
    private IinventarioRepository iinventarioRepository;

    @Override
    public Flux<inventarioDTO> findAll() {
        return iinventarioRepository.findAll();
    }

    public Mono<inventarioDTO> save(inventarioDTO iDTO) {
        return iinventarioRepository.save(iDTO);
    }

    @Override
    public Mono<Void> delete(String id) {
        return this.iinventarioRepository.deleteById(id);
    }

}
