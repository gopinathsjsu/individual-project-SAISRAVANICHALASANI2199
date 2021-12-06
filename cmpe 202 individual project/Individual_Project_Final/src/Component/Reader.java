package Component;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import Items.Cart;

public class Reader {
	
	public String filePath;
	
	public Reader(String filePath) {
		this.filePath = filePath;
	}
	
	
	public static String readCard(String filePath) {
		
		
		
        Path pathToFile = Paths.get(filePath);
        
        String[] attributes;
        String cardnumberString = null;
        
        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.US_ASCII)) {         
        	 
        	String line = br.readLine();
        	 while ((line = br.readLine()) != null) {
            if (!line.isEmpty()) {	
                attributes = line.split(" ");      
                cardnumberString = attributes[2];
                break;
            	}
        	 }
                   
            
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        
        return cardnumberString;
		
	}
	

	public static ArrayList<Cart>  readFile(String filePath) {
	
	ArrayList<Cart> items = new ArrayList<>();
	
    Path pathToFile = Paths.get(filePath);
    String line;
    String[] attributes;
    
    try (BufferedReader br = Files.newBufferedReader(pathToFile,
            StandardCharsets.US_ASCII)) {         
    	 
    	br.readLine();
       
        while ( (line = br.readLine()) != null) { 
        	
        	 if (!line.isEmpty()) {
        		 
            attributes = line.split(" ");
            Cart item = createItem(attributes);
            items.add(item);
           
        	}
            
        }
        
    } catch (IOException ioe) {
        ioe.printStackTrace();
    }
    
    return items;
	
}
	



private static Cart createItem(String[] metadata) {
    String itemName = metadata[0];
    int quantity = Integer.parseInt(metadata[1]);
    String cardNumber = metadata[2];
    return new Cart(itemName, quantity,cardNumber);
}

}