package com.vandhana.userController;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vandhana.dao.CartDAO;
import com.vandhana.dao.ProductDAO;
import com.vandhana.dao.UserDAO;
import com.vandhana.model.Cart;
import com.vandhana.model.CartItem;
import com.vandhana.model.Product;
import com.vandhana.model.User;


@Controller
public class CartController {
	@Autowired
	UserDAO userDao;

	@Autowired
	CartDAO cartDao;

	@Autowired
	ProductDAO productDao;

	@RequestMapping("/addtocart/{id}")
	public String addToCart(@PathVariable int id, Model model, Principal principal) {

		User user = userDao.getUserByUsername(principal.getName());
		Product product = productDao.getProductById(id);

		boolean found = false;

		List<CartItem> cartItems;
		CartItem cartItem;
		Cart cart;
		if ((cart = cartDao.getCartByUser(user)) == null) {
			cart = new Cart();
			cartItem = new CartItem();
			cartItem.setProduct(product);
			cartItem.setQuantity(1);
			cartItem.setSubTotal(product.getPrice());

			cartItems = new ArrayList<CartItem>();
			cartItems.add(cartItem);

			cart.setCartItems(cartItems);
			cart.setUser(user);
			cart.setGrandTotal(cartItem.getSubTotal());

			cartDao.addCartItem(cart);

		} else {
			for (CartItem ci : cart.getCartItems()) {
				if (ci.getProduct().getProductId() == id) {
					ci.setQuantity(ci.getQuantity() + 1);
					ci.setSubTotal(ci.getQuantity() * ci.getProduct().getPrice());
					cart.setGrandTotal(cart.getGrandTotal() + ci.getProduct().getPrice());
					found = true;
				}
			}

			if (!found) {
				cartItem = new CartItem();
				cartItem.setProduct(product);
				cartItem.setQuantity(1);
				cartItem.setSubTotal(product.getPrice());

				cart.getCartItems().add(cartItem);
				cart.setGrandTotal(cart.getGrandTotal() + cartItem.getSubTotal());

			}

			cartDao.addCartItem(cart);
		}
		model.addAttribute("cart", cart);
		return "redirect:/cart";
	}

	@RequestMapping(value = { "/checkout" })
	public String getpage() {
		return "homepage";
	}

	@RequestMapping("/delete/cartItem/{id}")
	public String deleteCartItem(@PathVariable int id, Principal principal, Model model) {

		CartItem cartItem = cartDao.getCartItemById(id);
		User user = userDao.getUserByUsername(principal.getName());
		Cart cart = cartDao.getCartByUser(user);
		cartDao.removeCartItem(cart, cartItem);
		model.addAttribute("cart", cart);
		return "redirect:/user/cart";
	}

	@RequestMapping("/cart")
	public String getCart(Principal principal, Model model) {

		User user = userDao.getUserByUsername(principal.getName());
		Cart cart = cartDao.getCartByUser(user);
		model.addAttribute("cart", cart);
		return "cart";
	}
}
