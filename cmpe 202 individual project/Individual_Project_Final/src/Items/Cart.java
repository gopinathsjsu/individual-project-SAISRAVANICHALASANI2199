package Items;

public class Cart implements ICartElement{
	
	private String itemName;
	private int Quantity;
	private String cardNumber;
	
	public Cart(String itemName, int Quantity, String cardNumber){
		this.itemName = itemName;
		this.Quantity=Quantity;
		this.cardNumber = cardNumber;
		
	
	}
	
	public String getName() {
		return this.itemName;
	}
	
	
	public int getQuantity() {
		return this.Quantity;
	}
	
	public String getCardNumber() {
		return this.cardNumber;
	}


	@Override
	public boolean checkPermissable(CartItem cart) {
		return cart.validatePermissable(this);
	}
	
	
	@Override
	public String getItemCategory(CartItem cart) {
		return cart.getItemCategory(this);
	}
	

	
	
	@Override
	public double calPrice(CartItem cart) {
		return cart.calPrice(this);
	}

	

}
