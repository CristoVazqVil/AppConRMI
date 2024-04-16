import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import javax.swing.JOptionPane;

//Cristopher Vázquez Villa

public class Cliente {
    public static void main(String[] args) {
        int puerto = 8080;
        String servidor = "192.168.56.102";

        try {
            Calculadora calc = (Calculadora) Naming.lookup("rmi://" + servidor + ":" + puerto + "/Calculadora");
            while (true) {
                String opt = JOptionPane.showInputDialog(
                    "Calcular\n" +
                        "Suma _______________(1)\n" +
                        "Resta ______________(2)\n" +
                        "Multi ______________(3)\n" +
                        "División ___________(4)\n\n" +
                        "Cancelar para salir");
                if (opt == null)
                    break;
                
                    int a = Integer.parseInt(JOptionPane.showInputDialog("Ingrese a"));
                    int b = Integer.parseInt(JOptionPane.showInputDialog("Ingrese b"));

                    switch (opt) {
                        case "1": {
                            JOptionPane.showMessageDialog(null, a + " + " + b + " = " + calc.sum(a, b));
                            break;
                        }
                        case "2": {
                            JOptionPane.showMessageDialog(null, a + " - " + b + " = " + calc.res(a, b));
                            break;
                        }
                        case "3": {
                            JOptionPane.showMessageDialog(null, a + " * " + b + " = " + calc.mul(a, b));
                            break;
                        }
                        case "4": {
                            JOptionPane.showMessageDialog(null, a + " / " + b + " ="  + calc.div(a, b));
                            break;
                        }
                    }
            }
        } catch (RemoteException | NotBoundException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar con el servidor:\n" + ex);
        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(null, "La URL esta en formato incorrecto:\n" + ex);
        }
    }
}
