package com.kh.example.abstractNInterface;

public class PhoneController {
	 String[] result = new String[2];
	 public String[] method() {
		 Phone[] p = new Phone[2];
		 p[0] = new GalaxyNote9();
		 p[1] = new V40();
		 int idx = 0;
		 String[] result = new String[p.length];
		 for(Phone ph : p) {
			 if(ph != null) {
				 if(ph instanceof SmartPhone) {
					 result[idx++] = ((SmartPhone)ph).printInformation(); 
				 } 
			 }
		 }
		 return result;
	 }
}
