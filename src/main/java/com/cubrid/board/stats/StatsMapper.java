package com.cubrid.board.stats;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper
public interface StatsMapper {
	public List<Stats> list(Stats stats) throws Exception;
}
