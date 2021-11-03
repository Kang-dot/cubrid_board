package com.cubrid.copy.json;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/copy")
public class JsonController {
	@Autowired
	private JsonServiceImpl jsonServiceImpl;
	
	@GetMapping("/json")
	public ModelAndView getCopyJsonList() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/copy/jsonResult");
		mav.addObject("jsonResult", jsonServiceImpl.copyDataStart());

		return mav;
	}
}
