import org.junit.* ;
import static org.junit.Assert.*;
import java.io.*;

public class LZcodingTest {

    @Test
    public void testLZcoding() {
        try {
        char [] Testout = "This is a test of the LZcoding class.".toCharArray();
        FileOutputStream outfile = new FileOutputStream("LZcodingTest.txt");
        for (int i = 0; i < Testout.length; i++) {
            outfile.write((int)Testout[i]); }
        outfile.close();

        LZcoding.compress("LZcodingTest.txt");
        LZcoding.decompress("LZcodingTest.txt.cpz");

        IO.Compressor compressor = new IO.Compressor("LZcodingTest.txt");
        String original = new String(compressor.getCharacters());
        compressor = new IO.Compressor("LZcodingTest.txt.cpz.dcz");
        String newfile = new String(compressor.getCharacters());
       
        assertTrue(original.equals(newfile));
        }
        catch (Exception E) { 
        assertTrue(false); }
    }
}
