package com.javashark.jbdc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jdbcURL = "jdbc:mysql://localhost:3306/hb-01-one-to-one?useSSL=false";
		String USERNAME = "hbstudent";
		String PASS = "hbstudent";	
		
       try{
    	   System.out.println("connecting to db :"+ jdbcURL);
    	   Connection myConn =
    			      DriverManager.getConnection(jdbcURL,USERNAME,PASS);
    	   System.out.println("Connection Successfully");
    	   
    	   myConn.close();
       }catch(Exception exc){
    	   exc.printStackTrace();
       }
	}

}
