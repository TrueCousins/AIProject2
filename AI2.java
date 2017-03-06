/*****************************************************
CS 4365.001
Colleen Cousins
Matthew Villarreal
******************************************************/
import java.util.*;
import java.io.*;

public class AI2 {
  public static void main(String[] args) {

      Boolean fc = false;

      File varF = new File(args[0]);
      File conF = new File(args[1]);

      Scanner vScan = null;
      Scanner cScan = null;
      Map<String, List<Integer>> vList = new HashMap<String, List<Integer>>();
      
      try { //var file parsing
    	  vScan = new Scanner(varF);
    	  
    	  //String[] parts = list.split(":");
          while(vScan.hasNext())
          {
        	  String key = vScan.next();
        	  List<Integer> tempList = new ArrayList<Integer>();
        	  //System.out.println("KEY: " + key);
        	  
        	  
        	  while(vScan.hasNextInt())
        		  tempList.add(vScan.nextInt());
        	    	  
        	  //System.out.println("VALUE: " + tempList);
        	  vList.put(key.substring(0, 1), tempList);
          }  
          
          // Check map
          for (Map.Entry entry : vList.entrySet()) {
        	    System.out.println(entry.getKey() + ", " + entry.getValue());
        	}

          vScan.close();
      } //end try
      catch(FileNotFoundException e) {
        e.printStackTrace();
      } //end catch

      try { //con file parsing

      } //end try
      catch(FileNotFoundException f) {
        f.printStackTrace();
      } //end catch


      if(args[2].equals("fc"))
        fc = true;

  } //end main
} //end class AI2
