package com.springBajo8.springBajo8.service.impl;

import com.springBajo8.springBajo8.domain.volanteDTO;
import com.springBajo8.springBajo8.repository.IvolanteDTORepository;
import com.springBajo8.springBajo8.service.IvolanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class volanteDTOService implements IvolanteService {

    @Autowired
    private IvolanteDTORepository ivolanteDTORepository;

    @Override
    public Flux<volanteDTO> findAll() {
        return ivolanteDTORepository.findAll();
    }

    @Override
    public Mono<volanteDTO> save(volanteDTO vDTO) {
        return ivolanteDTORepository.save(vDTO);
    }
}
