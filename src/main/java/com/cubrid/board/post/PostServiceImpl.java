package com.cubrid.board.post;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostMapper postMapper;
	
	@Override
	public Post getPost(int postNum) {
		
		Post post = new Post();
		post.setPostNum(postNum);
		
		try {
			postMapper.addCount(post);
			post = postMapper.select(post);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return post;
	}


	@Override
	@Qualifier(value="")
	public Post getPostNoIncr(int postNum) {
		Post post = new Post();
		post.setPostNum(postNum);
		
		try {
			post = postMapper.selectNoIncr(post);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return post;
	}
	
	@Override
	public List<Post> getPostList() {
		List<Post> postList = null;
		
		try {
			postList = postMapper.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return postList;
	}

	@Override
	public boolean reigistPost(Post post) {
		
		try {
			int result = postMapper.regist(post);
			
			if (result != 1) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deletePost(Post post) {
		// TODO Auto-generated method stub
		
		try {
			int result = postMapper.delete(post);
			
			if (result != 1) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean editPost(Post post) {
		// TODO Auto-generated method stub
		
		try {
			int result = postMapper.edit(post);
			if (result != 1) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean runBatch() {
		try {
			postMapper.callProcedure();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
