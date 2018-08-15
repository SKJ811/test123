package com.yc.dao.impl;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.yc.bean.Account;
import com.yc.dao.AccountDao;
@Repository  //托管这个bean   但是还要注入sqlsession对象
public class AccountDaoImpl extends SqlSessionDaoSupport implements AccountDao {

	//sqlsessiondaosupport类也是需要sqlsession的
	//重写sqlsessiondaosupport类中的 setSqlSessionTemplate(),以注入sqlSession
	@Resource(name="sqlSession")//因为SqlSessionDaoSupport这个父类需要sqlsession，所以要注入
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	};
	@Override
	public void updateAccount(Account account) {
		super.getSqlSession().update("com.yc.dao.accountDaoMapper.updateAccount",account);
	}

	@Override
	public Account findAccount(int accountid) {
		return super.getSqlSession().selectOne("com.yc.dao.accountDaoMapper.findAccount",accountid);
		

	}

}
