public class Cryptocurrency implements IPayment {

    private double balance;

    public Cryptocurrency(double balance) {
        this.balance = balance;
    }

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

    @Override
    public double getBalance() {
        return this.balance;
    }

}
