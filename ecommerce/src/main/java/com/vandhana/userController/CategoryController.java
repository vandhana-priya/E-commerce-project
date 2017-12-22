package com.vandhana.userController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.vandhana.dao.CategoryDAO;
import com.vandhana.model.Category;
@Controller
public class CategoryController {
		@Autowired
			private CategoryDAO categoryDao;
			@RequestMapping("/category")
			   public String getProductPage(Model model)
			   {
				model.addAttribute("category", new Category());
				 model.addAttribute("categories",categoryDao.getAllCategory());
				 return "category";  
			   }
			 @RequestMapping(value="addCategory", method=RequestMethod.POST)
			   public String getAddProductPage(@ModelAttribute("category")Category category)
			   {
				 categoryDao.addCategory(category);
				
				 return "redirect:/category";
			  }
			   @RequestMapping(value="/editcategory/{id}")
			   public ModelAndView editCategory(@PathVariable int id)
			   {
			ModelAndView mv=new ModelAndView("category");
			mv.addObject("category",categoryDao.getCategoryById(id));
			return mv;
			   }	  
			   @RequestMapping(value="/deletecategory/{id}",method=RequestMethod.GET)
			   public String deleteCategory(@PathVariable int id)
				   {
				   categoryDao.delete(id);
				   return "redirect:/category";
				   }

			 
		}

