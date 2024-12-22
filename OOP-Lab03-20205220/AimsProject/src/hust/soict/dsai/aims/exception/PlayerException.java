package hust.soict.dsai.aims.exception;

// PlayerException class extends Exception
public class PlayerException extends Exception {

    // Default constructor
    public PlayerException() {
        super(); // Calls the parent constructor (Exception)
    }

    // Constructor that accepts a message
    public PlayerException(String message) {
        super(message); // Passes the message to the parent constructor
    }

    // Constructor that accepts a message and a cause
    public PlayerException(String message, Throwable cause) {
        super(message, cause); // Passes both the message and cause to the parent constructor
    }

    // Constructor that accepts a cause
    public PlayerException(Throwable cause) {
        super(cause); // Passes the cause to the parent constructor
    }
}

