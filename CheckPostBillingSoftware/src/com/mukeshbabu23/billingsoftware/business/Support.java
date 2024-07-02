package com.mukeshbabu23.billingsoftware.business;

public class Support {
	
	public String format1(String str,int n) {
		int count=n-str.length();
		String returnValue=str;
		for(int i=0;i<count;i++) {
			returnValue=returnValue+" ";
		}
		return returnValue;
	}
	
	public String spacePrinter(int n) {
		String space="";
		for (int i = 0; i < n; i++) {
			space=space+" ";
		}
		return space;
	}
	
	public String linePrinter(int n) {
		String space="";
		for (int i = 0; i < n; i++) {
			space=space+"-";
		}
		return space;
	}
}
