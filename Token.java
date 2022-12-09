package TestFinal;

public class Token {
	//String for lexeme representation
	//b. Int for token code
	  public int t;
	  public String c;

	  public Token(int code,String lexeme) {
		t = code;
	    c = lexeme;
	  }
	  public Token(int code) {
			t = code;
		   
	  }
	  
	   public String toString() {
		   
	    if(t == SpecialTokens.IDENT)
	        return "IDENT <" + c + "> ";
	    else if(t == SpecialTokens.INT_LIT)
	        return "INT_LIT <" + c + "> ";
	    else if(t == SpecialTokens.NOTEQUALTO)
 	        return "NOTEQUALTO <" + c + "> ";
	    else if(t==SpecialTokens.LPAREN)
	      return "LPAREN <" + c + "> ";
	    else if(t==SpecialTokens.LPARAM)
		      return "LPAREN <" + c + "> ";
	    else if(t==SpecialTokens.RPARAM)
		      return "LPAREN <" + c + "> ";
	    else if(t==SpecialTokens.RPAREN)
	      return "RPAREN <" + c + "> " ;
	    else if(t==SpecialTokens.ADD_OP)
	      return "ADD_OP <" + c +"> ";
	    else if(t==SpecialTokens.SUB_OP)
	      return "SUB_OP <"+ c +"> ";
	    else if(t==SpecialTokens.MULT_OP)
	      return "MULT_OP <" + c +"> ";
	    else if(t==SpecialTokens.DIV_OP)
	      return "DIV_OP <" + c +"> ";
	    else if(t==SpecialTokens.EXPO_OP)
		      return "EXPO_OP <" + c +"> ";
	    else if(t==SpecialTokens.INT_LIT)
		      return "INT_LIT <" + c +"> ";
	    else if(t==SpecialTokens.ASSIGN_OP)
		      return "ASSIGN_OP <"+ c + "> " ;
	    else if(t==SpecialTokens.MOD_OP)
		      return "MOD_OP <" + c +"> ";
	    else if(t==SpecialTokens.LESSTHAN_OP)
		      return "LESSTHAN_OP <" + c +"> ";
	    else if(t==SpecialTokens.GRTRTHAN_OP)
		      return "GRTRTHAN_OP <" + c +"> ";
	    else if(t==SpecialTokens.LESSTHANE_OP)
		      return "LESSTHANE_OP <" + c +"> ";
	    else if(t==SpecialTokens.GRTRTHANE_OP)
		      return "GRTRTHANE_OP <" + c +"> ";
	    else if(t==SpecialTokens.NEGATE)
		      return "NEGATE <" + c +"> ";
	    else if(t==SpecialTokens.LOG_AND)
		      return "LOG_AND <" + c +"> ";
	    else if(t==SpecialTokens.LOG_OR)
		      return "LOG_OR <" + c +"> ";
	    else if(t==SpecialTokens.LOG_NOT)
		      return "LOG_NOT <" + c +"> ";
	    else if(t==SpecialTokens.LCURLY)
		      return "LCURLY <" + c +"> ";
	    else if(t==SpecialTokens.RCURLY)
		      return "RCURLY <" + c +"> ";
	    else if (t==SpecialTokens.EOF)
	      return "EOF <" + c +"> ";
	    else {
	    	//fix if while ... then else error
	    	if (t==SpecialTokens.IF)
	    		return "IF: "+ c;
	    	if (t==SpecialTokens.WHILE)
	    		return "WHILE: "+ c;
	    	if (t==SpecialTokens.SEMICOLON)
	    		return "SEMICOLON: "+ c;
	    	if (t==SpecialTokens.FOR)
	    		return "FOR: "+ c;
	    	if (t==SpecialTokens.DOUBLE)
	    		return "DOUBLE: "+ c;
	    	if (t==SpecialTokens.BOOLEAN)
	    		return "BOOLEAN: "+ c;
	    	if (t==SpecialTokens.CHAR)
	    		return "CHAR: "+ c;
	    	if (t==SpecialTokens.STRING)
	    		return "STRING: "+ c;
	 
	    }
	    return "UNKNOWN IN TOKEN toString "+c;
	  }

	  int getTokenID() {
	    return t;
	  }	 
	
}
