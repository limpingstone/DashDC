package app;
import java.io.*;

public class ByteCode {

    // generates save file from a dashboard object
    // writes it to file path
    public static void generateSaveFile(Dashboard d, String filePath) {
	
	try {
	    FileOutputStream fileOut = new FileOutputStream(filePath);
	    ObjectOutputStream out = new ObjectOutputStream(fileOut);
	    out.writeObject(d);
	    out.close();
	    fileOut.close();
	}
	catch (IOException i) {
	    i.printStackTrace();
	}



    }

}
