package com.mukeshbabu23.billingsoftware.business;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Shop extends Database{
	Scanner scan=new Scanner(System.in);
	Support spt =new Support();

	public void defaultIterms() {
		//Iterm 1
		Menu.add("Black Coffee");
		Price.add(20);

		//Iterm 2
		Menu.add("Black Tea");
		Price.add(20);

		//Iterm 3
		Menu.add("Normal Coffee");
		Price.add(30);

		//Iterm 4
		Menu.add("Normal Tea");
		Price.add(30);
	}

	public void addIterm(){
		System.err.println("Use underscore(_) for Space.");
		System.out.print("Iterm Name : ");
		String iterm=scan.next();
		Menu.add(iterm.replace("_", " "));
		System.out.print("Price : ");
		int price=scan.nextInt();
		Price.add(price);
		System.out.println("*** Successfully Addeded ***");
	}

	public void display() {
		System.out.println(spt.linePrinter(26)+"\n"+spt.spacePrinter(11)+"Menu\n"+spt.linePrinter(26));
		if(Menu.isEmpty()) {
			System.out.println(spt.spacePrinter(7)+"--- Empty ---");			
		}else {
			for (int i=0;i<Menu.size();i++) {
				System.out.println((i+1)+"."+spt.format1(Menu.get(i),15)+"₹"+Price.get(i));
			}
		}
	}

	public void removeIterm() {
		System.out.println(spt.linePrinter(26)+"\n"+spt.spacePrinter(10)+"Delete\n"+spt.linePrinter(26));
		if(Menu.isEmpty()) {
			System.out.println(spt.spacePrinter(3)+"--- Menu is Empty ---");
		}else {
			System.out.print("Iterm No: ");
			int iterm=scan.nextInt();
			Menu.remove(iterm-1);
			Price.remove(iterm-1);
			System.out.println("*** Successfully Deleted ***");
		}
	}

	public void menuOperation() {
		boolean ctrl=true;
		try {
			while(ctrl) {
				System.out.println(spt.linePrinter(26)+"\n"+spt.spacePrinter(7)+"Menu Settings\n"+spt.linePrinter(26));
				System.out.print("1.Add Iterm\n2.Display Menu\n3.Delete Iterm\n4.Exist\n>>> ");
				int option=scan.nextInt();
				switch (option) {
				case 1:
					addIterm();
					break;
				case 2:
					display();
					break;
				case 3:
					removeIterm();
					break;
				case 4:
					ctrl=false;
					break;
				default:
					System.out.println("Invalid Option");
					break;
				}
			}
		}catch (InputMismatchException e) {
			// TODO: handle exception
			System.out.println("Use Numeric values\nEx:1,2,etc,.");
			System.err.println("--- Restart the Program ---");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}



	public void calculateBill() {
		boolean ctrl=true;
		System.out.println(spt.linePrinter(26)+"\n"+spt.spacePrinter(6)+"Bill Dashboard\n"+spt.linePrinter(26));
		while(ctrl) {
			System.out.print("1.Add Iterms\n2.Display Total\n3.Total Sales\n4.Exist\n>>> ");
			int option=scan.nextInt();
			switch (option) {
			case 1:
				getIterms();
				break;
			case 2:
				getTotal();
				break;
			case 3:
				getTotalSales();
				break;
			case 4:
				ctrl=false;
				break;
			default:
				break;
			}
		}
	}

	public void getTotalSales() {
		System.out.println(spt.linePrinter(36)+"\n"+spt.spacePrinter(12)+"Sales Report"+"\n"+spt.linePrinter(36));
		if(CustomerName.isEmpty()) {
			System.out.println(spt.spacePrinter(10)+"--- No Sales ---");			
		}else {
			System.out.println("Customer Name"+spt.spacePrinter(12)+"Bill Amount"+"\n"+spt.linePrinter(36));
			for (int i=0;i<CustomerName.size();i++) {
				System.out.println((i+1)+"."+spt.format1(CustomerName.get(i), 20)+spt.spacePrinter(10)+"₹"+BillAmount.get(i));
			}
			System.out.println(spt.linePrinter(36)+"\nTotal Income : ₹"+calcIncome());
			
		}
		System.out.println(spt.linePrinter(36));
	}

	public int calcTotal() {
		int total=0;
		for (int i = 0; i < temptotal.size(); i++) {
			total=total+temptotal.get(i);
		}
		return total;
	}
	public int calcIncome() {
		int total=0;
		for (int i = 0; i < BillAmount.size(); i++) {
			total=total+BillAmount.get(i);
		}
		return total;
	}

	public void getTotal() {
		System.out.println(spt.linePrinter(36)+"\n"+spt.spacePrinter(15)+"Bill\n"+spt.linePrinter(36));
		if(!tempList.isEmpty()) {
			System.out.print("Customer Name : ");
			CustomerName.add(scan.next());
			System.out.println(spt.linePrinter(36)+"\nName           QTY          Price(₹)\n"+spt.linePrinter(36));
			for (int i = 0; i < tempList.size(); i++) {
				System.out.println(spt.format1(tempList.get(i),16)+tempQty.get(i)+spt.spacePrinter(12)+"₹"+temptotal.get(i));
			}
			System.out.println(spt.linePrinter(36)+"\n"+spt.spacePrinter(22)+"Total: ₹"+calcTotal()+"\n"+spt.linePrinter(36));
			BillAmount.add(calcTotal());
			tempList.clear();
			tempQty.clear();
			temptotal.clear();
		}else {
			System.out.println(spt.spacePrinter(7)+"--- Iterm is Empty ---\n"+spt.linePrinter(36));
		}
	}

	public void getIterms() {
		System.out.println(spt.linePrinter(36)+"\n"+spt.spacePrinter(15)+"Iterms"+"\n"+spt.linePrinter(36));
		System.out.print("Enter the Menu Iterm Number : ");
		int min=scan.nextInt();
		System.out.print("Enter the Iterm Quantity : ");
		int iq=scan.nextInt();
		System.out.println(spt.linePrinter(36));
		tempList.add(Menu.get(min-1));
		tempQty.add(iq);
		temptotal.add((Price.get(min-1))*iq);
	}
}
