package com.cubrid.copy.general;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper
public interface GeneralMapper {
	public OracleData select(OracleData post) throws Exception;
	
	public List<OracleData> list() throws Exception;
	
	public int regist(OracleData post) throws Exception;
	
	public int delete(OracleData post) throws Exception;
	
	public int dropTable() throws Exception;
	
	public int createTable() throws Exception;
	
	public int createIndex() throws Exception;
	
	public int jsonOracleCopyData() throws Exception;
}
