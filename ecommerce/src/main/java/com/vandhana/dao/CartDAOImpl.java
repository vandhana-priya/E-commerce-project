package com.vandhana.dao;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vandhana.dao.CartDAO;
import com.vandhana.model.Cart;
import com.vandhana.model.CartItem;
import com.vandhana.model.User;

@Transactional
@Repository("cartDao")
public class CartDAOImpl implements CartDAO{
	@Autowired
	SessionFactory sessionFactory;

	
	public void addCartItem(Cart cart) {

		sessionFactory.getCurrentSession().saveOrUpdate(cart);

	}

	
	public void removeCartItem(Cart cart, CartItem cartItem) {
		int count = 0;
		for(CartItem car : cart.getCartItems()){
			if (car.getId() == cartItem.getId()) {
				System.out.println("----------------------------------------------------- found");
			}else{
				count++;
			}
		}
		List<CartItem> cis = cart.getCartItems();
		
		cart.setGrandTotal(cart.getGrandTotal() - cartItem.getSubTotal());
		cis.remove(count);
		cart.setCartItems(cis);
		addCartItem(cart);

	}

	
	public void deleteCart(Cart cart) {
		
		sessionFactory.getCurrentSession().delete(cart);

	}

	
	public Cart getCartByUser(User user) {
		
		try{
			return sessionFactory.getCurrentSession().createQuery("FROM Cart WHERE USER_ID = '"+user.getId()+"'", Cart.class).getSingleResult();
		}catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		}
	}

	
	public CartItem getCartItemById(int id) {
		
		return sessionFactory.getCurrentSession().get(CartItem.class, id);
	}
}
