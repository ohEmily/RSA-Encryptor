package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Writer;

/**
 * The {@link IO} class is a class that provides all the basic input and output
 * methods required for Data Structures in Java (COMS W3134).
 * 
 */
public final class IO {
	public static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	public static PrintStream stdout = System.out;
	public static PrintStream stderr = System.err;
		/**
	 * Reads the contents of a file.
	 * 
	 * @param fileName name of the file to read
	 * @return contents of the file if the contents of the file were read
	 *         successfully or an empty string if otherwise
	 */
	public static String readFile(String fileName) {
		String fileContents = "";
		BufferedReader bufferedReader;
		try {
			bufferedReader = new BufferedReader(new FileReader(fileName));
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				fileContents += line + "\n";
			}
			bufferedReader.close();
		} catch (IOException e) {
			stderr.println("Cannnot open file: " + fileName);
		}
		return fileContents;
	}

    public static String readLine()
    {
        String fileContents = "";
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new 
            		InputStreamReader(System.in));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                fileContents += line + "\n";
            }
            bufferedReader.close();
        } catch (IOException e) {
            stderr.println("Cannnot read input.");
        }
        return fileContents;
    }
	
	public static void writeFile(String fileName, String contents)
	{
		Writer writer = null;
		try {
		    writer = new BufferedWriter(new FileWriter(fileName));
		    writer.write(contents);
		} catch (IOException ex) {
		  System.out.println("No such file, betch!");
		} finally {
		   try {writer.close();} catch (Exception ex) {}
		}

	}
}