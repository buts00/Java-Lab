package Main;

/**
 * The IPayment interface represents a payment method.
 */
public interface IPayment {
    /**
     * Processes a payment with the specified amount.
     *
     * @param amount The amount to pay.
     */
    void pay(double amount);

    /**
     * Retrieves the current balance of the payment method.
     *
     * @return The current balance.
     */
    double getBalance();
}
