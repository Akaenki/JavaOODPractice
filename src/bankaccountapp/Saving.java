package bankaccountapp;

public class Saving extends Account{
    private int depositBoxID, depositBoxKey;

    public Saving(String name, String ssn, double initDeposit){
        super(name, ssn, initDeposit);
        accountNumber = "2" + accountNumber;
        setDepositBox();
        setRate();
    }

    private void setDepositBox(){
        depositBoxID = (int) (100 + Math.random()*900);
        depositBoxKey = (int) (1000 + Math.random()*9000);
    }

    @Override
    public void setRate() {
        rate = getBaseRate() - 0.25;
    }

    @Override
    public void showInfo(){
        System.out.println("Type: Saving Account");
        super.showInfo();
        System.out.println("Safty Deposit Box ID: " + depositBoxID
                + "\nSafty Deposit Box Key: " + depositBoxKey);
    }
}
