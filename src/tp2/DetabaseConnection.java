package tp2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class DetabaseConnection {


	public boolean addArticle(String sql) throws Exception{
		Connection connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/Tp2RMI", "root", "");
		connection.createStatement().executeUpdate(sql);
		connection.close();
		return true;
	}
	
	public Article getArticle(String sql) throws Exception{
		
		Article article = null;
		

		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Tp2RMI", "root", "");
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		while (resultSet.next())	{
			article = new Article( (String)resultSet.getObject("id"), (int)resultSet.getObject("quantity"), (Date)resultSet.getObject("lastOp"));
		}
		
		resultSet.close();
		statement.close();
		connection.close();
		
		
		return article;
	}


			
}
