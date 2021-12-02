package com.cubrid.copy.json;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cubrid.copy.general.CopyResult;
import com.cubrid.copy.general.GeneralMapper;

@Service
public class JsonServiceImpl implements JsonService {
	private static final Logger logger = LogManager.getLogger(JsonServiceImpl.class);
	
	@Autowired
	private GeneralMapper generalMapper;

	@Override
	public CopyResult copyDataStart(String num) {
		CopyResult copyResult = new CopyResult();
		
		long startTime  = System.currentTimeMillis();
		
		if (dropAndCreateTable()) {
			int insertCount = readAndInsertOracleData(num);
			
			if (insertCount > 0 && createIndex()) {
				copyResult.setDataCounts(insertCount);
				copyResult.setResult(true);
			}
		}
		
		long endTime = System.currentTimeMillis();
		long resultTime = (endTime - startTime) / 1000;
		copyResult.setRunTime(resultTime);
		
		logger.info("RunTime[" + resultTime + "]");
		
		return copyResult;
	}
	
	@Override
	public int readAndInsertOracleData(String num) {
		int insertCount = 0;
		
		try {
			insertCount = generalMapper.jsonOracleCopyData(num);
			logger.info("registCopyData[" + insertCount + "]");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return insertCount;
	}

	@Override
	public boolean dropAndCreateTable() {
		try {
			generalMapper.dropTable();
			logger.info("dropTable");
			
			generalMapper.createTable();
			logger.info("createTable");
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean createIndex() {
		try {
			generalMapper.createIndex();
			logger.info("createIndex");
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
