package iService;

import java.util.List;

import domain.User;

public interface UserService {
	/**
	 * �û���½
	 * @param loginName
	 * @param loginPwd
	 * @return
	 */
	User login(String loginName,String loginPwd); 
	/**
	 * ����û�
	 * @param user
	 * @return
	 */
	int saveUser(User user);
	/**
	 * �޸��û�
	 * @param user
	 * @return
	 */
	int modifyUser(User user);
	/**
	 * ɾ���û�
	 * @param userID
	 * @return
	 */
	int removeUser(Integer userID);
	/**
	 * ͨ��ID��ѯ�û�
	 * @param userID
	 * @return
	 */
	User findUserByID(Integer userID);
	/**
	 * ���������û�
	 * @return
	 */
	List<User> findAllUser();
	/**
	 * �������������û�
	 * @param userName
	 * @param gender
	 * @param education
	 * @param isUpload
	 * @return
	 */
	List<User> findUserByCondition(String userName,String gender,String education,String isUpload);
}
