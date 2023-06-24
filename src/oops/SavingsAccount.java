package oops;

import javax.naming.InsufficientResourcesException;

public class SavingsAccount extends BankAccount {

    private boolean status = true;

    public SavingsAccount() {
    }

    public boolean isActive() {
        this.status = this.getBalance() > 25;
        return status;
    }

    public void withdraw(double amount) {
        if (isActive()) {
            super.withdraw(amount);
        } else {
            throw new RuntimeException("Sorry, the account is inactive");
        }
    }
    public double deposit(double amount) {
        if (!isActive() && (amount + getBalance() > 25)) {
            super.deposit(amount);
        } else {
            throw new RuntimeException("Sorry, the account is inactive");
        }
        return this.getBalance();
    }

    public void monthlyProcess(double monthlyProces){
        System.out.println("Processing starts");
        if (super.getWidthdrawals() > 4){
            super.monthlyServiceCharges +=1;
        }
        if (getBalance() < 25)
            this.status = false;

        System.out.println("Processing done.");
    }
}
