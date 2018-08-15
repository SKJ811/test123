package com.yc.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.yc.bean.OpRecord;
import com.yc.dao.OpRecordDao;
@Repository  //托管这个bean   但是还要注入sqlsession对象
public class OpRecordDaoImpl extends SqlSessionDaoSupport implements OpRecordDao {

	//sqlsessiondaosupport类也是需要sqlsession的
	//重写sqlsessiondaosupport类中的 setSqlSessionTemplate(),以注入sqlSession
	@Resource(name="sqlSession")//因为SqlSessionDaoSupport这个父类需要sqlsession，所以要注入
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}

	@Override
	public void insertOpRecord(OpRecord opRecord) {
		super.getSqlSession().insert("com.yc.dao.opRecordDaoMapper.insertOpRecord",opRecord);
	}

	public List<OpRecord> findAll() {
		
		return super.getSqlSession().selectList("com.yc.dao.opRecordDaoMapper.findAll");
	};
	

	

}
