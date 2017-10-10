package dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AccountDAOImpl extends JdbcDaoSupport implements AccountDAO{

	@Override
	public void in(String inner, Integer money) {
		this.getJdbcTemplate().update("update account set money=money+? where username=?",money,inner);
	}

	@Override
	public void out(String outer, Integer money) {
		this.getJdbcTemplate().update("update account set money=money-? where username=?",money,outer);
	}

}
