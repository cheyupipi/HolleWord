package com.test.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test11 {
	
	public static void main(String[] args) {
		List<Map<String, Object>> financialLs = new ArrayList<>();
  		Map<String, Object> mapss = new HashMap<>();
  		mapss.put("enddate", "20190623");
  		financialLs.add(mapss);
  		Map<String, Object> mapParam = new HashMap<>();
  		mapParam.put("enddate", "20191017");
  		mapParam.put("xxx", "yyy");
  		financialLs.add(mapParam);
		int enddate = 0;
    	int y = 0;      
    	System.out.println(financialLs);
        for (int i = 0; i < financialLs.size(); i++) {
        	Map<String, Object> financialMap = financialLs.get(i);
            if( Integer.parseInt( financialMap.get("enddate").toString() ) > enddate ){
            	enddate = Integer.parseInt( financialMap.get("enddate").toString() );
            	y = i;
            }
        }
        financialLs.get(y).put("xxx", "xxx");
        System.out.println(financialLs);
        System.out.println(y);
        System.out.println(enddate);
	}

}
