package TestFinal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import TestFinal.Compiler;
public class Main {
	
	public static void main(String[] args) throws IOException {
		String line;
		int index;
		System.out.println("Taylor Duncan");
		System.out.println("FINAL \n");
		//get file 
		BufferedReader inputFile = new BufferedReader(new FileReader("/Users/Alexandria/Documents/Fall2022/TestFinal/src/TestFinal/testfile.txt"));
		System.out.println("File Reads: "); 
		String content = "";
		while ((line = inputFile.readLine()) != null) 
		{
			index = 0;
			System.out.println(line);
			content = content + line + "\n";
			
		}
		
		System.out.println("\n"); 
		/* Lex l = new Lex(content);

	        Token tok = l.lex();

	        while (tok.getTokenID() != SpecialTokens.EOF) {

	            System.out.println(tok);

            tok = l.lex();

	        }
	        */
	Compiler compile=new Compiler(content); 
		
	}
	
}
