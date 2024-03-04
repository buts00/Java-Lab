package PaymentMethods;

import Main.IPayment;

/**
 * The Visa class represents a payment method using Visa.
 */
public class Visa implements IPayment {

    private double balance;

    /**
     * Constructs a Visa object with the specified balance.
     *
     * @param balance The initial balance of the Visa account.
     */
    public Visa(double balance) {
        this.balance = balance;
    }

    /**
     * Processes a payment with the specified amount.
     *
     * @param amount The amount to pay.
     */
    @Override
    public void pay(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Payment successful with method Visa");
        } else {
            System.out.println("Insufficient funds...");
        }
        System.out.println("Now in Visa you have: " + balance + "$");
    }

    /**
     * Retrieves the current balance of the Visa account.
     *
     * @return The current balance.
     */
    @Override
    public double getBalance() {
        return this.balance;
    }

}
