package DAO.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import DAO.IUserDAO;
import Utils.JDBCTools;
import domain.User1;

public class UserDaoImpl implements IUserDAO {
	private QueryRunner qr = new QueryRunner(JDBCTools.datasource);
	@Override
	public User1 selectUserByUsername(String username) {
		try {
			return qr.query("SELECT * FROM user WHERE username=?",new BeanHandler<User1>(User1.class) ,username);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int addUser(User1 user) {
		try {
			return qr.update("INSERT INTO user(username,password,birthday,hobby,married) VALUES(?,?,?,?,?)",
					user.getUsername(),user.getPassword(),user.getBirthday(),user.getHobby(),user.isMarried());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
