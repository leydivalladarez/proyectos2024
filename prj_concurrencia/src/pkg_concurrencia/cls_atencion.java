package pkg_concurrencia;
import dao.ProcesoDAO;

public class cls_atencion extends Thread {

    String is_nombre_proceso;
// Constructor, getter & setter

    cls_atencion(String as_nombre_proceso) {
        is_nombre_proceso = as_nombre_proceso;
    }

    @Override
    public void run() {        
        ProcesoDAO procesoDAO = new ProcesoDAO();
        System.out.println("Inicia proceso " + is_nombre_proceso + " en " + System.currentTimeMillis());
        procesoDAO.insertaProceso(is_nombre_proceso, System.currentTimeMillis()+"");
        for (int i = 1; i <= 5; i++) {
            this.esperarXsegundos(1);
            System.out.println("Procesando interaccion: " + i + " del proceso " + is_nombre_proceso + " en "
                    + System.currentTimeMillis());
            procesoDAO.insertaProceso(is_nombre_proceso, System.currentTimeMillis()+"");
        }
        System.out.println("Finaliza proceso: " + is_nombre_proceso + " en " + System.currentTimeMillis());
        procesoDAO.insertaProceso(is_nombre_proceso, System.currentTimeMillis()+"");
    }

    public void ejecutar_secuencial() {
        ProcesoDAO procesoDAO = new ProcesoDAO();
        System.out.println("Inicia proceso " + is_nombre_proceso + " en " + System.currentTimeMillis());
        procesoDAO.insertaProceso(is_nombre_proceso, System.currentTimeMillis()+"");
        for (int i = 1; i <= 5; i++) {
            this.esperarXsegundos(1);
            System.out.println("Procesando interaccion: " + i + " del proceso " + is_nombre_proceso + " en "
                    + System.currentTimeMillis());
            procesoDAO.insertaProceso(is_nombre_proceso, System.currentTimeMillis()+"");
        }
        System.out.println("Finaliza proceso: " + is_nombre_proceso + " en " + System.currentTimeMillis());
        procesoDAO.insertaProceso(is_nombre_proceso, System.currentTimeMillis()+"");
    }

    private void esperarXsegundos(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
