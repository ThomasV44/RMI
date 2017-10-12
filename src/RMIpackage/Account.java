package RMIpackage;
import java.rmi.Remote;
import java.util.concurrent.Semaphore;
import java.rmi.RemoteException;

public interface Account extends Remote {
	public Semaphore s = new Semaphore(1);
	
	public int getBalance() throws RemoteException;
	public void deposit(int ammount) throws RemoteException;
	public void withdraw(int ammount) throws RemoteException;
	
}


