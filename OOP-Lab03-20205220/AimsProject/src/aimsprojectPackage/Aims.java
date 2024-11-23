package aimsprojectPackage;

public class Aims {

	public static void main(String[] args) {
		// Create a new cart
		Cart anOrder = new Cart();
		
		// Create new dvd objects and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		anOrder.addDigitalVideoDisc(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		anOrder.addDigitalVideoDisc(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		anOrder.addDigitalVideoDisc(dvd3);
		
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("A Quiet Place: Day One", "Horror", "Michael Sarnoski", 99, 68.25f);
		anOrder.addDigitalVideoDisc(dvd4);
		
		anOrder.removeDigitalVideoDisc(dvd4);
		
		// Add two DVDs at once
        anOrder.addDigitalVideoDisc(dvd1, dvd2);
        System.out.println("Total Cost: " + anOrder.totalCost());
        
		// Adding multiple DVDs using varargs
		anOrder.addDigitalVideoDisc(dvd1, dvd2, dvd3);
		System.out.println("Total Cost: " + anOrder.totalCost());
	}
}
