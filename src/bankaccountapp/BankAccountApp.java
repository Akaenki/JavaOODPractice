package bankaccountapp;
import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {
    public static void main(String[] args){
        List<String[]> holders = utilities.CSV.read("./src/bankaccountapp/NewBankAccounts.csv");
        List<Account> accounts = new LinkedList<>();
        for(String[] h : holders){
            String type = h[2];
            if(type.equals("Checking")){
                accounts.add(new Checking(h[0], h[1], Double.parseDouble(h[3])));
            } else if(type.equals("Savings")){
                accounts.add(new Saving(h[0], h[1], Double.parseDouble(h[3])));
            } else System.out.println("Error Account Type: " + type);
        }
        for(Account a : accounts){
            a.showInfo();
            System.out.println("***************");
        }
    }
}
