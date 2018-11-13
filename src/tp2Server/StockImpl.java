package tp2Server;

import java.rmi.RemoteException;

import tp2Server.DetabaseConnection;

public class StockImpl implements IStock {

	private DetabaseConnection dbConnect = new DetabaseConnection();
	
	protected StockImpl() throws RemoteException {
		super();
	}

	@Override
	public void createArticle(String id, int Q_init) {
		dbConnect.addArticle("INSERT INTO `Articles` (`id`, `quantity`, `lastOp`) VALUES ('"+ id +"', '"+ Q_init +"', CURRENT_TIMESTAMP)");
	}

	@Override
	public boolean sale(String id, int Q) {
		int quantity = dbConnect.getArticle("SELECT * FROM `Articles` WHERE id="+id).getQ();
		if(Q <= quantity){
			dbConnect.addArticle("UPDATE `Articles` SET `quantity` = '" + ( quantity - Q ) + "', `lastOp` = CURRENT_TIMESTAMP  WHERE `Articles`.`id` = '"+ id +"'");			
			return true;
		}
		
		return false;
	}

	@Override
	public void provision(String id, int Q) {
		int quantity = dbConnect.getArticle("SELECT * FROM `Articles` WHERE id='"+id+"'").getQ();
		dbConnect.addArticle("UPDATE `Articles` SET `quantity` = '" + ( quantity + Q ) + "', `lastOp` = CURRENT_TIMESTAMP  WHERE `Articles`.`id` = '"+ id +"'");			
	}

	@Override
	public State state(String id) {
		Article article = dbConnect.getArticle("SELECT * FROM `Articles` WHERE id='"+id+"'");
		return new State(article.getId(), article.getQ(), article.getLastOp());
	}

}
