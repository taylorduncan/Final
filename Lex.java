package TestFinal;
import java.util.List; 
import java.util.HashMap; 
import java.util.regex.*;

import TestFinal.Parser;
import TestFinal.Token;
import TestFinal.Lex;

import java.util.ArrayList;
/* 
a. An instant of this class should exist In the Complier Class
b. Takes in a string in its constructor
c. Converts a string into a list of Token object if there exist no errors
	i. Should ignore block comments
	ii. Should ignore single line comments
d. Should contain the following tokens and clear patterns or automata to recognize them (in the comments each should be specified)
	i. real_literal represents fractional number
	ii. natural_literal represent whole numbers and 0
	iii. bool_literal
	iv. char_liter represents a single ascii charater including escape character
		1. Java rules for escape character
	v. string_literal represents a any number of ascii charater including escape character
		1. Java rules for escape character
	vi. Keywords For
		1. Selection statement
		2. Loop Statement
		3. Variable declaration for
			a. Strings
			b. Naturals
			c. Character
			d. Reals
			e. Booleans
	vii. Special Symbols for
		1. Addition
		2. Subtraction
		3. Multiplication
		4. Division
		5. Exponentiation
		6. Symbol(s) to specify the breaking order of operations
		7. Greater than
		8. Less Than
		9. Greater Than or equal too (must be more than two characters)
		10. Less Than or equal too (must be more than two characters)
		11. Equal to
		12. Not equal too (must be more than two characters)
		13. unary negation operator
		14. Logical Not
		15. Logical And
		16. Logical Or
		17. Symbol(s) of grouping code blocks
		18. Parameter separator
		19. Symbol(s) to specify the parameters of a function
	viii. Variable/function identifier
 * 
 */

public class Lex {

	List<Token> tokens; 
	int index=0; 
	
	Lex(String input){ 
		tokens=tokenize(input); 
		index=0; 
	
	}
	 public Token lex() {
		    Token t = null;
		    if (index < tokens.size()) {
		      t = tokens.get(index);
		      index++;
		      System.out.println("Next Token is: "+t.getTokenID()+", Next lexeme is "+t);
		    	return t;  
		    }
		    else{
		    	System.out.println("WTF");
		    	return null; 
		    }
		    
		  }
	 
	 
	 public boolean noMoreTokens() { 
		 System.out.println(index +" lexems");
		 if(index>=tokens.size()) { 
			return true; 
		 }
		 else 
			 return false; 
	 }

	//List<Token>
	private List<Token> tokenize(String input){ 
		//System.out.println(input);
		List<Token> result = new ArrayList<Token>();
	    for(int i = 0; i < input.length(); ) {
	    	//System.out.println(input.charAt(i));
	      switch(input.charAt(i)) {
	        case '(':
	          result.add(new Token(SpecialTokens.LPAREN, "("));
	       //   result.add(new Token(SpecialTokens.LPARAM, "("));
	          i++;
	          break;
	        case ')':
	          result.add(new Token(SpecialTokens.RPAREN, ")"));
	      //    result.add(new Token(SpecialTokens.RPARAM, ")"));
	          i++;
	          break;
	        case '+':
	          result.add(new Token(SpecialTokens.ADD_OP, "+"));
	          i++;
	          break;
	        case '-':
	          result.add(new Token(SpecialTokens.SUB_OP, "-"));
	      //    result.add(new Token(SpecialTokens.NEGATE, "-"));
	          i++;
	          break;
	        case '*':
	          result.add(new Token(SpecialTokens.MULT_OP, "*"));
	          i++;
	          break;
	        case '/':
	          result.add(new Token(SpecialTokens.DIV_OP, "/"));
	          i++;
	          break;
	        case '^':
		          result.add(new Token(SpecialTokens.EXPO_OP, "^"));
		          i++;
		          break;
	        case '=':
		          result.add(new Token(SpecialTokens.ASSIGN_OP, "="));
		        //  result.add(new Token(SpecialTokens.EQUALTO, "="));
		          i++;
		          break;
	        case '%':
		          result.add(new Token(SpecialTokens.MOD_OP, "%"));
		          i++;
		          break;       
	        case '<':
		          result.add(new Token(SpecialTokens.LESSTHAN_OP, "<"));
		          //EEQUAL TO NED HELP
		          i++;
		          break;     
	        case '>':
		          result.add(new Token(SpecialTokens.GRTRTHAN_OP, ">"));
		          //EEQUAL TO NED HELP
		          i++;
		          break;  
	          
	        case '!':
	        	/*
	        	int a = i; 
	        	while ((a < input.length()) && Character.isLetter(input.charAt(a)))
	        		a++;
	        	if (input.substring(i,a).equals("="))
	            { 
	            	result.add(new Token(SpecialTokens.NOTEQUALTO, input.substring(i,a)));
	            	i=a;
	            }
	        
	        	else*/
		          result.add(new Token(SpecialTokens.LOG_NOT, "!"));
		        //  result.add(new Token(SpecialTokens.NOTEQUALTO, "!"));
		          i++;
		          break; 
		          
	        	
	        case '&':
		          result.add(new Token(SpecialTokens.LOG_AND, "&"));
		          i++;
		          break;     
	        case '|':
		          result.add(new Token(SpecialTokens.LOG_OR, "|"));
		          i++;
		          break;     
	        case '{':
		          result.add(new Token(SpecialTokens.LCURLY, "{"));
		          i++;
		          break;      
	        case '}':
		          result.add(new Token(SpecialTokens.RCURLY, "}"));
		          i++;
		          break;     
	        case ';':
		          result.add(new Token(SpecialTokens.SEMICOLON, ";"));
		          i++;
		          break;   
	        default:
	          if(Character.isWhitespace(input.charAt(i)))
	            i++;
	          else if (Character.isDigit(input.charAt(i))) 
	          {
	            int j = i;
	            while ((j < input.length()) && Character.isDigit(input.charAt(j)))
	              j++;
	            if(input.charAt(j)=='.'){
	            	while ((j < input.length()) && Character.isDigit(input.charAt(j)))
	            	{ j++;
	            	}
	            	result.add(new Token(SpecialTokens.DOUBLE, input.substring(i,j)));
	            	i = j;
	            	
	            }
	            else {
	            	result.add(new Token(SpecialTokens.INT_LIT, input.substring(i,j)));
	            	i = j;
	            }
	          }
	          else if (Character.isLetter(input.charAt(i))) 
	          {
	        	 
	            int j = i;
	            while ((j < input.length()) && (Character.isDigit(input.charAt(j)) ||
	                                            Character.isLetter(input.charAt(j))))
	              j++;
	            if(input.substring(i,j).equals("!="))
	            {
	            	result.add(new Token(SpecialTokens.NOTEQUALTO, input.substring(i,j)));
	            	i=j;
	            }
	            if(input.substring(i,j).equals("!"))
	            {
	            	result.add(new Token(SpecialTokens.LOG_NOT, input.substring(i,j)));
	            	i=j;
	            }
	            if(input.substring(i,j).equals("()"))
	            {
	            	result.add(new Token(SpecialTokens.LPARAMf, input.substring(i,j)));
	            	i=j;
	            }
	            if(input.substring(i,j).equals("if"))
	            {
	            	result.add(new Token(SpecialTokens.IF, input.substring(i,j)));
	            	i=j;
	            }
	            else if (input.substring(i,j).equals("while"))
	            { 
	            	result.add(new Token(SpecialTokens.WHILE, input.substring(i,j)));
	            	i=j;
	            }
	            else if (input.substring(i,j).equals("true"))
	            { 
	            	result.add(new Token(SpecialTokens.BOOLEAN, input.substring(i,j)));
	            	i=j;
	            }
	            else if (input.substring(i,j).equals("false"))
	            { 
	            	result.add(new Token(SpecialTokens.BOOLEAN, input.substring(i,j)));
	            	i=j;
	            }
	            else if (input.substring(i,j).equals(" \" "))
	            { 
	            	result.add(new Token(SpecialTokens.STRING, input.substring(i,j)));
	            	i=j;
	            }
	            
	        //    else if (input.substring(i,j)=="\"\"")
	         //   { 
	       //     	result.add(new Token(SpecialTokens.STRING, input.substring(i,j)));
	        //    }
	          else  
	            {
	            result.add(new Token(SpecialTokens.IDENT, input.substring(i,j)));
	            i = j;
	            }
	          }
	          /*********************/
	          else
	          {
	            System.out.println("UNEXPECTED CHARACTER ENCOUNTERED");
	            System.exit(-1);
	          }
	          break;
	      }
	    }
	    
	    result.add(new Token(SpecialTokens.EOF, "-1"));
	    return result;
		
	}

	
	
	
}
	

