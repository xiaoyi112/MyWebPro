package com.xinyiglass.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.xinyiglass.Test.OracleUtil;
import com.xinyiglass.beans.User;
import com.xinyiglass.dao.LoginDao;


public class LoginDaoImpl implements LoginDao {

	@Override
	public void doLogin(User user) {
		// TODO Auto-generated method stub
		Connection connection=OracleUtil.getConnection();
		Statement stm=null;  
        ResultSet rs=null;
        try {  
            stm= connection.createStatement();  
            String sql="select * from xyg_user";  
            rs=stm.executeQuery(sql);  
            while(rs.next()){  
                int id=rs.getInt(1);            
                String user_name=rs.getString(2);  
                String username=rs.getString(3);  
                int age=rs.getInt(4);  
                String password=rs.getString(5);               
                System.out.println(id+"|"+user_name+"|"+username+"|"+age+"|"+password);
            }  
        } catch (SQLException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }finally {  
            OracleUtil.release(connection, stm, rs);  
        }  
          
    }  
}  
