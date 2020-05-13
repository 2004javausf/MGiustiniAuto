package com.seleya.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnFactory {
	static ConnFactory cf = new ConnFactory();
	
	private ConnFactory() {
		super();
	}
	
	public static synchronized ConnFactory getInstance() {
		if(cf == null) {
			cf = new ConnFactory();
		}
		return cf;
	}
	
	public Connection getConnection() {
		String url = "jdbc:oracle:thin:@mtseleyaauto.c9su0kloe235.us-east-2.rds.amazonaws.com:1521:ORCL";
		String user = "sherlockfreak";
		String password = "StevieRay5!";
		
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	//we will call cf.getConnection(); to do stuff
}
