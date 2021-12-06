package Component;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class OutputFile {
	

	
	public static void writeErrorFile(ArrayList<String> arrayList,ArrayList<String> capOverFlowItems) {
	  try {
	      FileWriter fw = new FileWriter("error.txt");
	      fw.write("Please correct the quantities!!!");
	      fw.write("\n");
	      if(!arrayList.isEmpty()) {
			fw.write("\n Item & quantity that exceeds available quantity in inventory :\n ");	     
			fw.write(arrayList.toString());
			//rgyjuktgfgbhujki
	    
	      }
	      fw.write("\n");
	      if(!capOverFlowItems.isEmpty()) {
			fw.write("\n Category Limit  Reached!!  Items in Cart : ");
			fw.write(capOverFlowItems.toString());
	      }
	      fw.close();
	      System.out.println("successful");
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	}
	
	
	public static void writeOutputCost(double final_cost) {
		  try {
		      FileWriter fw = new FileWriter("output.csv");
		      fw.write("Total cost \n");
		      fw.write(String.valueOf(final_cost));
		      fw.close();
		      System.out.println(" successful");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		}
	  

}
