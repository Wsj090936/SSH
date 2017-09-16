package iService;

import java.util.List;

import domain.User;

public interface UserService {
	/**
	 * 用户登陆
	 * @param loginName
	 * @param loginPwd
	 * @return
	 */
	User login(String loginName,String loginPwd); 
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	int saveUser(User user);
	/**
	 * 修改用户
	 * @param user
	 * @return
	 */
	int modifyUser(User user);
	/**
	 * 删除用户
	 * @param userID
	 * @return
	 */
	int removeUser(Integer userID);
	/**
	 * 通过ID查询用户
	 * @param userID
	 * @return
	 */
	User findUserByID(Integer userID);
	/**
	 * 查找所有用户
	 * @return
	 */
	List<User> findAllUser();
	/**
	 * 根据条件查找用户
	 * @param userName
	 * @param gender
	 * @param education
	 * @param isUpload
	 * @return
	 */
	List<User> findUserByCondition(String userName,String gender,String education,String isUpload);
}
