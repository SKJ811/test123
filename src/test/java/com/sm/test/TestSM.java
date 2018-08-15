package com.sm.test;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.yc.bean.Account;
import com.yc.bean.OpRecord;
import com.yc.biz.AccountBiz;
import com.yc.dao.AccountDao;
import com.yc.dao.OpRecordDao;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations={"/beans.xml"})
public class TestSM {
	@Resource(name="dataSource")
	private BasicDataSource dataSource;
	
	@Resource(name="sqlSessionFactory")
	private DefaultSqlSessionFactory sqlSessionFactoryBean; 
	
	@Resource(name="sqlSession")
	private SqlSessionTemplate sqlSession; 
	
	@Resource(name="accountDaoImpl")
	private  AccountDao accountDao;
	
	@Resource(name="opRecordDaoImpl")
	private  OpRecordDao opRecordDao;
	

	
	
	@Test
	public void test4(){
		Account account=accountDao.findAccount(1);
		System.out.println(account);
	}
	@Test
	public void test5(){
		Account a=accountDao.findAccount(1);
		a.setBalance(111.0);
		accountDao.updateAccount(a);
		System.out.println("欧克");
	}
	
	@Test
	public void test6(){
		List<OpRecord> list=opRecordDao.findAll();
		
		System.out.println(list);
	}
	
	@Test
	public void testDataSource(){
		System.out.println(dataSource);
		try {
			System.out.println(dataSource.getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void test2(){
		System.out.println(sqlSessionFactoryBean);
	}
	@Test
	public void test3(){
		System.out.println(sqlSession);
	}
	
	
	@Resource(name="accountBizImpl")
	private AccountBiz accountBiz;
	
	@Test
	public void test7(){
		Account a=accountBiz.findAccount(1);
		System.out.println(a);
	}
	@Test
	public void test8(){
		//accountBiz.deposite(1, 1);
		accountBiz.withdraw(1, 9);
	}
}
