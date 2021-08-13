package com.cubrid.board.stats;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/stats")
public class StatsController {

	@Autowired
	public StatsServiceImpl statsService;
	
	@GetMapping("/list")
	public ModelAndView statsList() {
		//TODO 리스트 리턴
		List<Stats> statsList = statsService.getStatsList();
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/stats/statsList");
		mav.addObject("StatsList", statsList);
		return mav;
	}
	
	@PostMapping("/list")
	public ModelAndView statsDate(String date) {
		
		List<Stats> statsList = statsService.getStatsByDate(date);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/stats/statsDate");
		mav.addObject("StatsList", statsList);
		return mav;
	}
}
