package tp2Server;

import java.rmi.Remote;

public interface IStock extends Remote{
	
	public void createArticle(String id, int Q_init);
	
	public boolean sale(String id, int Q);
	
	public void approvisionner(String id, int Q);
	
	public State state(String id);
}
