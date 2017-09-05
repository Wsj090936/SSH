package service.impl;

import DAO.IUserDAO;
import DAO.impl.UserDaoImpl;
import domain.User1;
import service.IUserService;

public class UserServiceImpl implements IUserService {
	private IUserDAO dao = new UserDaoImpl();

	@Override
	public User1 findUserByUsername(String username) {
		return dao.selectUserByUsername(username);
	}

	@Override
	public int register(User1 user) {
		return dao.addUser(user);
	}

}
