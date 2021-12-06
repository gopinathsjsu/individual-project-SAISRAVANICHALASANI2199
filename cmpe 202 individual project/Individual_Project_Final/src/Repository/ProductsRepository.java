package Repository;
import java.util.HashMap;
import java.util.Map;

public  class ProductsRepository {
	
	public static final Map<String,Products> MasterInventory = createInventory();
	
	private static Map<String, Products>createInventory() {
		
		
		final Map<String, Products> masterInventory = new HashMap<>();

		Products i = new Products("Milk","Essential", 6, 4.72);
		masterInventory.put("Milk", i);
		i=new Products("Bread", "Essential", 8 , 2.98);
		masterInventory.put("Bread", i);
		i=new Products("Oil", "Essential", 2 ,8.5);
		masterInventory.put("Oil", i);
		i=new Products("Cotton", "Essential", 4 , 11.2);
		masterInventory.put("Cotton", i);
		i=new Products("Apples", "Essential", 8 , 1);
		masterInventory.put("Apples", i);

		i=new Products("Chocolates", "Luxury", 12 , 3);
		masterInventory.put("Chocolates", i);
		i=new Products("Honey", "Luxury", 4 , 4.2);
		masterInventory.put("Honey", i);
		i=new Products("Cereal", "Luxury", 6 , 6.34);
		masterInventory.put("Cereal", i);
		i=new Products("Soap", "Luxury", 5 , 5);
		masterInventory.put("Soap", i);
		// row 10
		i=new Products("Detergent", "Luxury", 8 , 3);
		masterInventory.put("Detergent", i);
		// row 11
		i=new Products("Paint", "Luxury", 5 , 7);
		masterInventory.put("Paint", i);
		
		//-------------Misc------------------------
		// row 12
		i=new Products("Pillow", "Misc", 10 , 6.76);
		masterInventory.put("Pillow", i);
		// row 13
		i=new Products("Sheets", "Misc", 13 , 11.43);
		masterInventory.put("Sheets", i);
		// row 14
		i=new Products("Blanket", "Misc", 12 , 45.5);
		masterInventory.put("Blanket", i);
		// row 15
		i=new Products("Television", "Misc", 5 , 1100.54);
		masterInventory.put("Television", i);
		// row 16
		i=new Products("Map", "Misc", 2 , 2.92);
		masterInventory.put("Map", i);
		
		return masterInventory;
	}

    
	

}
