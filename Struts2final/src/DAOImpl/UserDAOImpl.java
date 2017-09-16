package DAOImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.lang3.StringUtils;

import IDAO.UserDao;
import Utils.JDBCTools;
import domain.User;

public class UserDAOImpl implements UserDao {
	private QueryRunner qr = new QueryRunner(JDBCTools.datasource);
	@Override
	public User selectUserByInfo(String loginName, String loginPwd) {
		try {
			return qr.query("SELECT * FROM s_user WHERE loginName=? AND loginPwd=?", new BeanHandler<>(User.class),loginName,loginPwd);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int addUser(User user) {
		try {
			return qr.update("INSERT INTO s_user(userID,userName,loginName,loginPwd,gender,birthday,education,telephone,hobby,path,filename,remark) "
					+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)",user.getUserID(),user.getUserName(),user.getLoginName(),user.getLoginPwd(),user.getGender()
					,user.getBirthday(),user.getEducation(),user.getTelephone(),user.getHobby(),user.getPath(),user.getFilename(),user.getRemark());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int updataUser(User user) {
		try {
			return qr.update("update s_user set userName=?,logonName=?,logonPwd=?,gender=?,birthday=?,education=?,telephone=?,hobby=?,path=?,filename=?,remark=? where userID = ?",
					user.getUserName(),user.getLoginName(),user.getLoginPwd(),user.getGender(),user.getBirthday(),user.getEducation(),user.getTelephone(),
					user.getHobby(),user.getPath(),user.getFilename(),user.getRemark(),user.getUserID());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int deleteUser(Integer userID) {
		try {
			return qr.update("DELETE FROM s_user WHERE userID=?",userID);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public User selectUserByID(Integer userID) {
		try {
			return qr.query("SELECT * FROM s_user WHERE userID=?", new BeanHandler<>(User.class),userID);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<User> selectAllUser() {
		try {
			return qr.query("SELECT * FROM s_user", new BeanListHandler<>(User.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<User> selectUserByCondition(String userName, String gender, String education, String isUpload) {
		if(StringUtils.isBlank(userName) && StringUtils.isBlank(gender)&& StringUtils.isBlank(education) && StringUtils.isBlank(isUpload)){
			return selectAllUser();//如果什么条件都没选，就直接查询所有
		}else{
			List<Object> parameters = new ArrayList<>();//存放替换通配符的参数
			String sql = "SELECT * FROM s_user WHERE";
			StringBuffer ss = new StringBuffer();
			ss.append(" 1=1 ");//为了append方便
			if(StringUtils.isNotBlank(userName)){
				ss.append(" AND userName like ?");
				parameters.add("%"+userName+"%");
			}
			if(StringUtils.isNotBlank(gender)){
				ss.append(" AND gender=?");
				parameters.add(gender);
			}
			if(StringUtils.isNotBlank(education)){
				ss.append(" AND education=?");
				parameters.add(education);
			}
			if(StringUtils.isNotBlank(isUpload)){
				if("true".equals(isUpload)){//上传了文件
					ss.append(" AND filename is NOT NULL");
				}else{//没有上传文件
					ss.append(" AND filename is NULL");
				}
			}
			sql = ss.toString();
			try {
				return qr.query(sql, new BeanListHandler<>(User.class),parameters.toArray());
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

	}

}
