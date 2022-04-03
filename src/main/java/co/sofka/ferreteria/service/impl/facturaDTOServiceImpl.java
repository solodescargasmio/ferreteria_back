package co.sofka.ferreteria.service.impl;

import co.sofka.ferreteria.domain.controlDTO;
import co.sofka.ferreteria.domain.inventarioDTO;
import co.sofka.ferreteria.repository.IfacturaDTORepository;
import co.sofka.ferreteria.service.IfacturaService;
import co.sofka.ferreteria.domain.facturaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;

@Service
public class facturaDTOServiceImpl implements IfacturaService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private IfacturaDTORepository ifacturaDTORepository;

    @Override
    public Flux<facturaDTO> findAll() {
        return ifacturaDTORepository.findAll();
    }

    @Override
    public Mono<facturaDTO> save(facturaDTO fDTO) {

        List<inventarioDTO> lista = fDTO.getListaInventario();
        for (inventarioDTO iDTO:lista) {
            String id=iDTO.getProducto();
            Query query=new Query(Criteria.where("producto").is(id));
            controlDTO control=mongoTemplate.findOne(query,controlDTO.class);
            if(!Objects.isNull(control)){
                Long cantidad=control.getCantidad();
                control.setCantidad(cantidad - iDTO.getCantidad());
                mongoTemplate.save(control);
            }
        }

        return ifacturaDTORepository.save(fDTO);
    }

    @Override
    public Mono<facturaDTO> findById(String id) {
        return ifacturaDTORepository.findById(id);
    }
}
