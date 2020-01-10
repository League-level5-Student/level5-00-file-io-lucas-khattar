package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileEncryptor {
	public static void main(String[] args) {
		String str = JOptionPane.showInputDialog(null, "Eneter a message you would like to save to a file");
		try {
			FileWriter fw = new FileWriter("/Users/league/Desktop/level5-00-file-io-lucas-khattar/src/_02_File_Encrypt_Decrypt/text.txt", true);
			
			fw.write(str);
				
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
