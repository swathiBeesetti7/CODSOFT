import java.util.*;
class BankAccount {
    private double balance;

    public BankAccount (double InitialBal){
        balance = InitialBal;
    }

    public double getBalancee() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount){
        if(amount <= balance){
            balance -= amount;
            return true;
        }
        else{
            return false;
        }
    }
}

class ATM{
    private BankAccount account;
    public ATM(BankAccount account) {
        this.account = account;
    }

    public void Menu() {
        System.out.println("Welcome to ATM");
        System.out.println("1. Check balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdrawl");
        System.out.println("4. Exit");
    }

    public void Transac(){
        Scanner sc = new Scanner(System.in);
        int choice;
        double amount;

        while(true){
            Menu();
            System.out.println("please enter your choice: ");
            choice = sc.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Your current balance is : Rs. " + account.getBalancee() + "\n");
                    break;
                case 2:
                    System.out.println("Enter amount to deposit: Rs. ");
                    amount  = sc.nextDouble();

                    if(amount>0){
                        account.deposit(amount);
                        System.out.println("Deposit successful\n");
                    }
                    else{
                        System.out.println("Invalid deposit amount\n");
                    }
                    break;
                case 3:
                    System.out.println("Enter the withdrawl amount: Rs. ");
                    amount = sc.nextDouble();
                    if(amount>0 && account.withdraw(amount)) {
                        System.out.println("Withdrawl successful\n");
                    }
                    else{
                        System.out.println("Invalide withdrawl amount or insufficient balance\n");
                    }
                    break;
                case 4:
                    System.out.println("Thank you! ,visit again\n");
                    return;
                default:
                    System.out.println("invalid choice. please choose valid option\n");
            }

        }
    }
}

public class Atm_intr4 {
    public static void main(String[] args) {
        BankAccount userAcc = new BankAccount(1000.0);
        ATM atm = new ATM(userAcc);
        atm.Transac();

    }
}