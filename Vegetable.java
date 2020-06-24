import java.util.Scanner;

public class Vegetable extends FoodItem {

	private String farmName;

	public Vegetable() {
		super();
		farmName = "";
	}

	@Override
	public boolean addItem(Scanner scanner) {
		if(super.addItem(scanner))
		{
			System.out.print("Enter the name of the farm supplier: ");
			farmName = scanner.next();				
		}
		return true;
	}

	@Override
	public String toString() {
		return super.toString()+" farm supplier: "+farmName;
	}
}

