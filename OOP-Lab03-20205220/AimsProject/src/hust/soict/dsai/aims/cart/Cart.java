package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	
	// Method to add a single DigitalVideoDisc to the cart
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added.");
            if (qtyOrdered == MAX_NUMBERS_ORDERED) {
                System.out.println("The cart is full.");
            } else if (qtyOrdered >= MAX_NUMBERS_ORDERED - 1) {
                System.out.println("The cart is almost full.");
            }
        } else {
            System.out.println("Cannot add disc. The cart is full.");
        }
    }
    
    //Method that allows passing an arbitrary number of arguments for DVDs
    public void addDigitalVideoDisc(DigitalVideoDisc... dvdList) {
        for (DigitalVideoDisc disc : dvdList) {
            if (qtyOrdered < MAX_NUMBERS_ORDERED) {
                itemsOrdered[qtyOrdered] = disc;
                qtyOrdered++;
                System.out.println("The disc has been added: " + disc.getTitle());
            } else {
                System.out.println("The cart is full. Cannot add more discs.");
                break; // Stop adding further discs if the cart is full
            }
        }
    }
    
    // Add two DVDs to the cart
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            // Add the first DVD
            itemsOrdered[qtyOrdered] = dvd1;
            qtyOrdered++;
            System.out.println("The first disc has been added: " + dvd1.getTitle());
        } else {
            System.out.println("The cart is full. Cannot add the first disc: " + dvd1.getTitle());
        }

        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            // Add the second DVD
            itemsOrdered[qtyOrdered] = dvd2;
            qtyOrdered++;
            System.out.println("The second disc has been added: " + dvd2.getTitle());
        } else {
            System.out.println("The cart is full. Cannot add the second disc: " + dvd2.getTitle());
        }
    }

    // Method to remove a DigitalVideoDisc from the cart
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == disc) {
                found = true;
                // Shift elements to the left to fill the gap
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null; // Clear last element
                qtyOrdered--;
                System.out.println("The disc has been removed.");
                break;
            }
        }
        if (!found) {
            System.out.println("The disc was not found in the cart.");
        }
    }

    // Method to calculate the total cost of items in the cart
    public float totalCost() {
        float total = 0.0f;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }
    
    //Method to print cart
    public void print() {
    	System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println((i + 1) + ". " + itemsOrdered[i].toString());
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }
    
    // Search for a DVD by ID
    public DigitalVideoDisc searchById(int id) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getId() == id) {
                return itemsOrdered[i];
            }
        }
        return null; // Notify in TestCart instead of here
    }


    // Search for a DVD by title
    public DigitalVideoDisc searchByTitle(String title) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].isMatch(title)) {
                return itemsOrdered[i];
            }
        }
        return null; // Notify in TestCart instead of here
    }

}
