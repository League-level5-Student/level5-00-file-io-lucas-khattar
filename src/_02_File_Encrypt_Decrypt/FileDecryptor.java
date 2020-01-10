package _02_File_Encrypt_Decrypt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileDecryptor {
	// Create a program that opens the file created by FileEncryptor and display
	// the decrypted message to the user in a JOptionPane.
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("/Users/league/Desktop/level5-00-file-io-lucas-khattar/src/_02_File_Encrypt_Decrypt/text.txt"));
			
			String line = br.readLine();
			while(line != null){
				JOptionPane.showMessageDialog(null, line);
				line = br.readLine();
			}
			
			br.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
