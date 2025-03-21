/*
 * Program To Utilize Overidding of Methods
 * Author: Thuku Josphat Wamwago
 * Reg No: CT101/G/19448/23
 * Date: 9/3/2025
 * Version: 1
 */

import java.util.Scanner;

class BankAccount{
    protected double balance;
    public BankAccount(){
        balance = 100;
    }
    void deposit(double addition){
        balance += addition;
        System.out.println("Deposit Successful: ");
        System.out.println("New Balance: " + balance);
    }
    void withdraw(double remove){
        balance -= remove;
    }
}
class SavingsAccount extends BankAccount1{
    @Override
    void withdraw(double remove){
        if(remove <= 100){
            balance -= remove;
            System.out.println("Withdrawal Successful: ");

            System.out.println("New Balance: " + balance);
        }
        else{
            System.out.println("Not Compatible");
        }
    }
}
class CheckingAccount extends BankAccount{
    @Override
    void withdraw(double remove){
        balance -= (remove +1);
        System.out.println("Withdrawal Successful: ");
        System.out.println("Charges: $1");
        System.out.println("New Balance: " + balance);
    }
}
class Main extends BankAccounts{
    public static void main(String [] args){

        Scanner scanner = new Scanner(System.in);
        BankAccount base = new BankAccount();
        SavingsAccount saves = new SavingsAccount();
        CheckingAccount check = new CheckingAccount();

        System.out.println("*****Hello******");
        System.out.println("Choose The Desired Operation: ");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        int choice = scanner.nextInt();

        if (choice == 1){
            System.out.print("Your Balance Is: " + base.balance);
        }
        else if(choice == 2){
            System.out.print("Please Enter The Amount: ");
            double deposit = scanner.nextDouble();
            base.deposit(deposit);
        }
        else if(choice == 3){
            System.out.print("Enter The Amount To Withdraw: ");
            double withdrawal = scanner.nextDouble();
            if(withdrawal > base.balance){
                System.out.println("Cannot Withdraw Greater Funds ");
                System.exit(1);
            }
            if(base.balance >= 100){
                saves.withdraw(withdrawal);
            }
            else{
                check.withdraw(withdrawal);
            }
        }

    }
}
