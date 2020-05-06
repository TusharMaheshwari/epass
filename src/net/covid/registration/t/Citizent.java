package net.covid.registration.t;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import net.covid.registration.model.Citizen;
public class Citizent{
	public int registerCitizen(Citizen citizen) throws ClassNotFoundException{
		String INSERT_USERS_SQL = "INSERT INTO employee" + "(id,first_name,last_name,username,password,contact,address) VALUES"+"(?,?,?,?,?,?,?);";
	int result = 0;
	Class.forName("com.mysql.jdbc.Driver");
	try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdc","root","");
	PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)){
		preparedStatement.setInt(1, 1);
		preparedStatement.setString(2, citizen.getFirstName());
		preparedStatement.setString(3, citizen.getLastName());
		preparedStatement.setString(3, citizen.getUsername());
		preparedStatement.setString(3, citizen.getPassword());
		preparedStatement.setString(3, citizen.getAddress());
		preparedStatement.setString(3, citizen.getContact());
		
		System.out.println(preparedStatement);
		result=preparedStatement.executeUpdate();
	}catch (SQLException e) {
		
		e.printStackTrace();
	}
	return result;
	}
	
	

}
