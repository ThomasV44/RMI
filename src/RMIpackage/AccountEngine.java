package RMIpackage;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;


public class AccountEngine implements RMIpackage.Account {
		
	public AccountEngine(){
		super();
	}
	
	int balance;
	public int getBalance(){
		return balance;
	}
	public void deposit(int ammount){
		balance += ammount;
	}
	public void withdraw(int ammount){
		balance -= ammount;
	}
	
	public static void main(String[] args) {

        try {
            AccountEngine obj = new AccountEngine();
            Account stub = (Account) UnicastRemoteObject.exportObject(obj, 0);
            
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("AccountEngine", stub);
            
            System.err.println("Server Ready");
            
        }catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
	}
}
