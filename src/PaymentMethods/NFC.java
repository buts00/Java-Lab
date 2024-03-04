package PaymentMethods;

import Main.IPayment;

/**
 * The NFC class represents a payment method using NFC (Near Field Communication).
 */
public class NFC implements IPayment {

    private double balance;

    /**
     * Constructs an NFC object with the specified balance.
     *
     * @param balance The initial balance of the NFC account.
     */
    public NFC(double balance) {
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
            System.out.println("Payment successful with method NFC");
        } else {
            System.out.println("Insufficient funds...");
        }
        System.out.println("Now in NFC you have: " + balance + "$");
    }

    /**
     * Retrieves the current balance of the NFC account.
     *
     * @return The current balance.
     */
    @Override
    public double getBalance() {
        return this.balance;
    }

}
