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
  /*
   The compressor function creates a new IO.Compressor and gets
   characters from an input file. It creates a Trie to store data.
   It then loops through all the data, doing the following:
   	Find the shortest string not stored in the Trie
        Add this string to the Trie
        Gets the index to transmit
        Gets the character to transmit
        Encode(index, character)
        Update the loop counter
   Afterward, it closes the compressor
   */
  public static void compress(String inFile) throws Exception{
     IO.Compressor compressor = new IO.Compressor(inFile);
     char[] charArray = compressor.getCharacters();
     Trie dictionary = new Trie();
     int num = 0; char ch;
     
     for(int i=0; i<charArray.length; ){
	String str = dictionary.find(charArray, i);
	dictionary.add(str);
	num = dictionary.getIndex(str);
	ch = dictionary.getChar(str);
        compressor.encode(num, ch);
        i += str.length();

     }//end for loop

     compressor.done();

  }// end compress
   /*
   The decompressor function creates a new IO.Decompressor and a new
   dictionary. It loops over all the data in the inputfile as follows:
	Get a (index, character) pair from the file
        Get the index
	Get the character
	Get the string from the dictionary with the index
        Add the character to the string
        Put the new string in the dictionary
        Output the string to the output file.
   At the end, it closes the file.
   */
  public static void decompress(String inFile) throws Exception{
	IO.Decompressor io = new IO.Decompressor(inFile);
        HashMap<Integer, String> dictionary = new HashMap<Integer, String>();
        int count = 1;
        dictionary.put(new Integer(0), new String() );
        String output = "";
        Integer index;
        char character = 1;
        while( character != 0 ) {
 	   IO.Pair next = io.decode();
           index = new Integer(next.getIndex());
           character = next.getCharacter();
           
           output = dictionary.get(index);
           if (character == 0) io.append(output);
           else output = output + character;
   	   io.append(output);
           dictionary.put(new Integer(count), output);
           count++;
  }
  
  
  /* Close all relevant files */
  io.done();



  }//end decompress
}// end class LZCoding







