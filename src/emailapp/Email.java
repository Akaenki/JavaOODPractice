package emailapp;

import java.util.Scanner;

public class Email {
    private String firstName, lastName, password, department, alternateEmail, email;
    private int mailboxCapacity, defaultPasswordLength = 10;

    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        // Asking for department
        department = setDepartment();
        // Generate random password
        password = randomPassword(defaultPasswordLength);

        email = firstName.toLowerCase() + "." + lastName.toString() + "@" + department + "company.com";
    }

    private String setDepartment(){
        System.out.print("Department Codes\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter the department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();

        switch (depChoice){
            case 1: return "sales.";
            case 2: return "dev.";
            case 3: return "acct.";
            default: return "";
        }
    }

    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
        char[] password = new char[length];
        for(int i = 0; i<length; ++i){
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return password.toString();
    }

    public void setMailboxCapacity(int capacity){
        mailboxCapacity = capacity;
    }

    public void setAlternateEmail(String altEmail){
        alternateEmail = altEmail;
    }

    public void changePassword(String password){
        this.password = password;
    }

    public int getMailboxCapacity() { return mailboxCapacity; }
    public String getAlternateEmail() { return alternateEmail; }
    public String getPassword() { return password; }

    public String showInfo(){
        return "DISPLAY NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email;
    }
}
