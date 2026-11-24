// try catch
import java.util.Scanner;

public class exc {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number a: ");
        Integer a = sc.nextInt();
        System.out.println("Enter Number b: ");
        Integer b = sc.nextInt();
        sc.close();

        try {
            int result = a/b;
            System.out.println("Result " + result);
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero");
        }

        System.out.println("Program Completed");
    }
}

// throw
public class exc {
    public static void main(String[] args) {
        int balance = 5000;
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nCurrent Balance: " + balance);
            System.out.print("Enter Withdraw Amount (0 to Exit): ");
            int withdraw = sc.nextInt();
            
            if (withdraw == 0) {
                System.out.println("Thank You!");
                break;
            }
            
            try {
                if (withdraw < 0) {
                    throw new ArithmeticException("Invalid Amount");
                }
                if (withdraw > balance) {
                    throw new ArithmeticException("Insufficient Balance");
                    
                }
                balance -= withdraw;
                System.out.println("Withdrawal successful");
                System.out.println("Remaining Balance: " + balance);
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
                
                if (e.getMessage().equals("Insufficient Balance") || e.getMessage().equals("Invalid Amount")) {
                    System.out.println("Exiting program...");
                    break;
                }
            }
        }
        sc.close();
    }
}

//throws


import java.io.FileReader;
import java.io.IOException;

public class exec {
    
static void readFile() throws IOException {
    
FileReader f = new FileReader("data.txt");

System.out.println("File opened successfully");

f.close();
}

public static void main(String[] args) {
    
try {
    
readFile();
}
catch (IOException e) {
    
System.out.println("Unable to read file");
}
}
}

// custom exception

class FailException extends Exception {
    FailException(String message) {
        super(message);
    }
}

public class exec {
    static void checkMarks(int marks)
        throws FailException {
            if (marks < 40) {
                throw new FailException("Student has failed");
            }
            System.out.println("Student has passed");
        }

    public static void main(String[] args) {
        try {
            checkMarks(30);
        } catch (FailException e) {
            System.out.println(e.getMessage());
        }
    }    
}