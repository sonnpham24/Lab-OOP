package hust.soict.dsai.test.cart;

import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class CartTest {

	public static void main(String[] args) {
		//Create a new cart
		Cart cart = new Cart();
		
		//Create new dvd objects and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		cart.addDigitalVideoDisc(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		cart.addDigitalVideoDisc(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "Aladin", "Animation", 18.99f);
		cart.addDigitalVideoDisc(dvd3);
		
		//Test the print method
		cart.print();
		//To-do: Test the search methods here
		Scanner scanner = new Scanner(System.in);
		
		// Search by ID
        System.out.println("Enter the ID to search for a DVD:");
        int searchId = scanner.nextInt();
        DigitalVideoDisc resultById = cart.searchById(searchId);
        if (resultById != null) {
            System.out.println("Search result: " + resultById);
        } else {
            System.out.println("No DVD found with ID: " + searchId);
        }

        // Search by Title
        System.out.println("Enter the title to search for a DVD:");
        scanner.nextLine(); // Consume newline left by nextInt
        String searchTitle = scanner.nextLine();
        DigitalVideoDisc resultByTitle = cart.searchByTitle(searchTitle);
        if (resultByTitle != null) {
            System.out.println("Search result: " + resultByTitle);
        } else {
            System.out.println("No DVD found with title: \"" + searchTitle + "\"");
        }

        scanner.close();
	}

}
