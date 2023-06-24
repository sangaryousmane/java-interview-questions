package oops;

public class BankAccount {


    private double balance;
    private double numOfDeposits;
    private double widthdrawals;
    private double interestRate;
    public double monthlyServiceCharges;

    public BankAccount() {}

    public BankAccount(double balance, double interestRate) {
        this.balance = balance;
        this.interestRate = interestRate * 12;
    }

    // deposit if the amount is greater than 0
    public double deposit(double amount){
        if (amount > 0.0){
            this.balance +=amount;
            this.numOfDeposits++;
        }
        return this.balance;
    }

    // withdraw if the balance is greater than 0
    public void withdraw(double amount){
        if (this.balance > 0.0){
            this.balance -= amount;
            this.widthdrawals++;
        }
    }
    public double calInterest(){
        double annualInterest = this.interestRate * (30 * 12);
        double monthlyInterestRate = annualInterest / 12;
        double monthlyInterest = this.balance * monthlyInterestRate;
        return this.balance * monthlyInterest;
    }

    public double getMonthlyServiceCharges(){
        this.calInterest();
        this.numOfDeposits = 0;
        this.widthdrawals = 0;
        return this.balance - this.monthlyServiceCharges;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getNumOfDeposits() {
        return numOfDeposits;
    }

    public void setNumOfDeposits(double numOfDeposits) {
        this.numOfDeposits = numOfDeposits;
    }

    public double getWidthdrawals() {
        return widthdrawals;
    }

    public void setWidthdrawals(double widthdrawals) {
        this.widthdrawals = widthdrawals;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void setMonthlyServiceCharges(double monthlyServiceCharges) {
        this.monthlyServiceCharges = monthlyServiceCharges;
    }
}
