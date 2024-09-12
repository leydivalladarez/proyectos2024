/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/MessageDrivenBean.java to edit this template
 */
package pkg_ejb_message;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author gamert
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "destino_jms_LPV"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class ejb_MessageBean implements MessageListener {

    public ejb_MessageBean() {
    }

    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("hello from message driven bean");
            MapMessage msg = (MapMessage) message;
            System.out.print("Cédula:" + msg.getString("cedula"));
            System.out.print("Nombre:" + msg.getString("nombre"));
            System.out.print("Dirección:" + msg.getString("direccion"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
