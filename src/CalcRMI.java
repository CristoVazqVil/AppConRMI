import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

//Cristopher Vázquez Villa

public class CalcRMI extends UnicastRemoteObject implements Calculadora{
    protected CalcRMI() throws RemoteException {
        super();
    }

    @Override
    public double div(int a, int b) throws RemoteException {
        return a / b;
    }

    @Override
    public double mul(int a, int b) throws RemoteException {
        return a * b;
    }

    @Override
    public double sum(int a, int b) throws RemoteException {
        return a + b;
    }

    @Override
    public double res(int a, int b) throws RemoteException {
        return a - b;
    }

}
