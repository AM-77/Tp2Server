package tp2;

import java.rmi.RemoteException;

import tp2.DetabaseConnection;

public class StockImpl implements IStock {

	private DetabaseConnection dbConnect = new DetabaseConnection();
	
	protected StockImpl() throws RemoteException {
		super();
	}

	@Override
	public boolean createArticle(String id, int Q_init) throws Exception {
		
		dbConnect.addArticle("INSERT INTO `Articles` (`id`, `quantity`, `lastOp`) VALUES ('"+ id +"', '"+ Q_init +"', CURRENT_TIMESTAMP)");
		return true;
	}

	@Override
	public boolean sale(String id, int Q) throws Exception{
		int quantity = dbConnect.getArticle("SELECT * FROM `Articles` WHERE id='"+id+"'").getQ();
		if(Q <= quantity){
			dbConnect.addArticle("UPDATE `Articles` SET `quantity` = '" + ( quantity - Q ) + "', `lastOp` = CURRENT_TIMESTAMP  WHERE `Articles`.`id` = '"+ id +"'");			
			return true;
		}
		return false;
	}

	@Override
	public boolean provision(String id, int Q) throws Exception{
		int quantity = dbConnect.getArticle("SELECT * FROM `Articles` WHERE id='"+id+"'").getQ();
		dbConnect.addArticle("UPDATE `Articles` SET `quantity` = '" + ( quantity + Q ) + "', `lastOp` = CURRENT_TIMESTAMP  WHERE `Articles`.`id` = '"+ id +"'");			
		return true;
	}

	@Override
	public State state(String id) throws Exception{
		Article article = dbConnect.getArticle("SELECT * FROM `Articles` WHERE id='"+id+"'");
		State s = new State(article.getId(), article.getQ(), article.getLastOp());
		return s;
	}

}
