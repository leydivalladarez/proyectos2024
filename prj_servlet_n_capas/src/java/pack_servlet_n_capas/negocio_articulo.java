/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack_servlet_n_capas;

import java.math.BigDecimal;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



@ManagedBean()
@SessionScoped
public class negocio_articulo {

    int ii_retorno;

    public int insertar(Integer as_codigo, String as_nombre,String as_descripcion,BigDecimal as_precio) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("prj_servlet_n_capasPU");
        EntityManager em1 = factory.createEntityManager();
        pack_servlet_n_capas.Articulo c1 = new pack_servlet_n_capas.Articulo(as_codigo);
        c1.setCodigo(as_codigo);
        c1.setNombre(as_nombre);
        c1.setDescripcion(as_descripcion);
        c1.setPrecio(as_precio);
        try {
            em1.getTransaction().begin();
            em1.persist(c1);
            em1.getTransaction().commit();
            ii_retorno = 1;
        } catch (Exception ex) {
            ii_retorno = -1;
        }
        em1.close();
        factory.close();
        return ii_retorno;
    }

    public int eliminar(Integer as_codigo) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("prj_servlet_n_capasPU");
        EntityManager em1 = factory.createEntityManager();
        pack_servlet_n_capas.Articulo c1 = new pack_servlet_n_capas.Articulo();
        c1.setCodigo(as_codigo);
        try {
            c1 = em1.find(Articulo.class, as_codigo);
            em1.getTransaction().begin();
            em1.remove(c1);
            em1.getTransaction().commit();
            ii_retorno = 1;
        } catch (Exception ex) {
            ii_retorno = -1;
        }
        em1.close();
        factory.close();
        return ii_retorno;
    }

    public int modificar(Integer as_codigo, String as_nombre,String as_descripcion,BigDecimal as_precio) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("prj_servlet_n_capasPU");
        EntityManager em1 = factory.createEntityManager();
        pack_servlet_n_capas.Articulo c1 = new pack_servlet_n_capas.Articulo();
        try {
            c1 = em1.find(Articulo.class, as_codigo);
            em1.getTransaction().begin();
            c1.setNombre(as_nombre);
            c1.setDescripcion(as_descripcion);
            c1.setPrecio(as_precio);
            em1.persist(c1);
            em1.getTransaction().commit();
            ii_retorno = 1;
        } catch (Exception ex) {
            ii_retorno = -1;
        }
        em1.close();
        factory.close();
        return ii_retorno;
    }

    public String buscar(Integer as_codigo) {
        String ls_nombre;
        String ls_descripcion;
        BigDecimal ls_precio;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("prj_servlet_n_capasPU");
        EntityManager em1 = factory.createEntityManager();
        pack_servlet_n_capas.Articulo c1 = new pack_servlet_n_capas.Articulo();
        try {
            c1 = em1.find(Articulo.class, as_codigo);
            ls_nombre = c1.getNombre();
            ls_descripcion = c1.getDescripcion();
            ls_precio = c1.getPrecio();
        } catch (Exception ex) {
            ls_nombre = null;
            ls_descripcion = null;
            ls_precio = null;
        }
        em1.close();
        factory.close();
        return ls_nombre;
    }

    public void procesar() {
// programar el código de la regla de negocio
    }
}
