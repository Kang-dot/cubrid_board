package com.cubrid.copy.json;

import java.util.List;

import com.cubrid.copy.general.OracleData;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper
public interface JsonMapper {
	public List<OracleData> list() throws Exception; 
	
	public List<String> jsonList() throws Exception;
}
