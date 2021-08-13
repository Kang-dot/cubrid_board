package com.cubrid.board.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper
public interface PostMapper {
	public Post select(Post post) throws Exception;
	
	public Post selectNoIncr(Post post) throws Exception;
	
	public List<Post> list() throws Exception;
	
	public int regist(Post post) throws Exception;
	
	public int edit(Post post) throws Exception;
	
	public int delete(Post post) throws Exception;
	
	public int addCount(Post post) throws Exception;
	
	public void callProcedure() throws Exception;
	
	public int sqlTest() throws Exception;
}
