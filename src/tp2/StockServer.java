package tp2;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class StockServer {

	public static void main(String[] args) {
		
		try {
			System.setProperty("java.rmi.server.hostname","192.168.43.239");
			System.setSecurityManager(new SecurityManager());
			IStock stockImpl = new StockImpl();
			IStock stockImplStub = (IStock) UnicastRemoteObject.exportObject(stockImpl, 0);
			Registry registry = LocateRegistry.createRegistry(1099);
			registry.rebind("stockImpl", stockImplStub);
			System.out.println("[+] The server is running ...");
		
		} catch (Exception e) {
		
			System.out.println("[!] There was an exception : " + e);
			e.printStackTrace();
		
		}
		
	}

}
