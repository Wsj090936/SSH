package DAO;

import domain.User1;

/**
 * �û���ز����ĳ־ò�ӿ�
 * @author wushijia
 *
 */
public interface IUserDAO {
/**
 * ͨ���û������ҵ��û�
 * @param username
 * @return
 */
	User1 selectUserByUsername(String username);
/**
 * ����û�
 * @return
 */
	int addUser(User1 user);

}
