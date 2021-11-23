package com.cubrid.copy.general;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper
public interface GeneralMapper {
	public OracleData select(OracleData oracleData) throws Exception;
	
	public List<OracleData> list(String num) throws Exception;
	
	public int regist(OracleData oracleData) throws Exception;
	
	public int registBatch(List list) throws Exception;
	
	public int delete(OracleData oracleData) throws Exception;
	
	public int dropTable() throws Exception;
	
	public int createTable() throws Exception;
	
	public int createIndex() throws Exception;
	
	public int jsonOracleCopyData(String num) throws Exception;
}
