package ServiceImpl;

import java.util.List;

import DAOImpl.UserDAOImpl;
import IDAO.UserDao;
import domain.User;
import iService.UserService;

public class UserServiceImpl implements UserService {
	UserDao dao = new UserDAOImpl();
	@Override
	public User login(String loginName, String loginPwd) {
		// TODO Auto-generated method stub
		return dao.selectUserByInfo(loginName,loginPwd);
	}

	@Override
	public int saveUser(User user) {
		// TODO Auto-generated method stub
		return dao.addUser(user);
	}

	@Override
	public int modifyUser(User user) {
		// TODO Auto-generated method stub
		return dao.updataUser(user);
	}

	@Override
	public int removeUser(Integer userID) {
		// TODO Auto-generated method stub
		return dao.deleteUser(userID);
	}

	@Override
	public User findUserByID(Integer userID) {
		// TODO Auto-generated method stub
		return dao.selectUserByID(userID);
	}

	@Override
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		return dao.selectAllUser();
	}

	@Override
	public List<User> findUserByCondition(String userName, String gender, String education, String isUpload) {
		// TODO Auto-generated method stub
		return dao.selectUserByCondition(userName,gender,education,isUpload);
	}

}
