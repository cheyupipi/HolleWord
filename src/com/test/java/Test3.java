package com.test.java;


public class Test3 {
	
	public static void main(String[] args) {
		
			
		String valuerangeAll = "0,99990101,5,20,10;"
				+ "0,99990101,20,40,10;"
				+ "0,99990101,1,5,10;"
				+ "0,99990101,90,120,0;"				
				+ "0,99990101,60,40,0;"
				+ "0,99990101,40,60,0;"
				+ "0,99990101,120,151,0";
		
		//String valuerangeAll = "0,99990101,1,1,1";
		/*将金额区间按 ; 号组成一维数组*/
		String arr[] = valuerangeAll.split(";");
		/*将一维数据金额区间，按 ; 号 改为二维数组*/
		int brr[][] = new int[arr.length][2];		
		for(int i=0; i<arr.length; i++){
			String crr[] = arr[i].split(",");
		    brr[i][0] = Integer.valueOf( crr[2] );
			brr[i][1] = Integer.valueOf( crr[3] );	
		}
		/*将二维数组改成排序的 一维数组*/
		int x[] = new int[arr.length * 2];
		/*存储金额区间 开始值*/
		int y = 0;
		/*存储金额区间 结束值*/
		int z = 0;
		/*二维数组按 金额区间的 开始值排序*/
		for(int i=1; i<arr.length; i++){
			int p = brr[i][0];
			int q = brr[i][1];
			if(i==1){
				x[0] = brr[0][0];
				x[1]= brr[0][1];
			}			
			int j = 0;
			for(j=i; j>0 && brr[j-1][0] > p; j--){
				brr[j][0] = brr[j-1][0];
				brr[j][1] = brr[j-1][1];
				x[2*j] = brr[j-1][0];
				x[2*j+1]= brr[j-1][1];
			}
			brr[j][0] = p;
			brr[j][1] = q;
			x[2*j] = p;
			x[2*j+1]= q;
		}
		/*for(int i=0; i<arr.length; i++){
			for(int j=i; j<arr.length; j++){
				
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
				}				
			}
		}*/
		/*将排序后的一维金额数组    用排列的方式判断是否开始值、结束值区间有问题*/
		/*for(int i=1; i<(x.length/2); i++){
			if(x[2*i] >= x[2*i+1]){
				System.out.println("您设置的区间结束值不能小于等于开始值，例如【"+ x[2*i] +"~"+ x[2*i+1] +"】这种情况");

			}			
			if(x[2*i-1] < x[2*i]){
				//rs.setErrorMessage("您设置的区间之间没有闭合，例如"+ x[2*i-2] +"~"+ x[2*i-1] +"，"+ x[2*i] +"~"+ x[2*i+1] +"这种情况");
				System.out.println("您设置的区间之间没有闭合，缺少区间【"+ x[2*i-1] +"~"+ x[2*i] +"】这种情况");

			}else if(x[2*i-1] > x[2*i]){
				//rs.setErrorMessage("您设置的区间之间互相包含，例如"+ x[2*i-2] +"~"+ x[2*i-1] +"，"+ x[2*i] +"~"+ x[2*i+1] +"这种情况");
				System.out.println("您设置的区间之间互相包含，例如【"+ x[2*i-2] +"~"+ x[2*i-1] +"】和【"+ x[2*i] +"~"+ x[2*i+1] +"】相互包含");
			}
		}*/
		
		for(int s:x){
			System.out.print(s +"  ");
		}
		System.out.println(x.length);
		for(int i=0; i<(x.length/2); i++){
			if(x[2*i] >= x[2*i+1]){
				System.out.println("您设置的区间结束值不能小于等于开始值，例如【"+ x[2*i] +"~"+ x[2*i+1] +"】这种情况");

			}		
			if(x.length >= 4){
				System.out.println(i);
				if(x[2*i-1] < x[2*i]){
					//rs.setErrorMessage("您设置的区间之间没有闭合，例如"+ x[2*i-2] +"~"+ x[2*i-1] +"，"+ x[2*i] +"~"+ x[2*i+1] +"这种情况");
					System.out.println("您设置的区间之间没有闭合，缺少区间【"+ x[2*i-1] +"~"+ x[2*i] +"】这种情况");
	
				}else if(x[2*i-1] > x[2*i]){
					//rs.setErrorMessage("您设置的区间之间互相包含，例如"+ x[2*i-2] +"~"+ x[2*i-1] +"，"+ x[2*i] +"~"+ x[2*i+1] +"这种情况");
					System.out.println("您设置的区间之间互相包含，例如【"+ x[2*i-2] +"~"+ x[2*i-1] +"】和【"+ x[2*i] +"~"+ x[2*i+1] +"】相互包含");
				}
			}
		}
	}

}
