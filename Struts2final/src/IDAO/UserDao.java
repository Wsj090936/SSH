package IDAO;

import java.util.List;

import domain.User;

public interface UserDao {
	/**
	 * ͨ���û�������������û�
	 * @param loginName
	 * @param loginPwd
	 * @return
	 */
	User selectUserByInfo(String loginName, String loginPwd);
	/**
	 * ����û�
	 * @param user
	 * @return
	 */
	int addUser(User user);
	/**
	 * �����û���Ϣ
	 * @param user
	 * @return
	 */
	int updataUser(User user);
	/**
	 * �����û�IDɾ���û�
	 * @param userID
	 * @return
	 */
	int deleteUser(Integer userID);
	/**
	 * ����ID�����û�
	 * @param userID
	 * @return
	 */
	User selectUserByID(Integer userID);
	/**
	 * ���������û�
	 * @return
	 */
	List<User> selectAllUser();
	/**
	 * ͨ��ָ�����������û�
	 * @param userName
	 * @param gender
	 * @param education
	 * @param isUpload
	 * @return
	 */
	List<User> selectUserByCondition(String userName, String gender, String education, String isUpload);

}
