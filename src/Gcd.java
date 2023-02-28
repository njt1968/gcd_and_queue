import java.util.Scanner;

public class Gcd {
    public static void main(String[] args) throws Exception {
        // Get user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter numerator: ");
        int numerator = readInt(scanner);
        System.out.println("Enter denominator: ");
        int denominator = readInt(scanner);

        // Show the user what they entered
        System.out.println("Numerator: " + numerator + " Denominator: " + denominator);

        // Calculates GCD and handles the GCD = 1 exception case
        try {
            int gcd = calculateGCD(numerator, denominator);
            System.out.println("Calculated GCD: " + gcd);
        } catch (GCDException e) {
            System.out.println(e.getMessage());
        }
        scanner.close();
    }

    public static int readInt(Scanner scanner) {
        // Simple user input read loop
        int num = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                num = Integer.parseInt(scanner.nextLine().trim());
                validInput = true;
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter an integer.");
            }
        }
        return num;
    }

    public static int calculateGCD(int numerator, int denominator) throws GCDException {
        // GCD Algorithm
        int max;
        int gcd = 1;
        if (numerator > denominator) {
            max = numerator;
        } else {
            max = denominator;
        }
        for (int i = max; i > 0; i--) {
            if ((numerator % i == 0) && (denominator % i == 0)) {
                gcd = i;
                break;
            }
        }

        // Throw exception if GCD is 1
        if (gcd == 1) {
            throw new GCDException("Exception triggered because the GCD was equal to 1.");
        }
        return gcd;
    }
}

class GCDException extends Exception {
    GCDException(String message) {
        super(message);
    }
}