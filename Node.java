/*****************************************************
CS 4365.001
Colleen Cousins
Matthew Villarreal
******************************************************/
import java.util.*;
public class Node {

  public Map<String, List<Integer>> vars = new HashMap<String, List<Integer>>();
  public List<Integer> assignment = new ArrayList<Integer>();
  int maxvals = -1;

  public Node(Map<String, List<Integer>> original) { //constructor
    for(Map.Entry<String, List<Integer>> orig : original.entrySet()) //copy map
      this.vars.put(orig.getKey(), new ArrayList<Integer>(orig.getValue()));

  } //end Node(2)

  public Node(Node other) {
    for(Map.Entry<String, List<Integer>> orig : other.vars.entrySet()) //copy map
      this.vars.put(orig.getKey(), new ArrayList<Integer>(orig.getValue()));

    this.assignment = new ArrayList<Integer>(other.assignment);
  } //end Node(1)

  public Node(Node parent, String key, int val) {
    for(Map.Entry<String, List<Integer>> entry : parent.vars.entrySet()) {
      String check = entry.getKey();
      if(key.equals(check))
        this.vars.put(entry.getKey(), new ArrayList<Integer>(val));
      else
        this.vars.put(entry.getKey(), new ArrayList<Integer>(entry.getValue()));
    } //end for
    int k = (int)key.charAt(0);
    assignment.add(k);
    assignment.add(val);
  } //end Node(3)

  List<String> pastVariables = new ArrayList<>();
  public char varHuer(List<char[]> constraint) {
    int maxSize = -1;
    int mostCon1 = 0;
    int mostCon2 = 0;
    char constVar = 'z';
    char constVar2 = 'z';
    char returnVar = 'z';
    
    
    int mrv = 1000;
    char returnChar = 'z';
   Map<String, Integer> remainingVariables = new HashMap<String, Integer>();
    
    //**********************************************************
    //				FIND MAX SET 							   *
    //**********************************************************
    for(Map.Entry<String, List<Integer>> entry : vars.entrySet()) {
        List<Integer> v = entry.getValue();
        if(v.size() > maxSize) {
          maxSize = v.size();
          //constVar = entry.getKey().charAt(0);
        } //end if
        if(v.size() == maxSize)
        	remainingVariables.put(entry.getKey(),0);
    }
    
    System.out.println("Max Length is :" + maxSize);
    
    //**********************************************************
    //				MOST CONSTRAINED VARIABLE				   *
    //**********************************************************
    for(Map.Entry<String, List<Integer>> entry : vars.entrySet())
    {
    	List<Integer> varList = entry.getValue();
    	//System.out.println("Var: " + entry.getKey() + " size: " + varList.size());
    
		if(varList.size() < mrv && !pastVariables.contains(Character.toString(constVar)))
    	{
    		mrv = varList.size();
    		constVar = entry.getKey().charAt(0);
    		System.out.println("Current Variable is: " + constVar);    		
    	}

    }
    if(mrv < maxSize)
    {
    	 pastVariables.add(Character.toString(constVar));
    	 System.out.println("Returning Variable: " + constVar);
    	 return constVar;
    }
    //**********************************************************
    //				MOST CONSTRAINING VARIABLE				   *
    //**********************************************************
    
    	//List<Integer> varList = entry.getValue();
    	//System.out.println("Var: " + entry.getKey() + " size: " + varList.size());
    int max = 0;
	if(mrv == maxSize)
	{
        //constVar2 = entry.getKey().charAt(0);
		for(Map.Entry<String, Integer> entry : remainingVariables.entrySet())
		{
			for(char c[]: constraint)
			{
				if(constraint.contains(entry.getKey()))
					remainingVariables.put(entry.getKey(), entry.getValue() + 1);
			}
			
			if(entry.getValue() > max)
			{
				max = entry.getValue();
				constVar = entry.getKey().charAt(0);
				
			}
		}
		    
	}
	pastVariables.add(Character.toString(constVar));
    System.out.println("Returning Variable: " + constVar);
    return constVar;
    
    /*
    for(Map.Entry<String, List<Integer>> entry : vars.entrySet()) {
      List<Integer> v = entry.getValue();
      if(v.size() > maxSize) {
        maxSize = v.size();
        constVar = entry.getKey().charAt(0);
      } //end if
      if(v.size() == maxSize) {

        constVar2 = entry.getKey().charAt(0);

        for(char c[] : constraint) {
          for(int i = 0; i < c.length; i++) {
            if(c[i] == constVar)
              mostCon1++;
            if(c[i] == constVar2)
              mostCon2++;
          } //end nested for
        } //end nested for
        if(mostCon2 > mostCon1)
          returnVar = constVar2;
        else
          returnVar = constVar;
      } //end if
    } //end for
    return returnVar;*/
  } //end varHuer


   public boolean constrCheck(List<char[]> constraints) { //do this now
	  boolean flag = false;
	 
	  for(int i = 0; i < constraints.size(); i++) {
          char[] got = constraints.get(i);
          if(got[1] == '<' && got[0] < got[2])
        	  flag = true;
          else if(got[1] == '>' && got[0] > got[2])
        	  flag = true;
          else if(got[1] == '=' && got[0] == got[2])
        	  flag = true;
          else if(got[1] == '!' && got[0] != got[2])
        	  flag = true;
          else
        	  flag = false;
        	  
        	  
          //System.out.println(got[0] + " " + got[1] + " " + got[2]);
        } //end for
    return flag;
  } //end constrCheck

  public void printAssignment() {
    for (int i = 0; i < assignment.size(); i++) {
      int var = assignment.get(i);
      System.out.print((char)var);
      i++;
      System.out.print(" : " + assignment.get(i) + ", ");
    } //end for
    System.out.println();
  } //end printAssignment














} //end Node
