package tp2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class DetabaseConnection {


	public static boolean addArticle(String sql) throws Exception{
		/*
		 * Replace ServerIp by its value.
		 */
		Connection connection = DriverManager.getConnection( "jdbc:mysql://ServerIp:3306/Tp2RMI", "root", "");
		connection.createStatement().executeUpdate(sql);
		connection.close();
		return true;
	}
	
	public static Article getArticle(String sql) throws Exception{
		Article article = null;
		
		/*
		 * Replace ServerIp by its value.
		 */
		Connection connection = DriverManager.getConnection("jdbc:mysql://ServerIp:3306/Tp2RMI", "root", "");
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
