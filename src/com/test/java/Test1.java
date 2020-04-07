package com.test.java;

import java.math.BigDecimal;

public class Test1 {
	public static void main(String[] args) {
		int s = 5;
		int a = 2;
		System.out.println(Math.ceil(2.5));
		
		String x = "12.0,12.3;13.0,13.2;13.0,13.2;13.0,13.2;13.0,13.2;13.0,13.2";
		String arr[] = x.split(";");
		for(String y : arr){
			System.out.print( y +"  ");
		}
		
		Double brr[][] = new Double[arr.length][2];		
		for(int i=0; i<arr.length; i++){
			String crr[] = arr[i].split(",");
		    brr[i][0] = Double.valueOf( crr[0] );
			brr[i][1] = Double.valueOf( crr[1] );	
		}
		
		for(int i=0; i<brr.length; i++){
			for(Double z : brr[i]){				
				System.out.println( z );
			}
		}
		//BigDecimal ss[] = new BigDecimal[2];
		
		
	}

}
