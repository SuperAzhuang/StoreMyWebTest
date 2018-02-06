package com.azhuang.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.azhuang.dao.UserDao;
import com.azhuang.domain.User;
import com.azhuang.utils.DataSourceUtils;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class UserDaoimpl implements UserDao {

	@Override
	public void register(User user) throws Exception {
		// TODO Auto-generated method stub
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		// private String uid;
		// private String username;
		// private String password;
		// private String name;
		// private String email;
		// private String birthday;
		// private String sex;
		//
		// private Integer state; //0 未激活，1已激活
		// private String code;
		String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?)";
		
		System.out.println("user = " +user);
		
		queryRunner.update(sql, user.getUid(), user.getUsername(), user.getPassword(), user.getName(), user.getEmail(),
				user.getTelephone(), user.getBirthday(), user.getSex(), user.getState(),user.getCode());
		
	
		
//		String sql="insert into user values(?,?,?,?,?,?,?,?,?,?);";
//		qr.update(sql, user.getUid(),user.getUsername(),user.getPassword(),
//				user.getName(),user.getEmail(),user.getTelephone(),
//				user.getBirthday(),user.getSex(),user.getState(),user.getCode());

	}

	@Override
	public User getUserByCode(String code) throws Exception {
		// TODO Auto-generated method stub
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());

		String sql = "select * from user where code = ? limit 1";
		return queryRunner.query(sql, new BeanHandler<>(User.class),code);
	}

	@Override
	public void active(User user) throws Exception {
		// TODO Auto-generated method stub

		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update user set username = ?,password = ?, name = ?, email = ? ,state = ? where uid = ?";

		qr.update(sql, user.getUsername(), user.getPassword(), user.getName(), user.getEmail(), user.getState(),
				user.getUid());

	}

	public User login(String username, String password) throws Exception {
		// TODO Auto-generated method stub
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where username =? and password = ? limit 1";
		
		return queryRunner.query(sql, new BeanHandler<>(User.class),username,password);
	}

}
