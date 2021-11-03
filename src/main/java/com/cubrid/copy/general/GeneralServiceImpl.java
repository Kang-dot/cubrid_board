package com.cubrid.copy.general;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cubrid.copy.json.JsonMapper;

@Service
public class GeneralServiceImpl implements GeneralService {
	private  static final Logger logger = LogManager.getLogger(GeneralServiceImpl.class);
	
	@Autowired
	private GeneralMapper generalMapper;
	@Autowired
	private JsonMapper jsonMapper;
	
	@Override
	public CopyResult copyDataStart() {
		CopyResult copyResult = new CopyResult();
		
		long startTime = System.currentTimeMillis();
		
		if (dropAndCreateTable()) {
			List<OracleData> copyList = getCopyDataList();
			copyResult.setDataCounts(copyList.size());
			
			if (registCopyData(copyList) && createIndex()) {
				copyResult.setResult(true);
			}
		}
		long endTime = System.currentTimeMillis();
		copyResult.setRunTime((endTime - startTime) / 1000);
		
		return copyResult;
	}

	@Override
	public List<OracleData> getCopyDataList() {
		List<OracleData> copyList = null;
		
		try {
			copyList = jsonMapper.list();
			logger.info("OracleData[" + copyList.size()+"]");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return copyList;
	}

	@Override
	public boolean registCopyData(List<OracleData> list) {
		int count = 0;
		logger.info("registCopyData[" + list.size() + "] START");
		
		try {
			for (OracleData oracleData : list) {
				count =+ generalMapper.regist(oracleData);
			}
			
			if (count > 0) {
				logger.info("registCopyData[" + list.size() + "] SUCCESS");
				return true;
			} else {
				logger.info("registCopyData[" + list.size() + "] FAIL");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
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
