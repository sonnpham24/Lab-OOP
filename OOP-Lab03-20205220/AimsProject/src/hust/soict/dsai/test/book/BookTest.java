package hust.soict.dsai.test.book;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.media.Book;

public class BookTest {
    public static void main(String[] args) {
        // Create a list of authors for the first book
        List<String> authors1 = new ArrayList<>();

        // Create a book instance
        Book book1 = new Book(1, "Harry Potter and the Cursed Child", "Fantasy", 29.99f, authors1);
        authors1.add("J.K. Rowling");
        authors1.add("John Tiffany");
        authors1.add("Jack Thorne");

        // Print book details
        System.out.println("Book ID: " + book1.getId());
        System.out.println("Book Title: " + book1.getTitle());
        System.out.println("Book Category: " + book1.getCategory());
        System.out.println("Book Cost: " + book1.getCost() + " $");
        System.out.println("Book Authors: " + book1.authors);

        // Add a new author
        book1.addAuthor("Conan Doyle");

        // Attempt to add an existing author
        book1.addAuthor("J.K. Rowling");

        // Remove an existing author
        book1.removeAuthor("Jack Thorne");

        // Attempt to remove a non-existing author
        book1.removeAuthor("abcd");

        // Print final details
        System.out.println("\nUpdated Book Authors: " + book1.authors);
    }
}

