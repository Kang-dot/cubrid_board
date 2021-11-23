package com.cubrid.copy.json;

import com.cubrid.copy.general.CopyResult;

public interface JsonService {
	public CopyResult copyDataStart(String num);
	
	public boolean dropAndCreateTable();
	
	public boolean createIndex();
	
	public int readAndInsertOracleData(String num);
}
