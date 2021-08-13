package com.cubrid.board.post;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/board")
public class postController {
	
	@Autowired
	private PostServiceImpl postService;
	
	@Autowired
	public PostMapper postMapper;
	
	@GetMapping("/list/{postNum}")
	public ModelAndView getPost(@PathVariable Integer postNum) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/post/postView");
		
		Post post = postService.getPost(postNum);
		
		mav.addObject("Post", post);
		return mav;
	}
	
	@GetMapping("/list")
	public ModelAndView getPostList() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/post/postList");
		List<Post> list = postService.getPostList();
		
		mav.addObject("PostList", list);
		return mav;
	}
	
	@GetMapping("/regist")
	public ModelAndView registPostView() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/post/postRegist");
		
		return mav;
	}
	
	@PostMapping("/regist")
	public ModelAndView registPost(Post post) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/board/list");
		
		postService.reigistPost(post);
//		mav.addObject("RegistPost", post);
		return mav;
	}
	
	@DeleteMapping("/list/{postNum}/delete")
	public ModelAndView deletePost(@PathVariable int postNum) {
		ModelAndView mav = new ModelAndView();
		Post post = new Post();
		post.setPostNum(postNum);
		postService.deletePost(post);
		
		mav.setViewName("redirect:/board/list");
		return mav;
	}
	
	@GetMapping("/list/{postNum}/edit")
	public ModelAndView editPostView(@PathVariable int postNum) {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/post/postEdit");
		
		Post post = postService.getPostNoIncr(postNum);
		
		mav.addObject("EditPost", post);
		return mav;
	}
	
	@PutMapping("/edit/{postNum}")
	public ModelAndView editPost(Post post) {
		ModelAndView mav = new ModelAndView("redirect:/board/list");
		
		postService.editPost(post);
		
		return mav;
	}
	
	@GetMapping("/runbatch")
	public void runBatch() {
		System.out.println(postService.runBatch());
	}
}
