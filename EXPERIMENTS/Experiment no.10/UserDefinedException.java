// A Class that uses the above MyException
public class UserDefinedException {
    // Driver Program
    public static void main(String args[]) {
        try {
            // Throw an object of user-defined exception
            throw new MyException("User-Defined Exception occurred");
        } catch (MyException ex) {
            // Exception is caught here
            System.out.println("Caught the exception");

            // Print the message from MyException object
            System.out.println(ex.getMessage());
        }
    }
}

// A Class that represents user-defined exception
class MyException extends Exception {
    // Constructor that accepts a string message
    public MyException(String s) {
        // Call the constructor of the parent Exception class
        super(s);
    }
}

