import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * File name: Inventory.java
 * Student name: @author Laura Ninikashvili
 * Course name: Data Structures
 * Lab Section: 301
 * Date: 2020-02-10
 * Description: This is a base class that contains common members
 * 
 *
 */
public class Inventory {

	private FoodItem[] inventory;
	private int numItems;

	public Inventory() {
		inventory = new FoodItem[20];
	}

	/**
	 * Default constructor:
	 */

	/**@param
	 * Adds an item to the inventory array – (uses polymorphism to call addItem
	 * method in the correct derived FoodItem class for input of the fields of the
	 * FoodItem)
	 */

	public boolean addItem(Scanner scanner) {
		if (numItems == 20) {
			System.out.println("Inventory is full");
			return false;
		}

		boolean properInput = false;
		FoodItem item = null;
		while (!properInput) {

			while (!properInput) {
				System.out.print("Do you wish to add a fruit(f), vegetable(v) or a preserve(p)? ");
				if (scanner.hasNext(Pattern.compile("[fFvVpP]"))) {
					String choice = scanner.next();
					switch (choice.toLowerCase()) {
					case "f":
						item = new Fruit();
						break;
					case "v":
						item = new Vegetable();
						break;
					case "p":
						item = new Preserved();
						break;
					default:
						item = new FoodItem();
						break;
					}
					properInput = true;
				} else {
					System.out.println("Invalid entry");
					scanner.next();
					properInput = false;
				}

			}

			if (item.inputCode(scanner)) {
				if (alreadyExists(item) < 0) {
					if (item.addItem(scanner)) {
						inventory[numItems] = item;
						numItems++;
						return true;
					}
					return false;

				} else {
					System.out.println("Item code already exists");
					return false;
				}
			}
		}
		return properInput;

	}

	/**@param
	 * Returns the index of a FoodItem in the inventory array with the same itemCode
	 *  as the FoodItem object in the parameter list, else returns -1
	 * 
	 * 
	 */

	public int alreadyExists(FoodItem item) {
		for (int i = 0; i < numItems; i++) {
			if (inventory[i].isEqual(item))
				return i;
		}
		return -1;
	}

	/** {@summary}
	 * Reads in an itemCode to update and quantity to update by and updates that item by the input quantity in the inventory array.
   The boolean parameter is used to denote whether buying operation (true) or selling operation (false) is occurring.
Method returns true/false on whether update was successful or not
	 * 
	 * 
	 */

	public boolean updateQuantity(Scanner scanner, boolean buyOrSell) {
		if (numItems == 0)
			return false;

		FoodItem obj = new FoodItem();
		obj.inputCode(scanner);
		int index = alreadyEsists(obj);
		if (index != -1) {
			String buySell = buyOrSell ? "buy" : "sell";
			System.out.println("Enter valid quantity to " + buySell + ": ");

			if (scanner.hasNext()) {
				int amount = scanner.nextInt();
				if (amount > 0) {
					return inventory[index].updateItem(buyOrSell ? amount : amount * -1);
				} else {
					System.out.println("Invalid quantity...");
				}
			} else {
				System.out.println("Invalid quantity...");
			}
		}
		return false;
	}

	@Override
	public String toString() {
		String returnString = "Inventory:\n";
		for (int i = 0; i < numItems; i++)
			returnString += inventory[i].toString() + "\n";
		return returnString;
	}

	private int alreadyEsists(FoodItem obj) {
		// TODO Auto-generated method stub
		return 0;
	}

}
