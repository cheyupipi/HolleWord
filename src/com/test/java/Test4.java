package com.test.java;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Test4 {
	public static void main(String[] args) {
		String str1 = "Stdf";
		str1 = new StringBuilder(str1).reverse().toString();     //先将字符串颠倒顺序 
		System.out.println(str1);
		
		String expirydate = "20200826";
		LocalDate dtFrom = LocalDate.now();
	    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");	    	    
        LocalDate dtEnd = LocalDate.parse(expirydate,dtf);
        System.out.println(dtEnd);
        System.out.println(dtFrom);
        
        Period between = Period.between(dtFrom, dtEnd);
        int daysBetween = between.getDays();//获取当前 20191031  到  20200826   之间 日期的天数  5
        
        int day = (int) (dtEnd.toEpochDay() - dtFrom.toEpochDay());//获取日期之间的天数
        
        System.out.println(day);
        
        if(Double.doubleToLongBits(0.0000000001) == Double.doubleToLongBits( 0.00 )){
        	System.out.println("yes");
		}
        if(0.0 == 0){
        	System.out.println("yes");
		}
        
        BigDecimal p1 = new BigDecimal(Double.toString( 5.6 ));
        BigDecimal p2 = new BigDecimal(Double.toString( 5.1 ));
        BigDecimal p3 = new BigDecimal(Double.toString( 0.5 ));
        Double countVol = p1.subtract(p2).subtract(p3).doubleValue();
        System.out.println(countVol);
        if(countVol==0){
        	System.out.println("yes");
        }
	}

}
