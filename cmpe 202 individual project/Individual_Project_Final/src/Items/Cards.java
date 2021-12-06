package Items;
import java.util.ArrayList;

public class Cards {
	
	private static ArrayList<String> existingCreditCards = new ArrayList<String>();
	
	private static Cards creditcardInstance = null;
	  

	private Cards() {
		existingCreditCards = addCards();
	}
	
	public static Cards getInstance()
	{
	        if (creditcardInstance == null)
	        	creditcardInstance = new Cards();
	 
	        return creditcardInstance;
	}

	  

	private ArrayList<String> addCards() {
		  existingCreditCards.add("5023 4512 7612 9087");
		  existingCreditCards.add("1234 5678 9101 4519");
		
		return existingCreditCards;
	}
	
	public static void checkAndAddCards(String newCard) {
		
		      if(existingCreditCards.contains(newCard)) {
		    	  System.out.println("Card is already present in DB  : " + newCard);
		    	   
		      }
		      else {
		    	  existingCreditCards.add(newCard);
		    	  System.out.println("New Card doesnt exist in DB, adding now");
		    }
		      
		   displayExistingCreditCards();
	}
	
	private static void displayExistingCreditCards() {
		System.out.println("********* Printing all credit cards *********");
		for ( String cards: existingCreditCards)
	        System.out.println(cards);
		
	}
	
	
	public static void makePayment(String cardNumber) {
		Cards.getInstance();
		checkAndAddCards(cardNumber);
		System.out.println("Payment Successful");
		
	}
	
	
	
	 
	    

}
