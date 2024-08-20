package RMI;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class MyServer {
    public static void main(String[] args) {
        try {
            MyService service = new MyServiceImpl();
            LocateRegistry.createRegistry(1099); // Start RMI registry on port 1099
            Naming.rebind("rmi://localhost/MyService", service);
            System.out.println("Service is bound and ready.");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
