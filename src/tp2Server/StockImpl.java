package tp2Server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class StockImpl extends UnicastRemoteObject implements IStock {
	private static final long serialVersionUID = 1L;
	
	protected StockImpl() throws RemoteException {
		super();
	}

}
