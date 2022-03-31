package com.springBajo8.springBajo8.web;


import com.springBajo8.springBajo8.domain.facturaDTO;
import com.springBajo8.springBajo8.domain.inventarioDTO;
import com.springBajo8.springBajo8.domain.volanteDTO;
import com.springBajo8.springBajo8.service.IfacturaService;
import com.springBajo8.springBajo8.service.IinventarioService;
import com.springBajo8.springBajo8.service.IvolanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
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
    MongoTemplate mongoTemplate;
/*
    @PostMapping("/citasReactivas")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<citasDTOReactiva> save(@RequestBody citasDTOReactiva citasDTOReactiva) {
        return this.icitasReactivaService.save(citasDTOReactiva);
    }

    @DeleteMapping("/citasReactivas/{id}")
    private Mono<ResponseEntity<citasDTOReactiva>> delete(@PathVariable("id") String id) {
        return this.icitasReactivaService.delete(id)
                .flatMap(citasDTOReactiva -> Mono.just(ResponseEntity.ok(citasDTOReactiva)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }

    @PostMapping("/citasReactivas/cancelarcita/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    private String updateCancelar(@PathVariable("id") String id) {
        System.out.println("Dentro del POST");
        Query query=new Query(Criteria.where("id").is(id));
        citasDTOReactiva cita=mongoTemplate.findOne(query,citasDTOReactiva.class);
        cita.setEstadoReservaCita("Cita Cancelada");
        mongoTemplate.save(cita);

        //return cita.getEstadoReservaCita()+"  "+id;
        return id;

    }

    @PutMapping("/citasReactivas/{id}")
    private Mono<ResponseEntity<citasDTOReactiva>> update(@PathVariable("id") String id, @RequestBody citasDTOReactiva citasDTOReactiva) {
        return this.icitasReactivaService.update(id, citasDTOReactiva)
                .flatMap(citasDTOReactiva1 -> Mono.just(ResponseEntity.ok(citasDTOReactiva1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }
    @PutMapping("/citasReactivas/{id}/{}")
    private Mono<ResponseEntity<citasDTOReactiva>> updateCancelado(@PathVariable("id") String id, @RequestBody citasDTOReactiva citasDTOReactiva) {
        return this.icitasReactivaService.update(id, citasDTOReactiva)
                .flatMap(citasDTOReactiva1 -> Mono.just(ResponseEntity.ok(citasDTOReactiva1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }

    @GetMapping("/citasReactivas/{idPaciente}/byidPaciente")
    private Flux<citasDTOReactiva> findAllByidPaciente(@PathVariable("idPaciente") String idPaciente) {
        return this.icitasReactivaService.findByIdPaciente(idPaciente);
    }

    @GetMapping(value = "/citasReactivas")
    private Flux<citasDTOReactiva> findAll() {
        return this.icitasReactivaService.findAll();
    }
    @GetMapping(value = "/cancelado")
    private Flux<citasDTOReactiva> findCancelados() {
        return this.icitasReactivaService.findByEstadoReservaCita();
    }

    @GetMapping("/citasReactivas/hora/{hora}")
    private Flux<citasDTOReactiva> findHora(@PathVariable("hora") String hora) {
        return this.icitasReactivaService.findByhoraReservaCita(hora);
    }


    @GetMapping("/citasReactivas/fecha/{fecha}")
    private Flux<citasDTOReactiva> findFechaHora(@PathVariable("fecha") String fech) {
        LocalDate fecha=LocalDate.parse(fech);
        return this.icitasReactivaService.findByFechaReservaCita(fecha);
    }

    @GetMapping("/citasReactivas/fechahora/{fecha}/{hora}")
    private Flux<citasDTOReactiva> findFechaHoraReserva(@PathVariable("fecha") String fech,@PathVariable("hora") String hora) {
        LocalDate fecha=LocalDate.parse(fech);
        return this.icitasReactivaService.findByFechaHoraReservaCita(fecha,hora);
    }


    @GetMapping(value = "/citasReactivas/medico/{idPaciente}")
    private Mono<medicoDTO> findByMedico(@PathVariable("idPaciente") String idPaciente) {
        return this.icitasReactivaService.findByMedico(idPaciente);
    }

    @GetMapping(value = "/citasReactivas/tratamiento/{idPaciente}")
    private Mono<tratamientosDTO> findByTratamiento(@PathVariable("idPaciente") String idPaciente) {
        return this.icitasReactivaService.findByTratamiento(idPaciente);
    }
*/
    @PostMapping("/inventario")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<inventarioDTO> save(@RequestBody inventarioDTO iDTO) {
        return this.iinventarioService.save(iDTO);
    }


    @GetMapping(value = "/inventario")
    private Flux<inventarioDTO> findAllInventario() {
        return this.iinventarioService.findAll();
    }

    @GetMapping(value = "/factura")
    private Flux<facturaDTO> findAllFactura() {

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

    @PostMapping("/volante")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<volanteDTO> save(@RequestBody volanteDTO vDTO) {
       // System.out.println(vDTO.getListaInventario().stream().);
        return this.ivolanteService.save(vDTO);
    }


}
