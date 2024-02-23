public class MasterCard implements IPayment {

    private double balance;

    public MasterCard(double balance) {
        this.balance = balance;
    }

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

    @Override
    public double getBalance() {
        return this.balance;
    }

}
