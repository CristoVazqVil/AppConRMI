import java.rmi.RemoteException;
import java.rmi.Remote;

//Cristopher Vázquez Villa

public interface Calculadora extends Remote {
    public double div(int a, int b) throws RemoteException;
    public double mul(int a, int b) throws RemoteException;
    public double sum(int a, int b) throws RemoteException;
    public double res(int a, int b) throws RemoteException;
}
