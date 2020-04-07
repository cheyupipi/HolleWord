package com.test.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test12 {
	public static void main(String[] args) {
		/*String end= "20190124";
		String endMonth = String.valueOf( end ).substring(4, 6);
  		String newEndMonth = String.valueOf( end ).substring(4, 6);
  		System.out.println(endMonth);
  		int s = Integer.parseInt( endMonth );
  		System.out.println(s);*/
  		
  		List<Map<String, Object>> reporttypeList = new ArrayList<>();
  		Map<String, Object> mapss = new HashMap<>();
  		mapss.put("enddate", "20190623");
  		mapss.put("publicdate", "20190102");
  		reporttypeList.add(mapss);
  		//mapss.put("enddate", "");
  		Map<String, Object> mapParam = new HashMap<>();
  		mapParam.put("enddate", "20190917");
  		mapParam.put("publicdate", "20190108");

  		String reporttype = "1";
  		
  		int enddate = Integer.parseInt( String.valueOf( mapParam.get("enddate")) );
		int publicdate = Integer.parseInt( String.valueOf( mapParam.get("publicdate")) );
			
  		int endYear = Integer.parseInt( String.valueOf( mapParam.get("enddate") ).substring(0, 4) ); 
  		int beginYear = Integer.parseInt( String.valueOf( mapParam.get("publicdate") ).substring(0, 4) ); 
  		
 		int endMonth = Integer.parseInt( String.valueOf( mapParam.get("enddate") ).substring(4, 6) );
		int beginMonth = Integer.parseInt( String.valueOf( mapParam.get("publicdate") ).substring(4, 6) );
		
		int endDay = Integer.parseInt( String.valueOf( mapParam.get("enddate") ).substring(6, 8) );
		int beginDay = Integer.parseInt( String.valueOf( mapParam.get("publicdate") ).substring(6, 8) );
		
  		if(endYear != beginYear){
  			System.out.println("财务报表开始日期和结束日期只能是同一年");
  			return;
  		}
  		if(publicdate >= enddate){
  			System.out.println("财务报表开始日期必须小于结束日期");
  			return;
  		}
  		System.out.println("开始");
  		if("0".equals(reporttype)){  			 			
 			if( beginYear != endYear ){
  				System.out.println("新增的年报必须是同年");  				  				
       		 } 
 			/*判断是已有年报是否有相同的年份*/
 			if(reporttypeList != null && !reporttypeList.isEmpty() ){
				for(Map<String, Object> map : reporttypeList){
	           		String oldEndYear = String.valueOf( map.get("enddate") ).substring(0, 4);             		 
	           		if(oldEndYear.equals( endYear )){
	           		    System.out.println("每个年份的年报只允许有一条");
	                    return;
	           		}
           	    }
 			}
  		}else if("1".equals(reporttype)){
			 if( !(1<= beginMonth && endMonth <= 6 ) &&
	  			 !(7<= beginMonth && endMonth <= 12 ) ){
				 System.out.println("半年报只能1月到6月之间，或7月到12月之间");	 
				 return;
			 }
			 System.out.println("1111111111");
			 if(reporttypeList != null && !reporttypeList.isEmpty() ){
					for(Map<String, Object> map : reporttypeList){
						int oldEndYear = Integer.parseInt( String.valueOf( map.get("enddate") ).substring(0, 4) );			       		 
			       		int oldEndMonth = Integer.parseInt( String.valueOf( map.get("enddate") ).substring(4, 6) );			       		 
			       		int oldBeginMonth = Integer. parseInt( String.valueOf( map.get("publicdate") ).substring(4, 6) );  
			       		
			       	    /*相同年份的半年报只能有两条*/
	               		if(oldEndYear == endYear){
	               			if( (oldEndMonth <= 6 && endMonth <= 6) ||
                 				(7<= oldBeginMonth && 7<= beginMonth && oldEndMonth <= 12 && endMonth <= 12) ){	               					
	               				System.out.println("已有相同月份类的半年报");	
	               				return;                          
               				 }
	               		}
	         }
			 
  		}else if("2".equals(reporttype)){
  			if( !(1<= beginMonth && endMonth <= 3 ) &&
     			!(4<= beginMonth && endMonth <= 6 ) &&
     			!(7<= beginMonth && endMonth <= 9 ) &&
     			!(10<= beginMonth && endMonth <= 12 ) ){
  				System.out.println("季报只能1月到3月之间，或4月到6月之间，或7月到9月之间，或10月到12月之间");	
  				return;
  				
  				}
  			} 			
  		}else if("3".equals(reporttype)){
  			if( beginYear != endYear || beginMonth != endMonth ){
  				System.out.println("新增的月报必须同年同月");
  				return;
       		 }
  			 int oldEndYear = Integer.parseInt( String.valueOf( mapss.get("enddate") ).substring(0, 4) ); 
  			 int oldEndMonth = Integer.parseInt( String.valueOf( mapss.get("enddate") ).substring(0, 4) ); 
  			 /*判断有没有同年同月的月报*/
      		 if(endYear == oldEndMonth && endMonth == oldEndMonth ){
      			System.out.println("同年同月的月报只允许有一条");
                return;
      		 }
  		}
  		
  		
	}
	
}
