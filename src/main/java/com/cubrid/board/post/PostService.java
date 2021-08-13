package com.cubrid.board.post;

import java.util.List;

public interface PostService {
	public Post getPost(int postNum);
	
	public Post getPostNoIncr(int postNum);
	
	public List<Post> getPostList();
	
	public boolean reigistPost(Post post);
	
	public boolean deletePost(Post post);
	
	public boolean editPost(Post post);
}
