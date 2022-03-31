package co.sofka.ferreteria.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Document(collection = "volante")
public class volanteDTO {
    @Id
    private String id = UUID.randomUUID().toString().substring(0, 15);
    private String proveedor;
    private List<inventarioDTO> listaInventario;
    private LocalDate Fecha;
    private String documento;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public List<inventarioDTO> getListaInventario() {
        return listaInventario;
    }

    public void setListaInventario(List<inventarioDTO> listaInventario) {
        this.listaInventario = listaInventario;
    }

    public LocalDate getFecha() {
        return Fecha;
    }

    public void setFecha(LocalDate fecha) {
        Fecha = fecha;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
}
