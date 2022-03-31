package com.springBajo8.springBajo8.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "conteo")
public class conteoDTO {
    private String idProducto;
    private Long maximo;
    private Long minimo;
    private Long cantidad;

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public Long getMaximo() {
        return maximo;
    }

    public void setMaximo(Long maximo) {
        this.maximo = maximo;
    }

    public Long getMinimo() {
        return minimo;
    }

    public void setMinimo(Long minimo) {
        this.minimo = minimo;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }
}
