package com.azhuang.dao;

import com.azhuang.domain.User;

public interface UserDao {

	void register(User user) throws Exception;

	User getUserByCode(String code) throws Exception;

	void active(User user) throws Exception;
	User login(String usrname , String password) throws Exception;
	
}
