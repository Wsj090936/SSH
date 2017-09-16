package IDAO;

import java.util.List;

import domain.User;

public interface UserDao {
	/**
	 * 通过用户名和密码查找用户
	 * @param loginName
	 * @param loginPwd
	 * @return
	 */
	User selectUserByInfo(String loginName, String loginPwd);
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	int addUser(User user);
	/**
	 * 更新用户信息
	 * @param user
	 * @return
	 */
	int updataUser(User user);
	/**
	 * 更具用户ID删除用户
	 * @param userID
	 * @return
	 */
	int deleteUser(Integer userID);
	/**
	 * 根据ID查找用户
	 * @param userID
	 * @return
	 */
	User selectUserByID(Integer userID);
	/**
	 * 查找所有用户
	 * @return
	 */
	List<User> selectAllUser();
	/**
	 * 通过指定条件查找用户
	 * @param userName
	 * @param gender
	 * @param education
	 * @param isUpload
	 * @return
	 */
	List<User> selectUserByCondition(String userName, String gender, String education, String isUpload);

}
