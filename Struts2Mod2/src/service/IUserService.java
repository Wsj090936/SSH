package service;

import domain.User1;

public interface IUserService {
	public User1 findUserByUsername(String username);
	/**
	 * ����ע��ķ���
	 * @return
	 */
	public int register(User1 user);
}
