package pkg_cliente;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import pkg_jersey.clientejersey;

@ManagedBean()
@SessionScoped
public class cls_presentacion {

    private int id;
    private String nombre;
    private String apellido;
    private String direccion;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void insertar() {
        clientejersey client1 = new clientejersey();
        Response response = client1.findAll_XML(Response.class);
        GenericType<List<Facturacion>> genericType = new GenericType<List<Facturacion>>() {
        };
        List<Facturacion> data = new ArrayList<Facturacion>();        
        data = (response.readEntity(genericType));
        
        Facturacion p = new Facturacion();
        p.setId(id);
        p.setNombre(nombre);
        p.setApellido(apellido);
        p.setDireccion(direccion);
        client1.create_XML(p);
    }
}
