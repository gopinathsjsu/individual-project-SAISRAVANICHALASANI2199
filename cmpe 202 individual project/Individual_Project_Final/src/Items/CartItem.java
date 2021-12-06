package Items;


public interface CartItem {

	
	boolean validatePermissable(Cart cartItem);
	String getItemCategory(Cart cartItem);
	double calPrice(Cart cartItem);

}
