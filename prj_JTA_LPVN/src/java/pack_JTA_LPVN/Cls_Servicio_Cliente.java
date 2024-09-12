/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pack_JTA_LPVN;
import pack_JTA_LPVN.cls_cliente;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionAttribute;
import jakarta.ejb.TransactionAttributeType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
@LocalBean
public class Cls_Servicio_Cliente {
    @PersistenceContext
    private EntityManager em;
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void insertar(cls_cliente clienteA, cls_cliente clienteB){
        em.persist(clienteA);
        em.persist(clienteB);
    }
}
