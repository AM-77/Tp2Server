package tp2Server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class StockServer {

	public static void main(String[] args) {
		
		SecurityManager secManager = System.getSecurityManager();
		if (secManager == null) {
		System.setSecurityManager(new SecurityManager());
		}
		
		try {
			
			StockImpl stockImpl = new StockImpl();
			
			
			Registry r = LocateRegistry.createRegistry(1099);
			r.rebind("stockImpl", stockImpl);
			
			
			System.out.println("The server is runnig ...");
		} catch (Exception e) {
			System.out.println("There was an exception : " + e);
		}
		
	}

}
