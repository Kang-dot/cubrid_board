package com.cubrid.copy.general;

import java.util.List;

public interface GeneralService {
	public CopyResult copyDataStart();
	
	public CopyResult batchDataStart();
	
	public List<OracleData> getCopyDataList();
	
	public boolean registCopyData(List<OracleData> list);
	
	public boolean registBatchData(List<OracleData> list);
	
	public boolean dropAndCreateTable();
	
	public boolean createIndex();
}
