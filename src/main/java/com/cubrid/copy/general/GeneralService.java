package com.cubrid.copy.general;

import java.util.List;

public interface GeneralService {
	public CopyResult copyDataStart(String num);
	
	public CopyResult batchDataStart(String num);
	
	public List<OracleData> getCopyDataList(String num);
	
	public boolean registCopyData(List<OracleData> list);
	
	public boolean registBatchData(List<OracleData> list);
	
	public boolean dropAndCreateTable();
	
	public boolean createIndex();
}
