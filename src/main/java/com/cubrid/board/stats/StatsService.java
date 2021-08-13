package com.cubrid.board.stats;

import java.util.List;

public interface StatsService {
	public List<Stats> getStatsList();
	
	public List<Stats> getStatsByDate(String date);
}
