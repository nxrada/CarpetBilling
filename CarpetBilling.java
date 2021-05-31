import java.util.Scanner;
import java.util.Random; 
import java.text.DecimalFormat;
/*
 * Generates billing slips for a carpet company.
 * @author Nick Kammerer
 * @version 1.0 
 */
public class CarpetBilling {
	
	public static final float TAX = 0.085f; // Constant tax rate.
	
	/**
	 * Outputs customer billing slip for carpet purchase. 
	 * @param Args  A reference to a string array to store
     *             command-line arguments. 
	 */
	public static void main(String[] args) {
		// Declaration of variables.
		String forename, surname, customerID;
		int length, width, area;
		Random random = new Random();
		float cost, carpetPrice,taxPrice, totalPrice;
		Scanner input = new Scanner(System.in);
		DecimalFormat measurementFormat, moneyFormat, percentFormat, taxPriceFormat, costFormat;
		
		// Prompt & accept user input.
		System.out.print("Enter your first name: ");
		forename = input.nextLine();
		System.out.print("Enter your last name: ");
		surname = input.nextLine();
		System.out.print("Enter length of room (feet): ");
		length = input.nextInt();
		System.out.print("Enter width of room (feet): ");
		width = input.nextInt();
		System.out.print("Enter cost per square foot: ");
		cost = input.nextFloat();		
		
		// Close scanner. 
		input.close();
		
		// Case-correct forename and surname. 
		forename = forename.substring(0, 1).toUpperCase() + forename.substring(1).toLowerCase();
		surname = surname.substring(0, 1).toUpperCase() + surname.substring(1).toLowerCase();
		
		// Calculate customerID. 
		if (surname.length() > 5) {
			customerID = forename.charAt(0) + surname.substring(0,5) + random.nextInt(10) + random.nextInt(10);
		}
		else {
			customerID = forename.charAt(0) + surname.substring(0,surname.length()) + random.nextInt(10) + random.nextInt(10);
		}

		// Calculate area. 
		area = length * width; 
		
		// Calculate prices. 
		carpetPrice = cost * area;
		taxPrice = carpetPrice * TAX;
		totalPrice = carpetPrice + taxPrice;
		
		// DecimalFormat objects for output formatting. 
		measurementFormat = new DecimalFormat("000");
		moneyFormat = new DecimalFormat("$0000.00");
		percentFormat = new DecimalFormat("0.00%");
		taxPriceFormat = new DecimalFormat("0000.00");
		costFormat = new DecimalFormat("00.00");
		
		// Output bill. 
		System.out.println("CUSTOMER"); 
		System.out.println("Last Name \t" + surname); 
		System.out.println("First Name \t" + forename); 
		System.out.println("ID \t \t" + customerID); 
		System.out.println(" "); 
		System.out.println("MEASUREMENT"); 
		System.out.println("Length \t" + measurementFormat.format(length) + " feet"); 
		System.out.println("Width \t" + measurementFormat.format(width) + " feet"); 
		System.out.println("Area \t" + measurementFormat.format(area) + " square feet"); 
		System.out.println(" ");
		System.out.println("CHARGES");
		System.out.println("Description \t Cost/Sq.Ft. \t Charges");
		System.out.println("----------- \t ----------- \t --------");
		System.out.println("Carpet \t \t " + costFormat.format(cost) + "\t \t " + moneyFormat.format(carpetPrice));
		System.out.println("Tax \t \t  " + percentFormat.format(TAX) + " \t  " + taxPriceFormat.format(taxPrice));
		System.out.println("\t \t \t \t --------");
		System.out.println("Total \t \t \t \t " + moneyFormat.format(totalPrice));

	}

}