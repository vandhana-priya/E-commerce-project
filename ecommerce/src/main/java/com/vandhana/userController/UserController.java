package com.vandhana.userController;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.vandhana.dao.UserDAO;
import com.vandhana.model.User;

@Controller
public class UserController {
	@Autowired
	 private UserDAO userDao;
		
	@RequestMapping(value={"/login"},method={RequestMethod.GET,RequestMethod.POST})
	public String login(Model model, User user){
		model.addAttribute("user",new User());
		
		return "login";
	}
	@RequestMapping(value={"/logout"},method={RequestMethod.GET})
	public String logout(Model model){
		// model.addAttribute("user",new User());
		return "homepage";
	}
	@RequestMapping(value={"/cart"},method={RequestMethod.GET})
	public String cart(Model model){
		// model.addAttribute("user",new User());
		return "cart";
	}
	@RequestMapping("/test")
	public String getDefaultPage(Principal principal, Model model ){
		
		model.addAttribute("user click home", true);
		return "homepage";
	}
	@RequestMapping("/signup")
	public String signin(Model model){
		model.addAttribute("User", new User());
		model.addAttribute("Users",userDao.getAlluser());
		return "signup";
	}
	
	
	@RequestMapping("/User")
public String User(@ModelAttribute("User") User user, Model model) {
		System.out.println("name" + user.getName());
	System.out.println("username" + user.getUsername());
	System.out.println("email" + user.getEmail());
	System.out.println("password" + user.getPassword());
	System.out.println("confirmpassword" + user.getConfirmpassword());
	model.addAttribute("User",new User());
	model.addAttribute("Users", userDao.getAlluser());
	return "User";

}
@RequestMapping("/up")
public String getUserpage(@ModelAttribute("User") User user, Model model) {
	model.addAttribute("User",new User());
	model.addAttribute("Users",userDao.getAlluser());
    return "redirect:/User";
}

@RequestMapping("/add")
public String getpage(@ModelAttribute("User") @Valid User user,BindingResult result,Model model)
{
	if(result.hasErrors())
	{
	model.addAttribute("User",user);
	model.addAttribute("Users",userDao.getAlluser());
	List<User> Users= userDao.getAlluser();
	return "signup";
	}
	user.setRole("ROLE_USER");
	user.setEnabled(true);
	userDao.addUser(user);
	return "redirect:login";
	}
}



  