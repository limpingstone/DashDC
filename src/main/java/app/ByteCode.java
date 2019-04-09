package app;

import java.io.*;
import app.dashboard.*;
import app.asset.*;

public class ByteCode {

    
	// Generates a Java serialized save file from a Dashboard object d
	// Writes the serialized data file to the path on the computer specified by String filePath
	public static void generateSaveFile(Dashboard d, String filePath) {

		try {
		        // set up file stream to write contents to
			FileOutputStream fileOut = new FileOutputStream(filePath);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(d); // serialize and write the object to the stream
			out.close();
			fileOut.close();
		} catch (IOException i) { // catch any IO exceptions, such as if the filePath is invalid
			i.printStackTrace();
		}

	}

	// Returns an Object read from the Java serial file specified by the String filePath
        // The returned Object is an instance of Dashboard
	public static Object loadFromSaveFile(String filePath) {
		try {
		       // set up file stream to read contents from
			FileInputStream fileIn = new FileInputStream(filePath);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			Object o = in.readObject(); // unserialize the boject and store it as o
			in.close();
			fileIn.close();
			return o;
		} catch (IOException i) { // catch any IO exceptions, such as if the filePath is invalid
			i.printStackTrace();
			return null;
		} catch (ClassNotFoundException c) { // catch exception if the serialized object's class no longer exists in program code
			System.out.println("Class not found.");
			c.printStackTrace();
			return null;
		}
	}

}
