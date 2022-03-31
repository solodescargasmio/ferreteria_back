package com.springBajo8.springBajo8.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Document(collection = "factura")
public class facturaDTO {
    @Id
    private String id = UUID.randomUUID().toString().substring(0, 15);
    private LocalDate Fecha;
    private String cliente;
    private String vendedor;
    private List<inventarioDTO> listaInventario;
    private Long total;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return Fecha;
    }

    public void setFecha(LocalDate fecha) {
        Fecha = fecha;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public List<inventarioDTO> getListaInventario() {
        return listaInventario;
    }

    public void setListaInventario(List<inventarioDTO> listaInventario) {
        this.listaInventario = listaInventario;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
