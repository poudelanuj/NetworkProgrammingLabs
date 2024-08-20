package RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MyServiceImpl extends UnicastRemoteObject implements MyService {
    public MyServiceImpl() throws RemoteException {
        super();
    }

    public String sayHello(String name) throws RemoteException {
        return "Hello, " + name + "!";
    }
}
