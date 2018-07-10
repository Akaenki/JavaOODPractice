package bankaccountapp;

public abstract class Account implements Rate{
    private String name, ssn;
    protected String accountNumber;
    private double balance;
    protected double rate;
    private static int uniqueCode = 1000;

    public Account(String name, String ssn, double initDeposit){
        this.name = name;
        this.ssn = ssn;
        balance = initDeposit;
        accountNumber = setAccountNumber();
    }

    private String setAccountNumber(){
        int rand = (int) (100 + Math.random()*900);
        return ssn.substring(ssn.length()-2,ssn.length()) + ++uniqueCode + rand;
    }

    public void deposit(double amount){
        balance += amount;
    }

    public void withdraw(double amount){
        balance -= amount;
    }

    public void transfer(Account a, double amount){
        balance -= amount;
        a.deposit(amount);
    }

    public void compound(){
        double accruedInterest = balance * (rate / 100.0);
        System.out.println("Accrued Interest: $" + accruedInterest);
    }

    public abstract void setRate();

    public void showInfo(){
        System.out.println("Name: " + name +
                "\nAccount Number: " + accountNumber +
                "\nBalance: $" + balance);
    }
}
