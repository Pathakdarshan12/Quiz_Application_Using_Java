import java.sql.*;
import java.lang.*;

class DbConnection
{
	ResultSet r;
	Statement s;
	int d;
	String s1;

	 DbConnection()
	 {

		try
		{
			Class.forName ("org.postgresql.Driver");
			Connection c1 = DriverManager.getConnection("jdbc:postgresql://localhost:5432/quiz",
            "postgres", "123");
			s = c1.createStatement();
			//s.execute("select * from quesbank");
		}
		catch(ClassNotFoundException e)
		{
			System.err.println("Failed to driver");
			e.printStackTrace();
			System.exit(1);
		}
	   catch(SQLException e1)
	   {
			System.err.println("Unable to Connect");
			e1.printStackTrace();
	   }
	}




	}
/*
	public static void main(String[] args)
	{
		new DbConnection();
	} */

