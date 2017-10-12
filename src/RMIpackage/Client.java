package RMIpackage;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
	public static void main(String args[]) {
        
        try {
            String name = "AccountEngine";
            Registry registry = LocateRegistry.getRegistry(args[0]);
            Account stub = (Account) registry.lookup(name);
            
            try{
            	stub.s.acquire();
            	stub.deposit(500);
            	stub.s.release();
            } finally{
            	
            }
           
            System.out.println("balance " + stub.getBalance());
        } catch (Exception e) {
            System.err.println("Client Exception:");
            e.printStackTrace();
        }
    }  
}
