package com.cg.fms.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.cg.fms.exception.FeedbackException;

public class DBConnection {

	public static Connection getConnection() throws FeedbackException
	{
		try {
			Connection con= null;
			Properties prop=new Properties();
			FileReader fr=new FileReader("resources/jdbc.properties");
			prop.load(fr);
			String driver=prop.getProperty("driver");
			String dburl=prop.getProperty("dburl");
			String dbuser=prop.getProperty("dbuser");
			String pass=prop.getProperty("dbpass");
			//Class.forName(driver);								//optional from jdbc 4.0 getConnection takes driver from url automatically
			//System.out.println(" Driver Loaded Successfully ");
			con=DriverManager.getConnection(dburl,dbuser,pass);
			return con;
		} catch (FileNotFoundException e) {
				throw new FeedbackException("JDBC PROPERTIES FILE NOT FOUND"+e.getMessage());
		} catch (IOException e) {
				throw new FeedbackException(" UNABLE TO READ JDBC PROPS FILE" + e.getMessage());
		} catch (SQLException e) {
				throw new FeedbackException("DATABASE CONNECTION FAILS" + e.getMessage());
		}						
	}

}
