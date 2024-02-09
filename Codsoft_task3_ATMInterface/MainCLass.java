package Codsoft_task3_ATMInterface;

public class MainCLass {
    //Main class to run the ATM interface
    public static void main(String[] args) {
        // Create a BankAccount instance with an initial balance
        BankAccount myAccount = new BankAccount(1000.00);
        // Create an ATM instance and pass the BankAccount
        ATMMachine myATM = new ATMMachine(myAccount);
        // Start processing transactions
        myATM.processTransaction();
    }
}
