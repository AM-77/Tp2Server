package tp2Server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class DetabaseConnection {


	public boolean addArticle(String sql){
		
		try {
			Connection connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/Tp2RMI", "root", "");
			connection.createStatement().executeUpdate(sql);
			connection.close();
			return true;
		} catch (SQLException e) {
			System.out.println("There was an error in adding the article : " + e);
			return false;
		}

	}
	
	public Article getArticle(String sql){
		
		Article article = null;
		
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Tp2RMI", "root", "");
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while (resultSet.next())	{
				article = new Article( (String)resultSet.getObject("id"), (int)resultSet.getObject("quantity"), (Date)resultSet.getObject("lastOp"));
			}
			
			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("There was an error in getting the article : " + e);
		}
		
		return article;
	}


			
}
