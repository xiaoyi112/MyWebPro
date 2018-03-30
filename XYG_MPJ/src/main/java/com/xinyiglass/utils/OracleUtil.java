package com.xinyiglass.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class OracleUtil {
	
	 private static Properties property;  
	    static{  
	        String url=OracleUtil.class.getClassLoader().getResource("jdbc.properties").getPath();  
	        try {  
	            property=new Properties();  
	            property.load(new FileInputStream(url));  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  
	    }  
	      
	    public static Connection getConnection(){  
	        Connection connection=null;  
	        try {  
	            Class.forName(property.getProperty("jdbc.driverClassName"));  
	            String url=property.getProperty("jdbc.url");  
	            String username=property.getProperty("jdbc.username");  
	            String password=property.getProperty("jdbc.password");  
	            connection=DriverManager.getConnection(url, username, password);  
	        } catch (ClassNotFoundException e){  
	            e.printStackTrace();  
	        } catch (SQLException e) {  
	            e.printStackTrace();  
	        }  
	        return connection;  
	    }  
	    public static void release(Connection con, Statement statement,ResultSet rs){  
	        if(null!=rs){  
	            try {  
	                rs.close();  
	            } catch (SQLException e) {  
	                e.printStackTrace();  
	            }finally{  
	                rs=null;  
	            }  
	            if(null!=statement){  
	                try {  
	                    statement.close();  
	                } catch (SQLException e) {  
	                    e.printStackTrace();  
	                }finally{  
	                    statement=null;  
	                }  
	            }  
	            if(null!=con){  
	                try {  
	                    con.close();  
	                } catch (SQLException e) {  
	                    e.printStackTrace();  
	                }finally{  
	                    con=null;  
	                }  
	            }  
	        }  
	    }  
}  
