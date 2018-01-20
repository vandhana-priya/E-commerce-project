package com.vandhana.dao;
import com.vandhana.model.Cart;
import com.vandhana.model.CartItem;
import com.vandhana.model.User;
public interface CartDAO {
	public Cart getCartByUser(User user);
	public void addCartItem(Cart cart);
	public void removeCartItem(Cart cart,CartItem cartItem);
	public void deleteCart(Cart cart);
	public CartItem getCartItemById(int id);
}
