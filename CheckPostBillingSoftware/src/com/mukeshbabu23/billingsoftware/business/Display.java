package com.mukeshbabu23.billingsoftware.business;

import java.util.InputMismatchException;
import java.util.Scanner;
public class Display {
	static Scanner scan=new Scanner(System.in);
	Support spt =new Support();
	public void display() {
		Shop shop = new Shop();
		System.out.println("Welcome Boss!");
		shop.defaultIterms();//initial the Iterms
		try {
			while(true) {
				System.out.println(spt.linePrinter(26)+"\n"+spt.spacePrinter(8)+"Dashboard\n"+spt.linePrinter(26));
				System.out.print("1.Billing\n2.Menu\n3.Settings\n4.Exist\n>>> ");
				int option=scan.nextInt();
				switch (option) {
				case 1:
					shop.calculateBill();
					break;
				case 2:
					shop.display();
					break;
				case 3:
					shop.menuOperation();
					break;
				case 4:
					System.exit(0);
					break;
				default:
					System.out.println("Invalid Option");
					break;
				}
			}
		}catch (InputMismatchException e) {
			System.out.println("Use Numeric values\nEx:1,2,etc,.");
			System.out.println("--- Restart the Program ---");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			System.exit(0);
		}

	}
}
