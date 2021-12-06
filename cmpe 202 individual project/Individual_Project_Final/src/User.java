
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import Component.OutputFile;
import Component.Reader;
import Items.Cards;
import Items.Cart;
import Validation.CartValidation;


public class User {
	


	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a file name: ");
		System.out.flush();
		String filename = scanner.nextLine();
		
		File file = new File(filename);
		String absolute_filePath = file.getAbsolutePath();
		
		ArrayList<Cart> items = Reader.readFile(absolute_filePath);

        String cardNumber = Reader.readCard(absolute_filePath);
        
		
		CartValidation shoppingCartValidation = new  CartValidation();
		boolean cartPermissible = shoppingCartValidation.checkIfCartItemIsPermissable(items);
		boolean capHitFlag = shoppingCartValidation.checkIfCapLimit(items);
		boolean cartValid = false;
		
		
		ArrayList<String>  capOverFlowItems = new ArrayList<String>();
		double final_cost = 0;
		
		if (!cartPermissible || capHitFlag) {
			capOverFlowItems.addAll(shoppingCartValidation.getinvalidEssentialItem());
			capOverFlowItems.addAll(shoppingCartValidation.getinvalidLuxuryItem());
			capOverFlowItems.addAll(shoppingCartValidation.getinvalidMiscItem());
			
			OutputFile.writeErrorFile(shoppingCartValidation.getInvalidPermissableItem(),capOverFlowItems);
		} 
		else {
			cartValid = true;
			final_cost = shoppingCartValidation.getTotalCost();
		}
	
	
		if (cartValid)
		{
			Cards.makePayment(cardNumber);
			OutputFile.writeOutputCost(final_cost);
	
		}
		
		
	}	
		
	}
	
	
