package Items;
public interface ICartElement {
	
	public boolean checkPermissable(CartItem cart);
	String getItemCategory(CartItem cartItem);
	double calPrice(CartItem cartItem);
	//String getCardNumbervalue(ShoppingCart cartItem);


}
