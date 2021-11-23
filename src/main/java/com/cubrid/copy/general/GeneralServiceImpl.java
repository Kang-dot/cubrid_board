package com.cubrid.copy.general;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
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
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Override
	public CopyResult copyDataStart(String num) {
		CopyResult copyResult = new CopyResult();
		
		long startTime = System.currentTimeMillis();
		
		if (dropAndCreateTable()) {
			List<OracleData> copyList = getCopyDataList(num);
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
	public CopyResult batchDataStart(String num) {
		CopyResult copyResult = new CopyResult();
		
		long startTime = System.currentTimeMillis();
		
		if (dropAndCreateTable()) {
			List<OracleData> copyList = getCopyDataList(num);
			copyResult.setDataCounts(copyList.size());
			
			if (registBatchData(copyList) && createIndex()) {
				copyResult.setResult(true);
			}
		}
		
		long endTime = System.currentTimeMillis();
		logger.info("RunTime[" + (endTime - startTime) + "]");
		copyResult.setRunTime((endTime - startTime) / 1000);
		
		return copyResult;
	}

	@Override
	public List<OracleData> getCopyDataList(String num) {
		List<OracleData> copyList = null;
		
		try {
			copyList = jsonMapper.list(num);
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
	public boolean registBatchData(List<OracleData> list) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO copy_data(num, title, author, publisher, book_year, ISBN, subject_num, regist_date)" + 
				     "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		int count = 0;
		
		logger.info("registBatchData[" + list.size() + "] START");
		try {
			conn = sqlSessionFactory.openSession().getConnection();
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(sql);
			
			
			for (OracleData oracleData : list) {
				pstmt.setInt(1, oracleData.getNum());
				pstmt.setString(2, oracleData.getTitle());
				pstmt.setString(3, oracleData.getAuthor());
				pstmt.setString(4, oracleData.getPublisher());
				pstmt.setInt(5, oracleData.getBookYear());
				pstmt.setString(6, oracleData.getISBN());
				pstmt.setString(7, oracleData.getSubjectNum());
				pstmt.setDate(8, oracleData.getRegistDate());
				
				pstmt.addBatch();
				pstmt.clearParameters();
				
				if (count % 10000 == 0) {
					pstmt.executeBatch();
					pstmt.clearBatch();
					conn.commit();
				}
				count++;
			}
			
			pstmt.executeBatch();
			pstmt.clearBatch();
			conn.commit();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (pstmt != null) try {pstmt.close();pstmt = null;} catch(SQLException ex){}
			if (conn != null) try {conn.close();conn = null;} catch(SQLException ex){}
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
