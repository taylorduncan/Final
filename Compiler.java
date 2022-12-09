package TestFinal;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import TestFinal.Main;
public class Compiler {
	
	//Has a method that takes in an INPUT FILE and converts it to one input str 
	
	Compiler(String file){ 
		//convert file into a string 			 
		//pass file string into lex 
		Lex lex= new Lex(file); 
	
		Parser syntax = new Parser(lex); 
		syntax.parse(); 
		if(lex.noMoreTokens()) { 
			System.out.println(" parse works: :) i hope i passed "); 
		}
		else 
			System.out.println(" parse doesn't work :( "); 
	}
}
