import java.util.*;
import java.io.*;

//blah
public class LZcoding{


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
     Trie dictionary = new Trie();
     int num = 0; char ch;
     for(int i=0; i<charArray.length; ){
	String str = dictionary.find(charArray, i);
        System.out.println(str);
	dictionary.add(str);
	num = dictionary.getIndex(str);
	ch = dictionary.getChar(str);
       compressor.encode(num, ch);
        i += str.length();

     }//end for loop

     compressor.done();

  }// end compress

  public static void decompress(String inFile) throws Exception{
	IO.Decompressor io = new IO.Decompressor(inFile);
        HashMap<Integer, String> dictionary = new HashMap<Integer, String>();
        int count = 1;
        dictionary.put(new Integer(0), new String() );
        String output;
        Integer index;
        char character = 1;
        while(character != 0) {
 	   IO.Pair next = io.decode();
           index = new Integer(next.getIndex());
           character = next.getCharacter();
           output = dictionary.get(index);
           output = output + character;
           dictionary.put(new Integer(count), output);           
   	   io.append(output);
           count++;
  }
  /* Close all relevant files */
  io.done();



  }//end decompress
}// end class LZCoding







