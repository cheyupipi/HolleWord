package com.test.java;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Test9 {
	public static void main(String[] args) {
		List<Integer> a = new ArrayList<Integer>();
		List<Integer> b = new ArrayList<Integer>();
		a.add(1);
		a.add(2);
		b.add(3);
		b.add(4);
		a.addAll(b);
		System.out.println(a);
		
		String str = "20191125";
        //String reg = "^[-\\+]?([0-9]+\\.?)?[0-9]+$"; 三位正负数 保留两位小数
        String reg = "[1-2]{1}[0,9]{1}[0-9]{2}[0-1][0-9][0-3][0-9]";
        System.out.println(str.matches(reg));
        
        String xxx = ".{0}|((^(([1-9]{1}\\d{0,1})|(0{1}))(\\.\\d{0,2})?$)|(100.00)|(100))";
        System.out.println(str.matches(xxx));
        
        String xx = "20190105".substring(0, 4);
        String y = String.valueOf( (Integer.parseInt(xx) + 1) ) + "20190105".substring(4, 8);
        System.out.println(xx);
        System.out.println(y);
        
        String arr = "";
        String brr = ".{0}|^(?:0|[1-9]\\d{0,2})(?:\\.\\d{1,2})?$";
        System.out.println(arr.matches(brr));
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
        /*当前交易日*/
        LocalDate dtBegin = LocalDate.parse("20200228", dtf);
        String z = dtBegin.plusYears(1).format(dtf);
        System.out.println( z);
        System.out.println("***********************");
		int iMax = 4;
		int iCount = 4;
        if (iMax < iCount){
        	System.out.println("-1") ;
        	System.out.println( "持有该产品的股东人数已经达到最大,不能继续委托.");
        } else if(iMax == 0 || iMax > iCount) { //未作设置,故无需检查
        	System.out.println("0") ;
        	System.out.println("该委托合法!");
        } else if(iCount == iMax && iMax > 0){ //已经到达最大人数，看此委托人是不是在上述人数里
        	int iExist = 2	;
        	if (iExist == 0){
        		System.out.println("-1") ;
        		System.out.println("持有该产品的股东人数已经达到最大,不能继续委托.");
        	} else {
        		System.out.println( "0") ;
        		System.out.println("该委托合法.");
        	}
        }
		
	}

}
