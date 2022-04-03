package co.sofka.ferreteria.web;


import co.sofka.ferreteria.domain.controlDTO;
import co.sofka.ferreteria.domain.inventarioDTO;
import co.sofka.ferreteria.domain.volanteDTO;
import co.sofka.ferreteria.service.IControlService;
import co.sofka.ferreteria.service.IfacturaService;
import co.sofka.ferreteria.service.IinventarioService;
import co.sofka.ferreteria.service.IvolanteService;
import co.sofka.ferreteria.domain.facturaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class inventarioResource {

    @Autowired
    private IinventarioService iinventarioService;

    @Autowired
    private IfacturaService ifacturaService;

    @Autowired
    private IvolanteService ivolanteService;

    @Autowired
    private IControlService iControlService;

    @Autowired
    MongoTemplate mongoTemplate;

    @PostMapping("/inventario")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<inventarioDTO> save(@RequestBody inventarioDTO iDTO) {
        return this.iinventarioService.save(iDTO);
    }


    @GetMapping(value = "/inventario")
    private Flux<inventarioDTO> findAllInventario() {
        return this.iinventarioService.findAll();
    }


    @GetMapping(value = "/inventario/{id}")
    private Mono<inventarioDTO> findAllInventarioID(@PathVariable("id") String id) {
        return this.iinventarioService.findById(id);
    }

    @PutMapping(path="/inventario/{id}", consumes = (MediaType.APPLICATION_JSON_VALUE),produces = (MediaType.APPLICATION_JSON_VALUE))
    private Mono<ResponseEntity<inventarioDTO>> updateInventario(@PathVariable("id") String id, @RequestBody inventarioDTO iDTO) {
        return this.iinventarioService.update(id,iDTO)
                .flatMap(vDTO1->Mono.just(ResponseEntity.ok(vDTO1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));}

    @GetMapping(value = "/factura")
    private Flux<facturaDTO> findAllFactura() {
        return this.ifacturaService.findAll();
    }

    @GetMapping(value = "/factura/{id}")
    private Flux<facturaDTO> findByIdFactura() {
        return this.ifacturaService.findAll();
    }

    @PostMapping("/factura")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<facturaDTO> save(@RequestBody facturaDTO fDTO) {
        return this.ifacturaService.save(fDTO);
    }

    @GetMapping(value = "/volante")
    private Flux<volanteDTO> findAllVolante() {

        return this.ivolanteService.findAll();
    }

    @GetMapping(value = "/volante/{id}")
    private Mono<volanteDTO> findByIdVolante(@PathVariable("id") String id) {

        return this.ivolanteService.findById(id);
    }

    @PostMapping("/volante")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<volanteDTO> save(@RequestBody volanteDTO vDTO) {
        return this.ivolanteService.save(vDTO);
    }

    @PutMapping(path="/volante/{id}", consumes = (MediaType.APPLICATION_JSON_VALUE),produces = (MediaType.APPLICATION_JSON_VALUE))
    private Mono<ResponseEntity<volanteDTO>> updateCancelado(@PathVariable("id") String id, @RequestBody volanteDTO vDTO) {
        return this.ivolanteService.update(id,vDTO)
                .flatMap(vDTO1->Mono.just(ResponseEntity.ok(vDTO1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }
    @DeleteMapping("/volante/{id}")
    private Mono<Void> delete(@PathVariable("id") String id) {
        return this.ivolanteService.delete(id);

    }
    @GetMapping(value = "/control")
    private Flux<controlDTO> findAllControl() {
        return this.iControlService.findAll();
    }




}
