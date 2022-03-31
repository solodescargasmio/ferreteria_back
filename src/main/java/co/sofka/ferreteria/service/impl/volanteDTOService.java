package co.sofka.ferreteria.service.impl;

import co.sofka.ferreteria.domain.controlDTO;
import co.sofka.ferreteria.domain.inventarioDTO;
import co.sofka.ferreteria.repository.IcontrolDTORepository;
import co.sofka.ferreteria.repository.IvolanteDTORepository;
import co.sofka.ferreteria.service.IvolanteService;
import co.sofka.ferreteria.domain.volanteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class volanteDTOService implements IvolanteService {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    private IvolanteDTORepository ivolanteDTORepository;

    @Autowired
    private IcontrolDTORepository icontrolDTORepository;


    @Override
    public Flux<volanteDTO> findAll() {
        return ivolanteDTORepository.findAll();
    }
/*   @Override
    public Mono<citasDTOReactiva> update(String id, citasDTOReactiva citasDTOReactiva) {
        return this.IcitasReactivaRepository.findById(id)
                .flatMap(citasDTOReactiva1 -> {
                    citasDTOReactiva.setId(id);
                    return save(citasDTOReactiva);
                })
                .switchIfEmpty(Mono.empty());
    }*/
    @Override
    public Mono<volanteDTO> update(String id, volanteDTO vDTO){
        System.out.println("Dentro service");
        return this.ivolanteDTORepository.findById(id)
                .flatMap(volanteDTO1 -> {
                    volanteDTO1.setId(id);
                    return save(volanteDTO1);
                }).switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<Void> delete(String id) {

        return this.ivolanteDTORepository.deleteById(id);
    }

    @Override
    public Mono<volanteDTO> save(volanteDTO vDTO) {
        List<inventarioDTO> lista = vDTO.getListaInventario();
        for (inventarioDTO iDTO:lista) {
            String id=iDTO.getProducto();
            Query query=new Query(Criteria.where("producto").is(id));
            controlDTO control=mongoTemplate.findOne(query,controlDTO.class);
            if(!Objects.isNull(control)){
                Long cantidad=control.getCantidad();
                control.setCantidad(cantidad + iDTO.getCantidad());
                mongoTemplate.save(control);
            }


        }
        return ivolanteDTORepository.save(vDTO);
    }
}
