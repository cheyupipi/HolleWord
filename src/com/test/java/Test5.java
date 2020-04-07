package com.test.java;

import java.math.BigDecimal;

public class Test5 {
	public static void main(String[] args) {
			
					String str = "0,99990101,5,20,10;"
							+ "0,99990101,20,40,10;"
							+ "0,99990101,90,120,0;"
							+ "0,99990101,1,4,0;"
							+ "0,99990101,60,40,0;"
							+ "0,99990101,40,60,0;"
							+ "0,99990101,120,151,0";
					/*将金额区间按 ; 号组成一维数组*/
					String arr[] = str.split(";");
					/*将一维数据金额区间，按 , 号 改为二维数组*/
					Double brr[][] = new Double[arr.length][2];		
					for(int i=0; i<arr.length; i++){
						String crr[] = arr[i].split(",");
					    brr[i][0] = Double.valueOf( crr[2] );
						brr[i][1] = Double.valueOf( crr[3] );	
					}
					/*将二维数组改成排序的 一维数组*/
					Double x[] = new Double[arr.length * 2];
					/*存储金额区间 开始值*/
					Double y = 0.0;
					/*存储金额区间 结束值*/
					Double z = 0.0;
					/*二维数组按 金额区间的 开始值排序*/
					
					for(int i=0; i<arr.length; i++){
						for(int j=0; j<arr.length; j++){
							if(brr[i][0] >= brr[i][1]){
								System.out.println("区间开始值大于等于区间结束值");
								//break;
							}
							//第一遍遍历，我已经可以选出区间的开始值最小，与区间的结束值最大，并记录，
							//除开这两个数，其它开始值，必有一个结束值，其它结束值，必有一个开始值
							//选出开始值
							if(i==0 && j==0){
								y = brr[j][0];
							}
							if(y>=brr[j][0]){
								y = brr[j][0];
							}	
							//选出结束值
							if(z<=brr[j][1]){
								z = brr[j][1];
							}
							/*if(brr[i][0] == brr[j][1]){
								a = a + 1;
								System.out.println("``");
							}*/
											
						}
						//System.out.println(i + " " + y + " " + z);
					}
					//System.out.println(y + " " + z);
					//System.out.println(a);
					
					int a = 0;
					int b = 0;
					for(int i=0; i<arr.length; i++){
						a = 0;
						b = 0;
						for(int j=0; j<arr.length; j++){
							System.out.println(brr[i][0] +"****"+ brr[j][1]);
							System.out.println(brr[i][1] +"****"+ brr[j][0]);
							if(brr[i][0] >= brr[i][1]){
								System.out.println("区间开始值大于等于区间结束值");
								break;
							}
							if(Double.doubleToLongBits(brr[i][0]) == Double.doubleToLongBits(brr[j][1])){
							//if((new BigDecimal(brr[i][0])).compareTo(new BigDecimal(brr[j][1]))==0.0){
								a = a + 1;
							}
							if(Double.doubleToLongBits(brr[i][0]) == Double.doubleToLongBits( y )){
								a = 1;
							}
							if(Double.doubleToLongBits(brr[i][1]) == Double.doubleToLongBits(brr[j][0])){
							//if((new BigDecimal(brr[i][1])).compareTo(new BigDecimal(brr[j][0]))==0.0){
								b = b + 1;
							}
                            if(Double.doubleToLongBits(brr[i][1]) == Double.doubleToLongBits( z )){
                            	b = 1;
							}
						}
						System.err.println("---------------------------------------");
						if(a != 1 || b != 1){
							System.out.println(a+"  "+b+"失败");
						}
					}

					System.out.println(a);
					
					/*
					 x[2*i] = brr[i][0];
							x[2*i+1]= brr[i][1];
							比较选出最小的开始值，排在  一维金额排序数组   的最前面，依次从小到大
							if(brr[i][0] > brr[j][0]){
								y = brr[i][0];
								z = brr[i][1];
								brr[i][0] = brr[j][0];
								brr[i][1] = brr[j][1];	
								brr[j][0] = y;
								brr[j][1] = z;
								x[2*i] = brr[i][0];
								x[2*i+1]= brr[i][1];
								} */
					/*将排序后的一维金额数组    用排列的方式判断是否开始值、结束值区间有问题,   区间大于等于2
					for(int i=1; i<(x.length/2); i++){
						if(x[2*i] >= x[2*i+1]){
							rs.setErrorMessage("您设置的区间结束值不能小于等于开始值，例如【"+ x[2*i] +"~"+ x[2*i+1] +"】这种情况");
							return true;
						}			
						if(x[2*i-1] < x[2*i]){
							//rs.setErrorMessage("您设置的区间之间没有闭合，例如"+ x[2*i-2] +"~"+ x[2*i-1] +"，"+ x[2*i] +"~"+ x[2*i+1] +"这种情况");
							rs.setErrorMessage("您设置的区间之间没有闭合，缺少区间【"+ x[2*i-1] +"~"+ x[2*i] +"】这种情况");
							return true;
						}else if(x[2*i-1] > x[2*i]){
							//rs.setErrorMessage("您设置的区间之间互相包含，例如"+ x[2*i-2] +"~"+ x[2*i-1] +"，"+ x[2*i] +"~"+ x[2*i+1] +"这种情况");
							rs.setErrorMessage("您设置的区间之间互相包含，例如【"+ x[2*i-2] +"~"+ x[2*i-1] +"】和【"+ x[2*i] +"~"+ x[2*i+1] +"】相互包含");
							return true;
						}
					}	
					只有一个区间，只校验结束值是否大于等于开始值
					if( x.length == 2 && x[0] >= x[1]){
						rs.setErrorMessage("您设置的区间结束值不能小于等于开始值，例如【"+ x[0] +"~"+ x[1] +"】这种情况");
						return true;		
					}
*/

	}

}
