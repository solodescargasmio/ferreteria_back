package co.sofka.ferreteria.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "control")
public class controlDTO {
    private String id= UUID.randomUUID().toString().substring(0, 15);
    private String idItem;
    private String producto;
    private Long cantidad;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    private Long maximo;
    private Long minimo;

    public String getIdItem() {
        return idItem;
    }

    public void setIdItem(String idItem) {
        this.idItem = idItem;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
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

    @Override
    public String toString() {
        return "controlDTO{" +
                "idItem='" + idItem + '\'' +
                ", cantidad=" + cantidad +
                ", maximo=" + maximo +
                ", minimo=" + minimo +
                '}';
    }
}
