package com.test.java;

public class Test2 {
	
	public static void main(String[] args) {
		//String str = "0,99990101,5,10,10;0,99990101,20,40,10;0,99990101,40,51,0";
		//String arr[] = str.split(";");
		//System.out.println(arr.length);
		//String crr[] = arr[0].split(",");
		//crr = arr[i].split(",");
		//String brr[][] = new String[arr.length][2];
		/*		
		for(int i=0; i<arr.length; i++){
			crr = arr[i].split(",");
			for(int j=0; j<crr.length ; j++){
				brr[i][j] = crr[j];
			}
		}
		
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<crr.length ; j++){
				System.out.println(brr[i][j]);
			}
		}*/
		
		//String str = "0,99990101,5,10,10;0,99990101,20,40,10;0,99990101,40,51,0";
		String str = "0,99990101,5,20,10;"
				+ "0,99990101,20,40,10;"
				+ "0,99990101,90,120,0;"				
				+ "0,99990101,60,40,0;"
				+ "0,99990101,40,60,0;"
				+ "0,99990101,120,151,0";
		String arr[] = str.split(";");
		int brr[][] = new int[arr.length][2];
		
		for(int i=0; i<arr.length; i++){
			String crr[] = arr[i].split(",");
		    brr[i][0] = Integer.valueOf( crr[2] );
			brr[i][1] = Integer.valueOf( crr[3] );	
		}
		/*
		for(int i=0; i<arr.length; i++){
			for(int j=0; j< 2 ; j++){
				System.out.print(brr[i][j] + "   ");				
			}	
		}
		*/
		int x[] = new int[arr.length * 2];
		int y = 0;
		int z = 0;
		for(int i=0; i<arr.length; i++){
			for(int j=i; j<arr.length; j++){
				
				x[2*i] = brr[i][0];
				x[2*i+1]= brr[i][1];
				
				if(brr[i][0] > brr[j][0]){
					y = brr[i][0];
					z = brr[i][1];
					brr[i][0] = brr[j][0];
					brr[i][1] = brr[j][1];	
					brr[j][0] = y;
					brr[j][1] = z;
					x[2*i] = brr[i][0];
					x[2*i+1]= brr[i][1];
				}				
			}
			//System.out.println();
			//System.out.print(x[2*i] + " " +brr[5][0]);

		}
		/*System.out.println();
		for(int i=0; i<x.length; i++){
              System.out.print(x[i] + "   ");
              if(i%2 == 1){
            	  System.out.print("|");
              }
		}*/
		//System.out.println("|");
		for(int i=1; i<(x.length/2); i++){
			if(x[2*i] > x[2*i+1]){
				System.out.println("您设置的区间结束值不能大于开始值，例如"+ x[2*i] +"~"+ x[2*i+1] +"这种情况");
				break;
			}			
			if(x[2*i-1] < x[2*i]){
				System.out.println("您设置的区间之间互相包含，例如"+ x[2*i-2] +"~"+ x[2*i-1] +"，"+ x[2*i] +"~"+ x[2*i+1] +"这种情况");
				break;
			}else if(x[2*i-1] > x[2*i]){
				System.out.println("您设置的区间之间互相包含，例如"+ x[2*i-2] +"~"+ x[2*i-1] +"，"+ x[2*i] +"~"+ x[2*i+1] +"这种情况");
				break;
			}
			//System.out.println(i);
		}
		
	}

}
