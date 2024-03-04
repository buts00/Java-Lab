package PaymentMethods;

import Main.IPayment;

/**
 * The Cryptocurrency class represents a payment method using cryptocurrency.
 */
public class Cryptocurrency implements IPayment {

    private double balance;

    /**
     * Constructs a Cryptocurrency object with the specified balance.
     *
     * @param balance The initial balance of the cryptocurrency account.
     */
    public Cryptocurrency(double balance) {
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
            System.out.println("Payment successful with method Cryptocurrency");
        } else {
            System.out.println("Insufficient funds...");
        }
        System.out.println("Now in Cryptocurrency you have: " + balance + "$");
    }

    /**
     * Retrieves the current balance of the cryptocurrency account.
     *
     * @return The current balance.
     */
    @Override
    public double getBalance() {
        return this.balance;
    }

}
