package hust.soict.dsai.aims;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

public class Aims {
	private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);
    
	public static void main(String[] args) {
		// Add some sample media to the store
        store.addMedia(new DigitalVideoDisc(1, "The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        store.addMedia(new DigitalVideoDisc(2, "Inception", "Sci-Fi", "Christopher Nolan", 148, 24.99f));
        store.addMedia(new DigitalVideoDisc(3, "Star Wars", "Sci-Fi", "George Lucas", 87, 24.95f));
        List<String> authors = new ArrayList<>();
        authors.add("J.K. Rowling");
        store.addMedia(new Book(4, "Harry Potter", "Fantasy", 39.99f, authors));
        List<Track> tracks = new ArrayList<>();
        store.addMedia(new CompactDisc(5, "Abbey Road", "Music", "The Beatles", "George Martin", tracks, 12.99f));

        int choice;
        do {
            showMenu();
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> viewStore();
                case 2 -> updateStore();
                case 3 -> seeCart();
                case 0 -> System.out.println("Exiting application. Goodbye!");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void viewStore() {
        store.printStore();
        int choice;
        do {
            storeMenu();
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> seeMediaDetails();
                case 2 -> addMediaToCart();
                case 3 -> playMedia();
                case 4 -> seeCart();
                case 0 -> System.out.println("Returning to main menu.");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void seeMediaDetails() {
        System.out.println("Enter the title of the media:");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);
        if (media != null) {
            System.out.println(media);
            mediaDetailsMenu(media);
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void mediaDetailsMenu(Media media) {
        int choice;
        do {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add to cart");
            if (media instanceof Playable) {
                System.out.println("2. Play");
            }
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> cart.addMedia(media);
                case 2 -> {
                    if (media instanceof Playable playable) {
                        playable.play();
                    } else {
                        System.out.println("This media cannot be played.");
                    }
                }
                case 0 -> System.out.println("Returning to store menu.");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    public static void addMediaToCart() {
        System.out.println("Enter the title of the media to add to the cart:");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);
        if (media != null) {
            cart.addMedia(media);
            System.out.println("Media added to cart.");
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void playMedia() {
        System.out.println("Enter the title of the media to play:");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);
        if (media instanceof Playable playable) {
            playable.play();
        } else if (media != null) {
            System.out.println("This media cannot be played.");
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void updateStore() {
        System.out.println("Options: ");
        System.out.println("1. Add media to store");
        System.out.println("2. Remove media from store");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1 -> {
                System.out.println("Adding new media is not implemented yet.");
            }
            case 2 -> {
                System.out.println("Enter the title of the media to remove:");
                String title = scanner.nextLine();
                Media media = store.searchByTitle(title);
                if (media != null) {
                    store.removeMedia(media);
                    System.out.println("Media removed from store.");
                } else {
                    System.out.println("Media not found.");
                }
            }
            default -> System.out.println("Invalid choice.");
        }
    }

    public static void seeCart() {
        cart.print();
        int choice;
        do {
            cartMenu();
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> filterCart();
                case 2 -> sortCart();
                case 3 -> removeMediaFromCart();
                case 4 -> playMediaFromCart();
                case 5 -> placeOrder();
                case 0 -> System.out.println("Returning to main menu.");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    public static void filterCart() {
        System.out.println("Filter by: 1. ID, 2. Title");
        int choice = Integer.parseInt(scanner.nextLine());
        if (choice == 1) {
            System.out.println("Enter ID:");
            int id = Integer.parseInt(scanner.nextLine());
            cart.filterById(id);
        } else if (choice == 2) {
            System.out.println("Enter title:");
            String title = scanner.nextLine();
            cart.filterByTitle(title);
        } else {
            System.out.println("Invalid choice.");
        }
    }

    public static void sortCart() {
        System.out.println("Sort by: 1. Title, 2. Cost");
        int choice = Integer.parseInt(scanner.nextLine());
        if (choice == 1) {
            cart.sortByTitle();
        } else if (choice == 2) {
            cart.sortByCost();
        } else {
            System.out.println("Invalid choice.");
        }
    }

    public static void removeMediaFromCart() {
        System.out.println("Enter the title of the media to remove:");
        String title = scanner.nextLine();
        Media media = cart.searchByTitle(title);
        if (media != null) {
            cart.removeMedia(media);
            System.out.println("Media removed from cart.");
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void playMediaFromCart() {
        System.out.println("Enter the title of the media to play:");
        String title = scanner.nextLine();
        Media media = cart.searchByTitle(title);
        if (media instanceof Playable playable) {
            playable.play();
        } else if (media != null) {
            System.out.println("This media cannot be played.");
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void placeOrder() {
        System.out.println("An order has been placed. Cart is now empty.");
        cart.clear();
    }
}
