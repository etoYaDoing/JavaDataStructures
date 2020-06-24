

import java.util.Scanner;
import java.util.regex.Pattern;

public class Assign1 {

	public static void displayMenu() {
		System.out.println("Please select one of the following: ");
		System.out.println("1. Add Item to Inventory");
		System.out.println("2. Display Current Inventory");
		System.out.println("3. Buy Item(s)");
		System.out.println("4. Sell Item(s)");
		System.out.println("5. To Exit");
		System.out.print("> ");
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		input.useDelimiter(Pattern.compile("[\\r\\n]+"));
		Inventory inventory = new Inventory();
		int option = 0;
		while (option != 5) {
			try
			{
				displayMenu();
				if (input.hasNext(Pattern.compile("[1-5]"))) {
					option = input.nextInt();
					switch(option)
					{
					case 1: 
						if(!inventory.addItem(input))
							System.out.println("Error...could not add item");
						break;
					case 2: 
						System.out.println(inventory);
						break;
					case 3: 
						if(!inventory.updateQuantity(input, true))
							System.err.println("Error...could not buy item");
						break;
					case 4: 
						if(!inventory.updateQuantity(input, false))
							System.err.println("Error...could not sell item");
						break;
					case 5: 
						System.out.println("Exiting...");
						break;
					default: 
						System.err.println("Something went wrong");
						break;
					}
				} else {
					System.err.println("Incorrect value entered");
					input.next();
				}
			}
			catch(Exception e)
			{
				System.err.println("Error Occurred: "+e.getMessage());
			}
		}
		input.close();
	}

}
