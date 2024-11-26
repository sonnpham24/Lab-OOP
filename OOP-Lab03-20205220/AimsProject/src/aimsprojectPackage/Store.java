package aimsprojectPackage;

public class Store {
	private static final int MAX_ITEMS = 100; // Maximum DVDs the store can hold
    private DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[MAX_ITEMS];
    private int qtyInStore = 0; 
    
    // Method to add DVDs
    public void addDVD(DigitalVideoDisc dvd) {
        if (qtyInStore < MAX_ITEMS) {
            itemsInStore[qtyInStore] = dvd;
            qtyInStore++;
            System.out.println("The DVD \"" + dvd.getTitle() + "\" has been added to the store.");
        } else {
            System.out.println("Cannot add DVD. The store is full.");
        }
    }
    
    // Method to remove DVDs
    public void removeDVD(DigitalVideoDisc dvd) {
        boolean found = false;
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i] == dvd) {
                found = true;
                // Shift items to fill the gap
                for (int j = i; j < qtyInStore - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[qtyInStore - 1] = null; // Clear the last element
                qtyInStore--;
                System.out.println("The DVD \"" + dvd.getTitle() + "\" has been removed from the store.");
                break;
            }
        }
        if (!found) {
            System.out.println("The DVD \"" + dvd.getTitle() + "\" was not found in the store.");
        }
    }
    
    // Method to print the list of DVDs currently in the store
    public void printStore() {
        System.out.println("******************* STORE *******************");
        if (qtyInStore == 0) {
            System.out.println("The store is empty.");
        } else {
            System.out.println("Available DVDs:");
            for (int i = 0; i < qtyInStore; i++) {
                System.out.println((i + 1) + ". " + itemsInStore[i]);
            }
        }
        System.out.println("*********************************************");
    }

}
