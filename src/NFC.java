public class NFC implements IPayment {

    private double balance;

    public NFC(double balance) {
        this.balance = balance;
    }

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

    @Override
    public double getBalance() {
        return this.balance;
    }

}
