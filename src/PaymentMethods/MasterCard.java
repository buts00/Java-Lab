package PaymentMethods;

import Main.IPayment;

/**
 * The MasterCard class represents a payment method using MasterCard.
 */
public class MasterCard implements IPayment {

    private double balance;

    /**
     * Constructs a MasterCard object with the specified balance.
     *
     * @param balance The initial balance of the MasterCard account.
     */
    public MasterCard(double balance) {
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
            System.out.println("Payment successful with method MasterCard");
        } else {
            System.out.println("Insufficient funds...");
        }
        System.out.println("Now in MasterCard you have: " + balance + "$");
    }

    /**
     * Retrieves the current balance of the MasterCard account.
     *
     * @return The current balance.
     */
    @Override
    public double getBalance() {
        return this.balance;
    }

}
