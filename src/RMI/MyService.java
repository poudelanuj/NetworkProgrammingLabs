package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyService extends Remote {
    String sayHello(String name) throws RemoteException;
}