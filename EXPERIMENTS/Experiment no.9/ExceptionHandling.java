public class ExceptionHandling {  
    public static void main(String args[]) {  
        try {  
            // Code that may raise an exception
            int data = 100 / 0; // This will cause an ArithmeticException (division by zero)
        } catch (ArithmeticException e) {
            // Handle the ArithmeticException
            System.out.println("Exception caught: " + e);  
        } finally {
            // Code inside the 'finally' block will execute whether exception occurs or not
            System.out.println("This block (finally) is always executed.");  
        }
        // Rest of the code
        System.out.println("Rest of the code...");  
    }  
}
