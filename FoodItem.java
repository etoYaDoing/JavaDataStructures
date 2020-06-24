import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * File name: FoodItem.java
 * Student name: @author Laura Ninikashvili
 * Course name: Data Structures
 * Lab Section: 301
 * Date: 2020-02-10
 * Description: This is a base class that contains common members
 * 
 *
 */



public class FoodItem {
private int itemCode;
private String itemName;
private float itemPrice;
private float itemCost;
private int itemQuantityInStock;

public FoodItem() {
	itemCode = 0;
	itemName = " ";
	itemPrice = 0.0f;
	itemCost = 0.0f;
	itemQuantityInStock = 0;
}

Scanner scanner = new Scanner(System.in);


	/*
	 * Asks user to enter common data to add a food item.
	 * Reads from the Scanner object passed in and fills the data member fields of the class with valid data;
Method returns true if program successfully reads in all fields, otherwise returns false
	 */
public boolean addItem(Scanner scanner) {
	boolean properInput = false;

	System.out.print("Enter the name for the item: ");
	itemName = scanner.next();
	while(!properInput)
	{
		System.out.print("Enter the quantity for the item: ");
		if(scanner.hasNextInt())
		{
			itemQuantityInStock = scanner.nextInt();
			if(itemQuantityInStock < 0)
			{
				properInput = false;
				System.out.println("Invalid input");
				itemQuantityInStock = 0;
			}
			else
				properInput = true;				
		}
		else
		{
			System.out.println("Invalid input");
			scanner.next();
			properInput = false;
		}
	}

	properInput = false;
	while(!properInput)
	{
		System.out.print("Enter the cost of the item: ");
		if(scanner.hasNextFloat())
		{
			itemCost = scanner.nextFloat();
			if(itemCost < 0)
			{
				properInput = false;
				System.out.println("Invalid input");
				itemCost = 0;
			}
			else
				properInput = true;
		}
		else
		{
			System.out.println("Invalid input");
			scanner.next();
			properInput = false;
		}
	}

	properInput = false;
	while(!properInput)
	{
		System.out.print("Enter the sales price of the item: ");
		if(scanner.hasNextFloat())
		{
			itemPrice = scanner.nextFloat();
			if(itemPrice < 0)
			{
				properInput = false;
				System.out.println("Invalid input");
				itemPrice = 0;
			}
			else
				properInput = true;
		}
		else
		{
			System.out.println("Invalid input");
			scanner.next();
			properInput = false;
		}
	}
	return true;
}

	
	
	
	
	/**
	 * Method returns true if the itemCode of the
	 *  object being acted on and the item object parameter are the same value
	 */
public boolean isEqual(FoodItem item) {
	return itemCode == item.itemCode;
}

public boolean inputCode(Scanner scanner) {
	boolean correctInput = false;
	while(!correctInput)
	{
		System.out.print("Enter the code for the item: ");
		if(scanner.hasNextInt())
		{
			itemCode = scanner.nextInt();
			correctInput = true;
		}
		else
		{
			System.out.println("Invalid code");
			scanner.next();
		}
	}
	return correctInput;
}
 

public boolean updateItem(int amount) {
	// If you are removing stock, then check that we have enough stock
	if(amount < 0 && itemQuantityInStock < (amount*-1))
	{
		return false;
	}
	itemQuantityInStock += amount;
	return true;
}

@Override
public String toString() {
	return "Item: "+itemCode+" "+itemName+" "+itemQuantityInStock+" price: $"+String.format("%.2f", itemPrice)+" cost: $"+String.format("%.2f", itemCost);
}

 
 
 
	protected  float acceptFloat(String prompt) {
		float value;
	
		System.out.println(prompt);
	
		while(true) {
			try {
				value = scanner.nextFloat();
				scanner.nextLine();
				break;
			} catch (InputMismatchException e) {
				System.err.println("Error, please enter a float");
				scanner.nextLine();
			}
		}
		return value;
	}

	protected String acceptString(String prompt) {
		String value = null;
		
		System.out.println(prompt);
		
		while(true) {
			while(!scanner.hasNextLine())
				scanner.next();
			value = scanner.nextLine().trim();
			if(!value.equals(""))
				break;
		}
		
		return value;
	}

	
}


