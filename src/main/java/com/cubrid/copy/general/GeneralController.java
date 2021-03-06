package com.cubrid.copy.general;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/copy")
public class GeneralController {
	@Autowired
	private GeneralServiceImpl generalServiceImpl;
	
	@GetMapping("/general")
	public ModelAndView getOracleDataList(@RequestParam("num") String num) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/copy/generalResult");
		mav.addObject("generalResult", generalServiceImpl.copyDataStart(num));
		
		return mav;
	}
	
	@GetMapping("/batch")
	public ModelAndView getOracleDataBatchList(@RequestParam("num") String num) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/copy/generalResult");
		mav.addObject("generalResult", generalServiceImpl.batchDataStart(num));
		
		return mav;
	}
}
