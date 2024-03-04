package Main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class PaymentTerminal {

    private final List<IPayment> paymentMethods;

    public PaymentTerminal() {
        this.paymentMethods = new ArrayList<>();
    }

    public void addPaymentMethod(IPayment paymentMethod) {
        paymentMethods.add(paymentMethod);
    }

    public void choosePaymentMethod() {
        System.out.println("Choose payment method:");
        for (int i = 0; i < paymentMethods.size(); i++) {
            System.out.println((i + 1) + ". " + paymentMethods.get(i).getClass().getSimpleName() + "( "
                    + paymentMethods.get(i).getBalance() + "$ )");
        }
    }

    public void processPayment(double amount) {
        choosePaymentMethod();
        Scanner scanner = new Scanner(System.in);
        try {
            int choice = scanner.nextInt();
            if (choice < 1 || choice > paymentMethods.size()) {
                throw new Error("Invalid input. Please enter a valid operation from\" + 1 + \"to\" + paymentMethods.size()");
            }
            paymentMethods.get(choice - 1).pay(amount);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid operation from" + 1 + "to" + paymentMethods.size());
        } catch (Error e) {
            System.out.println(e.getMessage());
        }
    }

}
