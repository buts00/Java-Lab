package Main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * The PaymentTerminal class represents a terminal for processing payments.
 */
public class PaymentTerminal {

    private final List<IPayment> paymentMethods;

    /**
     * Constructs a PaymentTerminal object with an empty list of payment methods.
     */
    public PaymentTerminal() {
        this.paymentMethods = new ArrayList<>();
    }

    /**
     * Adds a payment method to the terminal.
     *
     * @param paymentMethod The payment method to add.
     */
    public void addPaymentMethod(IPayment paymentMethod) {
        paymentMethods.add(paymentMethod);
    }

    /**
     * Displays the available payment methods and their balances.
     */
    public void choosePaymentMethod() {
        System.out.println("Choose payment method:");
        for (int i = 0; i < paymentMethods.size(); i++) {
            System.out.println((i + 1) + ". " + paymentMethods.get(i).getClass().getSimpleName() + "( "
                    + paymentMethods.get(i).getBalance() + "$ )");
        }
    }

    /**
     * Processes a payment with the specified amount.
     *
     * @param amount The amount to pay.
     */
    public void processPayment(double amount) {
        choosePaymentMethod();
        Scanner scanner = new Scanner(System.in);
        try {
            int choice = scanner.nextInt();
            if (choice < 1 || choice > paymentMethods.size()) {
                throw new Error("Invalid input. Please enter a valid operation from " + 1 + " to " + paymentMethods.size());
            }
            paymentMethods.get(choice - 1).pay(amount);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid operation from " + 1 + " to " + paymentMethods.size());
        } catch (Error e) {
            System.out.println(e.getMessage());
        }
    }

}
