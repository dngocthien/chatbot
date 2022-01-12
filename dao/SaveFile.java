package dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class SaveFile {
	PrintWriter printWriter;

	public SaveFile() {
		File f= new File("data/data.txt");
		System.out.println(f.exists());
		
		try {
			printWriter = new PrintWriter(
					new OutputStreamWriter(new FileOutputStream(f), "utf-8"));
		} catch (UnsupportedEncodingException e) {
			System.out.println("unsupport save data");
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
		}
	}
	
	public void save(String st) {
		printWriter.println(st);
		printWriter.flush();
	}
}
