import java.util.*;
import java.io.*;

public class LZcoding{

public class Trie {
	int index;
        String chars;
        ArrayList<Trie> pointers;
        ArrayList<Character> nextChar;

	int highestIndex;

	public Trie() {
	  index = 0;
	  highestIndex = 0;
          chars = new String();
          pointers = new ArrayList<Trie>(128);
	  nextChar = new ArrayList<Character>(128);
        }

	public Trie(String input, int in) {
          index = in;
	  chars = new String(input);
	  pointers = new ArrayList<Trie>(128);
	  nextChar = new ArrayList<Character>(128);
	}

	public String find(char[] inChar, int ind){
	//return shortest string not in trie
        char[] testString;
	char testChar;
	boolean end = false;
	int counter = ind;
	int pointerIndex;
	Trie searchTrie = this;
	while (!end) {
	    testChar = inChar[counter];
	    pointerIndex = searchTrie.nextChar.indexOf(new Character(testChar));
	    if (pointerIndex != -1) {
	        searchTrie = searchTrie.pointers[pointerIndex];
		counter++;
		}
            else {
	        end = true;
            }
	}
        return new String(inChar, ind, counter - ind);

	
	}

	public void add(String input){

	//add the String to the Trie
	
	highestIndex++;
	int ind = 0;
	Trie target = this;
	    for(int i = 0; i < input.length() - 1; i++) {
 	        index = nextChar.indexOf(new Character(input.charAt(i)));
		target = pointers[index];
	}
	target.nextChar.append(input.charAt(input.length() ));
	target.pointers.append(new Trie(input, highestIndex));
	}

	public int getIndex(String input){
	//add the String to the Trie
        String substr = input.substring(0, input.length() - 1);
	int ind = 0;
	Trie target = this;
	    for(int i = 0; i < substr.length(); i++) {
	        ind = nextChar.indexOf(new Character(input.charAt(i)));
		if (ind == -1) { return -1;}
		target = pointers[index];
		}
	return target.index;

	}
        
	public char getChar(String input){
	    return input.charAt[input.length() - 1];

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
     Trie dictionary = new Trie();
     int num = 0; char ch;
     for(int i=0; i<charArray.length; ){
	String str = dictionary.find(charArray, i);
	dictionary.add(str);

	num = dictionary.getIndex(str);
	ch = dictionary.getChar(str);

       compressor.encode(num, ch);

     }//end for loop

     compressor.done();

  }// end compress

  public static void decompress(String inFile) throws Exception{

  }//end decompress
}// end class LZCoding







