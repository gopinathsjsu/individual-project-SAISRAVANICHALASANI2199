package Repository;

public class Products {
	
	private String itemName;
	private String category;
	private int availableQuantity;
	private double cost;
	
	public Products(String itemName, String category,int availableQuantity, double cost){
		this.itemName = itemName;
		this.category=category;
		this.availableQuantity=availableQuantity;
		this.cost=cost;
	}
	
	public String getName() {
		return this.itemName;
	}
	
	
	public int getAvailableQuantity() {
		return this.availableQuantity;
	}

	public String getCategory() {
		return this.category;
	}
	
	public double getCost() {
		return this.cost;
	}




}
