package Validation;
import java.util.ArrayList;
import java.util.Map;

import Items.Cart;
import Items.CartItem;
import Repository.Products;
import Repository.ProductsRepository;

public class CartItemValidation implements CartItem{
	
	

	@Override
	public boolean validatePermissable(Cart cartItem) {

		Map<String,Products> localInventory= ProductsRepository.MasterInventory;
		Products item = localInventory.get(cartItem.getName());
		
		System.out.println("Available Quantity for " + cartItem.getName() +" is " +item.getAvailableQuantity());
		System.out.println("Cart Quantity for " + cartItem.getName() +" is " +cartItem.getQuantity());
		if (cartItem.getQuantity()>item.getAvailableQuantity()) {
			
			return false;
		}
		
		return true;
	}
	
	@Override
	public String getItemCategory(Cart cartItem) {
		Map<String,Products> localInventory= ProductsRepository.MasterInventory;
		Products item = localInventory.get(cartItem.getName());
		return item.getCategory();
		
	}

	@Override
	public double calPrice(Cart cartItem) {
		Map<String,Products> localInventory= ProductsRepository.MasterInventory;
		Products item = localInventory.get(cartItem.getName());
		double cost = item.getCost() * cartItem.getQuantity();
		return cost;
	}
	
	

	

	
	
	


	


	
}
