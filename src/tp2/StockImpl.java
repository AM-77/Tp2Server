package tp2;

import java.rmi.RemoteException;

public class StockImpl implements IStock {

	
	
	protected StockImpl() throws RemoteException {
		super();
	}

	@Override
	public boolean createArticle(String id, int Q_init) throws Exception {
		
		DatabaseConnection.addArticle("INSERT INTO `Articles` (`id`, `quantity`, `lastOp`) VALUES ('"+ id +"', '"+ Q_init +"', CURRENT_TIMESTAMP)");
		return true;
	}

	@Override
	public boolean sale(String id, int Q) throws Exception{
		int quantity = DatabaseConnection.getArticle("SELECT * FROM `Articles` WHERE id='"+id+"'").getQ();
		if(Q <= quantity){
			DatabaseConnection.addArticle("UPDATE `Articles` SET `quantity` = '" + ( quantity - Q ) + "', `lastOp` = CURRENT_TIMESTAMP  WHERE `Articles`.`id` = '"+ id +"'");			
			return true;
		}
		return false;
	}

	@Override
	public boolean provision(String id, int Q) throws Exception{
		int quantity = DatabaseConnection.getArticle("SELECT * FROM `Articles` WHERE id='"+id+"'").getQ();
		DatabaseConnection.addArticle("UPDATE `Articles` SET `quantity` = '" + ( quantity + Q ) + "', `lastOp` = CURRENT_TIMESTAMP  WHERE `Articles`.`id` = '"+ id +"'");			
		return true;
	}

	@Override
	public State state(String id) throws Exception{
		Article article = DatabaseConnection.getArticle("SELECT * FROM `Articles` WHERE id='"+id+"'");
		State s = new State(article.getId(), article.getQ(), article.getLastOp());
		return s;
	}

}
