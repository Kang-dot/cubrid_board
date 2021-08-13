package com.cubrid.board.stats;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatsServiceImpl implements StatsService {
	
	@Autowired
	public StatsMapper statsMapper;
	
	public List<Stats> getStatsList(){
		//TODO list 리턴
		List<Stats> statsList = null;
		try {
			statsList = statsMapper.list(new Stats());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return statsList;
	}
	
	public List<Stats> getStatsByDate(String date){
		
		date = date.replaceAll("-", "");
		
		List<Stats> statsList = null;
		Stats stats = new Stats();
		stats.setStatsDate(date);
		try {
			statsList = statsMapper.list(stats);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return statsList;
	}
}
