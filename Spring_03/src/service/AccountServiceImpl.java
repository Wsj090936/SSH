package service;

import dao.AccountDAO;

public class AccountServiceImpl implements AccountService {
	private AccountDAO accountDAO;
	@Override
	public void transform(String inner, String outer, Integer money) {
		this.accountDAO.out(outer, money);
//		int i = 1/0;
		this.accountDAO.in(inner, money);
	}
	public AccountDAO getAccountDAO() {
		return accountDAO;
	}
	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}

}
