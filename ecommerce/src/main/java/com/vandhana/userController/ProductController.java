package com.vandhana.userController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.vandhana.dao.CategoryDAO;
import com.vandhana.dao.ProductDAO;
import com.vandhana.model.Category;
import com.vandhana.model.Product;
// import com.vandhana.model.Category;

@Controller
public class ProductController {
	@Autowired
	private ProductDAO productDao;
	@Autowired
	private CategoryDAO categoryDao;

	private Product product;

	private Category category;

	@RequestMapping("/productform")
	public String productform(@ModelAttribute("product") Product product, Model model) {
		System.out.println("------1-----");

		model.addAttribute("product", new Product());
		System.out.println("------3-----");
		model.addAttribute("products", productDao.getAllProduct());
		System.out.println("------4-----");
		model.addAttribute("categories", categoryDao.getAllCategory());
		System.out.println("------5-----");
		return "productform";
	}

	@RequestMapping(value = "/category", method = RequestMethod.POST)
	public String product(@ModelAttribute("category") Category category, Model model) {
		model.addAttribute("category", category);
		List<Category> categories = categoryDao.getAllCategory();
		model.addAttribute("categories", categoryDao.getAllCategory());
		categoryDao.addCategory(category);
		return "redirect:/productform";
	}

	@RequestMapping(value = "/addproduct", method = RequestMethod.POST)
	public String product(@ModelAttribute("product") Product product, Model model) {
		model.addAttribute("uploadFile", product);
		model.addAttribute("uploadFiles", productDao.getAllProduct());
		List<Product> products = productDao.getAllProduct();
		this.product = productDao.addProduct(product);
		return "uploadFile";
	}

	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public String uploadFile(@RequestParam("file") MultipartFile file, HttpServletRequest request, Model model) {
		model.addAttribute("uploadFile", product);
		model.addAttribute("uploadFiles", productDao.getAllProduct());
		List<Product> products = productDao.getAllProduct();
		String imagepath = request.getServletContext().getRealPath("/resources/images");
		System.out.println("Directory:" + imagepath);
		Path path = Paths.get(imagepath + File.separator + product.getProductId() + ".jpg");
		File imageFile = new File(path.toString());
		System.out.println("Path:" + path.toString());
		if (!imageFile.exists()) {
			imageFile.mkdirs();
		}
		try {
			file.transferTo(imageFile);
			return "redirect:/productform";
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "productform";
	}

	@RequestMapping(value = "/editproduct/id")
	public ModelAndView editProduct(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("Product");
		mv.addObject("product", productDao.getProductById(id));
		mv.setViewName("productform");
		return mv;

	}

	@RequestMapping(value = "/deleteproduct/{id}", method = RequestMethod.GET)
	public String deleteProduct(@PathVariable int id) {
		productDao.delete(id);
		return "redirect:/productform";

	}

}
