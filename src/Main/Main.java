package Main;

import PaymentMethods.Cryptocurrency;
import PaymentMethods.MasterCard;
import PaymentMethods.NFC;
import PaymentMethods.Visa;

import java.util.Scanner;

/**
 * The Main class represents the entry point of the payment terminal application.
 */
public class Main {

    /**
     * The main method initializes a payment terminal, adds payment methods,
     * and processes payments based on user input.
     *
     * @param args The command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        PaymentTerminal terminal = new PaymentTerminal();
        terminal.addPaymentMethod(new Visa(1000));
        terminal.addPaymentMethod(new MasterCard(2000));
        terminal.addPaymentMethod(new NFC(3000));
        terminal.addPaymentMethod(new Cryptocurrency(4000));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter payment amount (or type 'exit' to quit): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting...");
                break;
            }

            try {
                double amount = Double.parseDouble(input);
                if (amount < 0) {
                    throw new IllegalArgumentException("Payment amount cannot be negative.");
                }
                CheckAmount(amount);
                terminal.processPayment(amount);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid amount or 'exit' to quit.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
    }

    /**
     * Checks if the amount has more than two decimal places.
     *
     * @param amount The amount to check.
     * @throws IllegalArgumentException If the number of decimal places exceeds 2.
     */
    public static void CheckAmount(double amount) throws IllegalArgumentException {

        String[] parts = String.valueOf(amount).split("\\.");
        if (parts.length > 1 && parts[1].length() > 2) {
            throw new IllegalArgumentException("The number of decimal places cannot exceed 2");
        }
    }

}
