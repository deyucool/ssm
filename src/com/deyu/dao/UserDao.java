package com.deyu.dao;

import java.io.Serializable;
import java.util.Map;

public class UserDao implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
    private String username;
    private String pwd;
    private String org;
    
    public UserDao() {
	    super();
    }
    
    public UserDao(Integer id, String username, String pwd) {
    	    super();
    	    this.id = id;
    	    this.username = username;
    	    this.pwd = pwd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPwd() {
        return pwd;
    }
    
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    public String  getOrg() {
    	return org;
    }
    
    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", pwd=" + pwd + "]";
    }

}
