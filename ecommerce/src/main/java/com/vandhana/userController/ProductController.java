package com.vandhana.userController;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.vandhana.dao.ProductDAO;

import com.vandhana.model.Product;



@Controller
public class ProductController {
	@Autowired
	private ProductDAO productDao;
	@RequestMapping("/productform")
	
	public String productform(Model model){
		
	model.addAttribute("product",new Product());
	model.addAttribute("products",productDao.getAllProduct());
	return "productform";
	}
	@RequestMapping("/addproduct")
	public String productform(@ModelAttribute("product") @Valid Product product, BindingResult result, Model model) {
		if(result.hasErrors()){
		model.addAttribute(product);
        model.addAttribute("product",new Product());
    	model.addAttribute("products",productDao.getAllProduct());
        List<Product> products= productDao.getAllProduct();
        return "productform";
		}
        productDao.addProduct(product);
        return "redirect:/productform";
	}
	
	@RequestMapping(value="/editproduct/id")
	public ModelAndView editProduct(@PathVariable("id")int id)
	{
		ModelAndView mv=new ModelAndView("Product");
		mv.addObject("product", productDao.getProductById(id));
		mv.setViewName("productform");
		return mv;
	
	}
	@RequestMapping(value="/deleteproduct/{id}",method=RequestMethod.GET)
	public String deleteProduct(@PathVariable int id)
	{
		productDao.delete(id);
		return "redirect:/productform";
		
	}

}
