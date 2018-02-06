package com.azhuang.service;

import com.azhuang.domain.User;

public interface UserService {

	void register(User user) throws Exception;

	User getUserByCode(String code) throws Exception;

	void active(User user) throws Exception;

	User login(String username, String password) throws Exception;

}
