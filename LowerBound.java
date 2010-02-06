import java.util.*;
import java.io.*;

public class LowerBound{

   static protected File inFile; 

public static void main(String[] args){

	char[] inChar;
	try{
	inFile = new File(args[0]);
	inChar = getCharacters();
        double entropy = entropy(inChar);
        double lowerBound = entropy * inChar.length;

        Formatter fmt = new Formatter();
        fmt.format("%.3f", lowerBound);
        System.out.print("The lower bound is " + fmt);

        fmt = new Formatter();
        fmt.format("%.3f", entropy);
        System.out.print("; the entropy is " + fmt + "\n");
	}

	catch(Exception e){
	System.err.println("exception thrown: " + e.getMessage() );
	}

}

public static double log2(double n){
	return (Math.log(n)/Math.log(2));
}

public static double entropy(char[] inChar){
       HashMap map = new HashMap(); 
       int length = inChar.length;
       for(int i=0; i<length; ++i){
            if( map.get(inChar[i] ) == null) {
	      map.put(inChar[i], new Integer(1));
	    }
	    else{
	    Integer val = (Integer)map.get(inChar[i]);
	    map.put(inChar[i], new Integer(val + 1));
	    }
       }

       Integer temp;
       double entropy = 0.0;
       int tmpint;
       double probability;

       for ( Iterator iter = map.keySet().iterator(); iter.hasNext(); )
       {
           temp = (Integer)map.get( iter.next() );
	   tmpint = temp.intValue();
           probability = (double)tmpint / (double)length;
           entropy -= probability * log2(probability);
       }

 return entropy;
}
	
		public static char[] getCharacters() throws Exception {
			char[] ret = new char[(int) (inFile.length()+1)];
			int retCursor = 0; 
			FileInputStream from = new FileInputStream(inFile); 
			
			while (true) {
				byte nextByte = (byte) from.read(); 
				if (nextByte == -1) 
					break;
				
				char nextChar = (char) nextByte; 
				ret[retCursor++] = nextChar; 
			}
			
			ret[(int)(inFile.length())] = '\000';
			return ret;
			}
	
} // end LowerBound class
