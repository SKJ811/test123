package com.yc.dao;

import java.util.List;

import com.yc.bean.OpRecord;

public interface OpRecordDao {
	public void insertOpRecord(OpRecord opRecord);

	public List<OpRecord> findAll();
}
