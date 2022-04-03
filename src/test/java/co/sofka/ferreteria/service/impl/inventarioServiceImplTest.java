package co.sofka.ferreteria.service.impl;

import co.sofka.ferreteria.domain.inventarioDTO;
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

class inventarioServiceImplTest {
    @Mock
    private IinventarioRepository iRepository;

    @InjectMocks
    private inventarioServiceImpl iService;

    private inventarioDTO iDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        iDTO=new inventarioDTO();
        iDTO.setId("12");
        iDTO.setCantidad(50l);
        iDTO.setProducto("Pintura negra 20lts");
        iDTO.setPrecio("1600");
        iDTO.setCedulaProveedor("98365214");

    }
    @Test
    void findAll() {
        Mockito.when(iRepository.findAll()).thenReturn(Flux.just(iDTO));
        assertNotNull(iService.findAll());

    }

    @Test
    void findById() {
        Mockito.when(iRepository.findById(iDTO.getId())).thenReturn(Mono.just(iDTO));
        assertNotNull(iService.findById(iDTO.getId()));
    }

    @Test
    void save() {
        Mockito.when(iRepository.save(any(inventarioDTO.class))).thenReturn(Mono.just(iDTO));
        assertNotNull(iRepository.save(iDTO));
    }

    @Test
    void delete() {
    }

    @Test
    void update() {
    }
}