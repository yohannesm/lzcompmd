import java.util.*;
import java.io.*;

public class LZcoding{

public class Trie {
	int index;
        String chars;
        ArrayList<Trie> pointers;
        

	public Trie() {
          chars = new String();
          pointers = new ArrayList();
        }            

        
}

public static void main(String[] args) {


/*
 * 1. read in the file
 * 2. Put the file in the Trie like data structures..
 * 3. Compress the file.
 * 4. Close the file.
 */
	char[] inChar;
	try{
	if( args[0].equals("c")){
	compress(args[1]);

	}
	else if(args[0].equals("d")){ // 
	decompress(args[1]);
	}
	else{
	throw new Exception();
	}


	}//end try

	
	catch(Exception e){
	System.err.println("exception thrown: " + e.getMessage() );
		}
	}
  
  public static void compress(String inFile) throws Exception{
     IO.Compressor compressor = new IO.Compressor(inFile);
     char[] charArray = compressor.getCharacters();

     //do stuff
     for(int i=0; i<charArray.length;i++){
       compressor.encode(i, charArray[i]);
     }//end for loop

     compressor.done();

  }// end compress

  public static void decompress(String inFile) throws Exception{

  }//end decompress
}// end class LZCoding







