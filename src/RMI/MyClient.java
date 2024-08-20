package RMI;

import java.rmi.Naming;

public class MyClient {
    public static void main(String[] args) {
        try {
            MyService service = (MyService) Naming.lookup("rmi://localhost/MyService");
            String response = service.sayHello("World");
            System.out.println("Response from server: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
