

import java.util.Scanner;

public class Main {

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
                terminal.processPayment(amount);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid amount or 'exit' to quit.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        scanner.close();
    }

}
