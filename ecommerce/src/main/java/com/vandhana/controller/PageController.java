package com.vandhana.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.vandhana.dao.ProductDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	@Autowired
	private ProductDAO productDao;
	
	
    @RequestMapping(value={"/","/homepage","/index"}) 
	public ModelAndView homepage(){
    	ModelAndView mv = new ModelAndView("homepage");
    	mv.addObject("products",productDao);
    	mv.addObject("user click home",true);
    	return mv;
    	 
     }
 
    

}

