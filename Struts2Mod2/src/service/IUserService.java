package service;

import domain.User1;

public interface IUserService {
	public User1 findUserByUsername(String username);
	/**
	 * 用于注册的方法
	 * @return
	 */
	public int register(User1 user);
}
