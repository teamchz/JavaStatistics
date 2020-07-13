package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //price = double , vat = double
        UserProfileUI ui = new UserProfileUI();


        Scanner scanner = new Scanner(System.in);

        float price = scanner.nextFloat();
        float vat = 7/100.0f;
        float total = price+(vat*price);
        float totalvat = price*vat;

        System.out.print("Vat = ");
        System.out.println(totalvat);
        System.out.print("Total Price = ");
        System.out.println(total);
        System.out.println("Thanks");
    }
}
