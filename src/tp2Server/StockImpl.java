package tp2Server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class StockImpl extends UnicastRemoteObject implements IStock {
	private static final long serialVersionUID = 1L;
	
	protected StockImpl() throws RemoteException {
		super();
	}

	@Override
	public void createArticle(String id, int Q_init) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean sale(String id, int Q) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void approvisionner(String id, int Q) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public State state(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
