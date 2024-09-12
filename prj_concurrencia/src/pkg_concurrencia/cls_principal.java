package pkg_concurrencia;

public class cls_principal {

    public static void main(String[] args) {
        long initialTime = System.currentTimeMillis();
        cls_atencion proceso_1 = new cls_atencion("cliente1");
        cls_atencion proceso_2 = new cls_atencion("cliente2");
        System.out.println("EJEMPLO EJECUCION SECUENCIAL");
        proceso_1.ejecutar_secuencial();
        proceso_2.ejecutar_secuencial();
        System.out.println("EJEMPLO EJECUCION CONCURRENTE");
        proceso_1.start();
        proceso_2.start();
    }
}
