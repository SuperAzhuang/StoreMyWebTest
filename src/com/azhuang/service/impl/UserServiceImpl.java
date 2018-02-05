package com.azhuang.service.impl;

import com.azhuang.dao.UserDao;
import com.azhuang.dao.impl.UserDaoimpl;
import com.azhuang.domain.User;
import com.azhuang.service.UserService;
import com.azhuang.utils.MailUtils;

public class UserServiceImpl implements UserService {

	@Override
	public void register(User user) throws Exception {
		// TODO Auto-generated method stub
		UserDao userDao = new UserDaoimpl();
		userDao.register(user);
		// String emailMsg="欢迎您注册成我们的一员,<a
		// href='http://localhost:8080/store/user?method=active&code="+user.getCode()+"'>点此激活</a>";
		// 注册的时候 发送激活码
		// <a href="${pageContext.request.contextPath }/user?method=registerUi">点此激活</a>
		String emailMsg = "请点击激活码，成为我们正式的一员,	"
				+ "<a href='http://localhost:8080/StoreMyWebTest/user?method=active&code=" + user.getCode()
				+ "'>点此激活</a>";
		MailUtils.sendMail(user.getEmail(), emailMsg);

	}

	/**
	 * 获取激活码的用户
	 */
	@Override
	public User getUserByCode(String code) throws Exception {
		// TODO Auto-generated method stub
		UserDao userDao = new UserDaoimpl();

		return userDao.getUserByCode(code);
	}

	/**
	 * 激活用户
	 */
	@Override
	public void active(User user) throws Exception {
		// TODO Auto-generated method stub
		UserDao userDao = new UserDaoimpl();
		
		user.setState(1);
		userDao.active(user);
		
	}

}
