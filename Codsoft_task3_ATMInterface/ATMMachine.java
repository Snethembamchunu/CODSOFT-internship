package Codsoft_task3_ATMInterface;

import java.util.Scanner;
public class ATMMachine{
    private BankAccount bankAccount;

    public ATMMachine(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void processTransaction() {
        Scanner scanner = new Scanner(System.in);
        boolean continueProcessing = true;

        while (continueProcessing) {
            int option =  0;
        while (option !=  4){ 
            System.out.println("\nWelcome to the ATM, what would you like to do today: ");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("select an option: ");
            option = scanner.nextInt();
           // int option = scanner.nextInt();
           
            switch (option) {
                case  1:
                    System.out.print("Enter the amount you'd like to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (bankAccount.withdraw(withdrawAmount)) {
                        System.out.println("Withdrawal successful.");
                    } else {
                        System.out.println("Insufficient funds.");
                    }
                    break;
                case  2:
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    bankAccount.deposit(depositAmount);
                    System.out.println("Deposit successful.");
                    break;
                case  3:
                    System.out.println("Your current balance is: " + bankAccount.getBalance());
                    break;
                case  4:
                    System.out.println("Thank you for using our services. Have a great day!");
                    scanner.close();
                    System.exit(1);
                default:
                    System.out.println("Invalid option. Try again.");
            }

             // Prompt user to go back to menu or exit
             if (option !=  4) {
                System.out.print("Would you like to go back to the menu? (Y/N): ");
                char goBack = scanner.next().charAt(0);
                if (goBack != 'Y' && goBack != 'y') {
                    continueProcessing = false;
                }
        }
    }
}
    }

}