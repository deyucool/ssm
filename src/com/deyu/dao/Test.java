package com.deyu.dao;

import java.util.List;

public class Test {

	public static void main(String[] args) {
		SessionSource se = new SessionSource();	        
        //UserDao user = (UserDao)se.executeQueryResult("User.getUser","U00002");
		//UserDao user = (UserDao)se.executeQueryResult("User.getUser");
		User mapper= se.getSession().getMapper(User.class);
        try {
        List<UserDao> user= mapper.selectAllUser();
        System.out.println(user.toString());
        } catch (Exception e) {
            e.printStackTrace();
            se.getSession().rollback();
        }
        //System.out.println(user.getOrg());
	}

}
