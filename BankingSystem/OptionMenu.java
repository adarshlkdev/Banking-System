package com.company.adarsh;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class OptionMenu extends Account{
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'₹'###,##0.00");

    HashMap<Integer , Integer> data = new HashMap<>();

    public void getLogin() throws IOException {
        int x = 1;
        do {
            try {
                data.put(323233, 23647);   // <Customer Number , PIN >
                data.put(523232, 75848);

                System.out.println("<----------Welcome to ATM Project--------->");
                System.out.println("Enter your Customer Number :");
                setCustomerNumber(menuInput.nextInt());

                System.out.println("Enter your PIN number :");
                setPinNumber(menuInput.nextInt());

            } catch (Exception e) {
                System.out.println("\nInvalid Character(s).Only numbers.\n");
                x = 2;
            }

            int cn = getCustomerNumber();
            int pn = getPinNumber();
            if (data.containsKey(cn) && data.get(cn) == pn) {
                getAccountType();

            } else {
                System.out.println("Wrong Customer Number or Pin Number..." + "\n");
            }
        }
            while (x == 1) ;
    }

    public void getAccountType()
    {
        System.out.println("Select the Account you want to access:");
        System.out.println("Type 1 -- Current Account");
        System.out.println("Type 2 -- Savings Account");
        System.out.println("Type 3 -- Exit");

        int selection = menuInput.nextInt();

        switch (selection) {
            case 1 -> getCurrent();
            case 2 -> getSaving();
            case 3 -> System.out.println("Thank You for using our ATM , BYE....");
            default -> System.out.println("\nInvalid Choice\n");
        }
    }
    public void getCurrent(){
        System.out.println("Current Account....");
        System.out.println("Press 1 --  Balance Enquiry");
        System.out.println("Press 2 --  Withdraw Money");
        System.out.println("Press 3 --  Deposit Money");
        System.out.println("Press 4 --  Exit");
        System.out.println("Choice :");

        int selection = menuInput.nextInt();

        switch (selection) {
            case 1 -> {
                System.out.println("Current Account Balance:" + moneyFormat.format(getCurrentBalance()));
                getAccountType();
            }
            case 2 -> {
                getCurrentWithdrawInput();
                getAccountType();
            }
            case 3 -> {
                getCurrentDepositInput();
                getAccountType();
            }
            case 4 -> System.out.println("Thanks for using our ATM , Bye ");
            default -> System.out.println("\nInvalid Choice\n");
        }
    }
    public void getSaving()
    {
        System.out.println("Savings Account....");
        System.out.println("Press 1 -- Balance Enquiry");
        System.out.println("Press 2 -- Withdraw Money");
        System.out.println("Press 3 -- Deposit Money");
        System.out.println("Press 4 -- Exit");
        System.out.println("Choice :");

        int selection = menuInput.nextInt();

        switch (selection) {
            case 1 -> {
                System.out.println("Saving Account Balance:" + moneyFormat.format(getSavingBalance()));
                getAccountType();
            }
            case 2 -> {
                getSavingWithdrawInput();
                getAccountType();
            }
            case 3 -> {
                getSavingDepositInput();
                getAccountType();
            }
            case 4 -> System.out.println("Thanks for using our ATM , Bye ");
            default -> System.out.println("\nInvalid Choice\n");
        }
    }

}