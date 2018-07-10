package bankaccountapp;

public class Checking extends Account{
    private String cardNumber;
    private int cardPIN;

    public Checking(String name, String ssn, double initDeposit){
        super(name, ssn, initDeposit);
        accountNumber = "1" + accountNumber;
        setDebitCard();
        setRate();
    }

    private void setDebitCard(){
        cardNumber = "";
        for(int i = 0; i<12; ++i){
            cardNumber += (int) (Math.random() * 10);
        }
        cardPIN = (int) (1000 + Math.random()*9000);
    }

    @Override
    public void setRate() {
        rate = getBaseRate() * .15;
    }

    @Override
    public void showInfo(){
        System.out.println("Type: Checking Account");
        super.showInfo();
        System.out.println("CARD#: " + cardNumber + "\nPIN: " + cardPIN);
    }
}
