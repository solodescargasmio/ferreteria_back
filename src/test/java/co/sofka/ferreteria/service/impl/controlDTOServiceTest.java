package co.sofka.ferreteria.service.impl;

import co.sofka.ferreteria.domain.controlDTO;
import co.sofka.ferreteria.domain.inventarioDTO;
import co.sofka.ferreteria.repository.IcontrolDTORepository;
import co.sofka.ferreteria.repository.IinventarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class controlDTOServiceTest {
    @Mock
    private IcontrolDTORepository cRepository;

    @InjectMocks
    private controlDTOService cService;

    private controlDTO cDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        cDTO=new controlDTO();
        cDTO.setId("154542");
        cDTO.setIdItem("5644");
        cDTO.setCantidad(500l);
        cDTO.setMaximo(1000l);
        cDTO.setMinimo(20l);
        cDTO.setProducto("Pintura negra 20lts");



    }
    @Test
    void findAll() {
        Mockito.when(cRepository.findAll()).thenReturn(Flux.just(cDTO));
        assertNotNull(cService.findAll());
    }

    @Test
    void findById() {
        Mockito.when(cRepository.findById(cDTO.getId())).thenReturn(Mono.just(cDTO));
        assertNotNull(cService.findById(cDTO.getId()));
    }

    @Test
    void save() {
        Mockito.when(cRepository.save(any(controlDTO.class))).thenReturn(Mono.just(cDTO));
        assertNotNull(cRepository.save(cDTO));
    }
}