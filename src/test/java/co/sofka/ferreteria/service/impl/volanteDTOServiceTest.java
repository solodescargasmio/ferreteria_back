package co.sofka.ferreteria.service.impl;

import co.sofka.ferreteria.domain.inventarioDTO;
import co.sofka.ferreteria.domain.volanteDTO;
import co.sofka.ferreteria.repository.IvolanteDTORepository;
import co.sofka.ferreteria.service.IvolanteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class volanteDTOServiceTest {
    @Mock
    private IvolanteDTORepository vRepository;

    @InjectMocks
    private IvolanteService vService;

    private volanteDTO vDTO;
    private inventarioDTO iDTO;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        LocalDate fecha=LocalDate.parse("2022-05-16");
        vDTO=new volanteDTO();
        vDTO.setId("12345-2");
        vDTO.setDocumento("98653241");
        vDTO.setFecha(fecha);

        iDTO=new inventarioDTO();
        iDTO.setId("12");
        iDTO.setCantidad(50l);
        iDTO.setProducto("Pintura negra 20lts");
        iDTO.setPrecio("1600");
        iDTO.setCedulaProveedor("98365214");
        List<inventarioDTO> lista=new ArrayList<>();
        lista.add(iDTO);
        vDTO.setListaInventario(lista);
        vDTO.setProveedor("Maria Valager");


    }
    @Test
    void findAll() {
        Mockito.when(vRepository.findAll()).thenReturn(Flux.just(vDTO));
        assertNotNull(vService.findAll());

    }

    @Test
    void findById() {
        Mockito.when(vRepository.findById(iDTO.getId())).thenReturn(Mono.just(vDTO));
        assertNotNull(vService.findById(iDTO.getId()));
    }

    @Test
    void save() {
        Mockito.when(vRepository.save(any(volanteDTO.class))).thenReturn(Mono.just(vDTO));
        assertNotNull(vRepository.save(vDTO));
    }


}