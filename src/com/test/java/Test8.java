package com.test.java;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Test8 {
	public static void main(String[] args) {
		String tradeDate =  "20190815";
		String expirydate = "20190801";
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd"); 
		LocalDate dtEnd = LocalDate.parse(tradeDate,dtf);   
		
        LocalDate dtBegin = LocalDate.parse(expirydate,dtf);
        
        int daysBetween = Math.abs((int) (dtEnd.toEpochDay() - dtBegin.toEpochDay()));
        System.out.println(daysBetween);
        
        String str = "-17.20";
        //String reg = "^[-\\+]?([0-9]+\\.?)?[0-9]+$"; 三位正负数 保留两位小数
        String reg = "^[-\\+]?(([1-9]{1}\\d{2})|([1-9]{1}\\d{1})|(0{1}))(\\.\\d{0,2})?$";
        System.out.println(str.matches(reg));
        
        String xxx = ".{0}|((^(([1-9]{1}\\d{0,1})|(0{1}))(\\.\\d{0,2})?$)|(100.00)|(100))";
        System.out.println(str.matches(xxx));

	}

}
