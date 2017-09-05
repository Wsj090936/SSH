package DAO;

import domain.User1;

/**
 * 用户相关操作的持久层接口
 * @author wushijia
 *
 */
public interface IUserDAO {
/**
 * 通过用户名查找到用户
 * @param username
 * @return
 */
	User1 selectUserByUsername(String username);
/**
 * 添加用户
 * @return
 */
	int addUser(User1 user);

}
