package com.test.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test10 {
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
  		mapParam.put("enddate", "20191017");
  		mapParam.put("publicdate", "20190108");
  		for(Map<String, Object> map : reporttypeList){
      		 String endYear = String.valueOf( map.get("enddate") ).substring(0, 4);
      		 String newEndYear = String.valueOf( mapParam.get("enddate") ).substring(0, 4); 
      		 
      		 int endMonth = Integer.parseInt( String.valueOf( map.get("enddate") ).substring(4, 6) );
      		 int newEndMonth = Integer.parseInt( String.valueOf( mapParam.get("enddate") ).substring(4, 6) );
      		 
      		 int beginMonth = Integer.parseInt( String.valueOf( map.get("publicdate") ).substring(4, 6) );
      		 int newBeginMonth = Integer.parseInt( String.valueOf( mapParam.get("publicdate") ).substring(4, 6) );
      		 System.out.println(endYear + "------" + newEndYear);
      		 if(endYear.equals( newEndYear )){
      			 System.out.println("y--------------");
      			 if( (1<= newBeginMonth && newEndMonth <= 6 && newBeginMonth < newEndMonth ) ||
      			     (7<= newBeginMonth && newEndMonth <= 12 && newBeginMonth < newEndMonth ) ){
      				 System.out.println("m--------");
      				 if( (endMonth <= 6 && newEndMonth <= 6) ||
      					 (7<= endMonth && 7<= newEndMonth && endMonth <= 12 && newEndMonth <= 12) ){
      					 System.out.println("已有相同月份类的半年报");
                        return;
      				 }	               				 	               				 
      			 }else{	               				 
      				System.out.println("半年报只能1月到6月之间，或7月到12月之间");
                    return;
      			 }
      		 }
      	 }
  		
  		
  		
	}

}
