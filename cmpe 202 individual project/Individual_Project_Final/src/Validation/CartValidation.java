package Validation;
import java.util.ArrayList;

import Items.Cart;
import Items.CartItem;

public class CartValidation {
	
	
	private ArrayList<String>  invalidPermissableItem = new ArrayList<String>();
	private ArrayList<String> invalidEssentialItem = new ArrayList<String>();
	private ArrayList<String> invalidLuxuryItem = new ArrayList<String>();
	private ArrayList<String> invalidMiscItem = new ArrayList<String>();
	private static int essentialCap = 5;
	private static int luxuryCap = 3;
	private static int miscCap = 6;
	
	private static double totalCost;
	
	public CartValidation(){
		
	}
	public double getTotalCost() {
		return totalCost;
	}
	public ArrayList<String>  getInvalidPermissableItem(){
		return invalidPermissableItem;
	}
	
	public ArrayList<String> getinvalidEssentialItem() {
		return invalidEssentialItem;
	}
	
	public ArrayList<String> getinvalidLuxuryItem() {
		return invalidLuxuryItem;
	}
	
	public ArrayList<String> getinvalidMiscItem() {
		return invalidMiscItem;
	}
	
	
	public boolean checkIfCartItemIsPermissable(ArrayList<Cart> cart) {
		boolean permissableFlag=true;
		CartItem shoppingCart = new CartItemValidation();
		
		String tempString = null;
		
		for(Cart cartItem : cart){
			
			
			//checking if item is permissable based on item quantity 
			if (!cartItem.checkPermissable(shoppingCart)) {
				permissableFlag=false;
				tempString = cartItem.getName().concat(" : ").concat(Integer.toString(cartItem.getQuantity()));
				invalidPermissableItem.add(tempString);
				
			}
		
		}
		
		return permissableFlag;
	}
	
	
	
	public boolean checkIfCapLimit(ArrayList<Cart> cart) {
		boolean capHitFlag=false;
		int essentialsCount=0;
		int luxuryCount=0;
		int miscCount=0;
		CartItem shoppingCart = new CartItemValidation();
		
		
		
		for(Cart cartItem : cart){
			//checking if category cap hit happens
			String tempCategory =cartItem.getItemCategory(shoppingCart);
			if (tempCategory.equals("Essential")) {
				essentialsCount += cartItem.getQuantity();
				if (essentialsCount > essentialCap ) {
					capHitFlag=true;
					invalidEssentialItem.add(tempCategory +" : " .concat(cartItem.getName()).concat(" : ").concat(Integer.toString(cartItem.getQuantity())));
				}
			
			}
			else if (tempCategory.equals("Luxury")) {
				luxuryCount += cartItem.getQuantity();
				if (luxuryCount > luxuryCap ) {
					capHitFlag=true;
					invalidLuxuryItem.add(tempCategory +" : " .concat(cartItem.getName()).concat(" : ").concat(Integer.toString(cartItem.getQuantity())));
				}
			}
			else if (tempCategory.equals("Misc")) {
				miscCount += cartItem.getQuantity();
				if (miscCount > miscCap ) {
					capHitFlag=true;
					invalidMiscItem.add(tempCategory +" : " .concat(cartItem.getName()).concat(" : ").concat(Integer.toString(cartItem.getQuantity())));
				}
			}
			
			totalCost = totalCost + cartItem.calPrice(shoppingCart);
		
		}
		
		
		return capHitFlag;
	}
	
	
}

