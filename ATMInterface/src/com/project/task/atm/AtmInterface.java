package com.project.task.atm;

import java.util.Scanner;

public class AtmInterface {
	 public static void main(String[] args) throws Exception {
		 	//scanner
	        Scanner scanner = new Scanner(System.in);
	        //creating the object of ATM Class
	        ATM atm = new ATM();

	        System.out.println("Welcome to the ATM Interface!");
	        System.out.print("Enter User ID: ");
	        //taking the userID from the user
	        String userID = scanner.next();

	        System.out.print("Enter PIN: ");
	        //taking the PIN from the user
	        String userPIN = scanner.next();

	        if (atm.authenticateUser(userID, userPIN)) {
	            System.out.println("Authentication successful. Welcome, " + userID + "!");
	            displayMenu(atm, userID, scanner);
	        } else {
	            System.out.println("Invalid credentials. Exiting...");
	        }
	        scanner.close();
	    }

	    private static void displayMenu(ATM atm, String userID, Scanner scanner) {
	        while (true) {
	            System.out.println("\n ATM Menu: ");
	            System.out.println("1. Check Balance");
	            System.out.println("2. Withdraw Money");
	            System.out.println("3. Deposit Money");
	            System.out.println("4. Exit");

	            System.out.print("Enter your choice: ");
	            //Taking the input from the user
	            int choice = scanner.nextInt();
	            
	            //Switch case
	            switch (choice) {
	                case 1:
	                    System.out.println("Current Balance: ₹" + atm.checkBalance(userID));
	                    break;

	                case 2:
	                    System.out.print("Enter amount to withdraw: ₹");
	                    double withdrawAmount = scanner.nextDouble();
	                    atm.withdrawMoney(userID, withdrawAmount);
	                    break;

	                case 3:
	                    System.out.print("Enter amount to deposit: ₹");
	                    double depositAmount = scanner.nextDouble();
	                    atm.depositMoney(userID, depositAmount);
	                    break;

	                case 4:
	                    System.out.println("Exiting. Thank you!");
	                    System.exit(0);
	                    
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        }
	    }
}
