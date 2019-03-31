package app;

import java.io.*;
import app.dashboard.*;
import app.asset.*;

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
		} catch (IOException i) {
			i.printStackTrace();
		}

	}

	// returns an object read from save file
	public static Object loadFromSaveFile(String filePath) {
		try {
			FileInputStream fileIn = new FileInputStream(filePath);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			Object o = in.readObject();
			in.close();
			fileIn.close();
			return o;
		} catch (IOException i) {
			i.printStackTrace();
			return null;
		} catch (ClassNotFoundException c) {
			System.out.println("Class not found.");
			c.printStackTrace();
			return null;
		}
	}

}
