import java.util.*;
import java.io.*;

public class LowerBound{

   static protected File inFile; 

public static void main(String[] args){

System.out.println(args[0] + " " );
	char[] inChar;
	try{
	inFile = new File(args[0]);
	inChar = getCharacters();
	System.out.print(inChar.length);
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
       for(int i=0; i<inChar.length; ++i){
            if( map.get(inChar[i] ) == null) {
	      map.put(inChar[i], new Integer(1));
	    }
	    else{
	    Integer val = (Integer)map.get(inChar[i]);
	    map.put(inChar[i], new Integer(val + 1));
	    }
       }
	
	

 return 0.0;
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
