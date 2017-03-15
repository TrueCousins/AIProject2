import java.util.Comparator;

public class CSPCompare implements Comparator<Node>{
	
	@Override
	  public int compare(Node a, Node b) {
	    Integer a2 = new Integer(a.getMaxvals());
	    Integer b2 = new Integer(b.getMaxvals());
	    return a2.compareTo(b2);
	  } //end compare

}
