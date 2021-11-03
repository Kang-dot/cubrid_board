package com.cubrid.copy.general;

public class CopyResult {
	private boolean isResult = false;
	private long runTime;
	private int dataCounts;
	
	public boolean isResult() {
		return isResult;
	}
	public void setResult(boolean isResult) {
		this.isResult = isResult;
	}
	public long getRunTime() {
		return runTime;
	}
	public void setRunTime(long runTime) {
		this.runTime = runTime;
	}
	public int getDataCounts() {
		return dataCounts;
	}
	public void setDataCounts(int dataCounts) {
		this.dataCounts = dataCounts;
	}
}
