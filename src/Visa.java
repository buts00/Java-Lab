public class Visa implements IPayment {

    private double balance;

    public Visa(double balance) {
        this.balance = balance;
    }

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

    @Override
    public double getBalance() {
        return this.balance;
    }

}
