import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

//Cristopher Vázquez Villa

public class Servidor {
    public static void main(String[] args) {
        try {
            int puerto = 8080;
            String servidor = "localhost";

            System.out.println("Iniciando servidor en: ");
            System.out.println("Hostname: " + servidor);
            System.out.println("Puerto: " + puerto);

            Registry registro = LocateRegistry.createRegistry(puerto);
            System.setProperty("java.rmi.server.hostname", servidor);
            registro.rebind("Calculadora", new CalcRMI());

            System.out.println("Servidor en ejecución en espera de clientes...");
        } catch (RemoteException ex) {
            System.err.println(ex);
        }
    }
}
