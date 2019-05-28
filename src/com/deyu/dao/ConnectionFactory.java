package com.deyu.dao;
import java.sql.*;
public class ConnectionFactory {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/pythontest";
    static final String USER = "root";
    static final String PASS = "123456";
    Connection conn;
	Statement stmt ;
	ResultSet rs = null;

    public ResultSet executeQueryData(String sql) {
    	try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt  = conn.createStatement();
            rs = stmt.executeQuery(sql);
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
		return rs;
    }
    
    public void close() {
    	try {
    		rs.close();
			stmt.close();
	    	conn.close();
	    	System.out.print("Connection closed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
 
    public static void main(String[] args) {
    	ConnectionFactory con = new ConnectionFactory();
        try{
            String sql;
            sql = "SELECT * FROM p_user";
            ResultSet rs = con.executeQueryData(sql);
            while(rs.next()){
                int id  = rs.getInt("id");
                String name = rs.getString("username");
    
                System.out.print("ID: " + id);
                System.out.print(", Õ¾µãÃû³Æ: " + name);
                System.out.print("\n");
            }
            rs.close();
            con.close();
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
    
    	}
   }
