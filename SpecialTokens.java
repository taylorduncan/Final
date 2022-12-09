package TestFinal;

public class SpecialTokens {

	/* keywords*/
	  /* 
	    i. real_literal represents fractional number == double
		ii. natural_literal represent whole numbers and 0 == int
		iii. bool_literal == boolean
		iv. char_liter represents a single ascii charater including escape character==char
	v. string_literal represents a any number of ascii charater including escape character == String
		*/	
	
	/* Token codes */
		public static final int ADD_OP = 1;
		public static final int SUB_OP = 2;
		public static final int MULT_OP = 3;
		public static final int DIV_OP = 4;
		public static final int EXPO_OP = 5;
		public static final int LPAREN = 6;
		public static final int RPAREN = 7;
		public static final int GRTRTHAN_OP = 8;
		public static final int LESSTHAN_OP = 9;
		public static final int GRTRTHANE_OP = 10;
		public static final int LESSTHANE_OP = 11;
		public static final int EQUALTO = 12;
		public static final int NOTEQUALTO = 13;		//x != y
		public static final int NEGATE = 14; 			//-x   
		public static final int LOG_NOT=15;  			//!(a > 0 || b> 0)  
		public static final int LOG_AND =16; 
		public static final int LOG_OR=17;  
		public static final int LCURLY = 18;
		public static final int RCURLY = 19;
		public static final int LPARAM=20; 
		public static final int RPARAM=21;
		public static final int LPARAMf=22; 
		public static final int RPARAMf=23;
		//i. Should ignore block comments
		//ii. Should ignore single line comments
		public static final int blockcomment = 24;
		public static final int singlelinecomment = 25;
		
		public static final int IDENT = 26;
		public static final int INT_LIT = 27;
		public static final int ASSIGN_OP = 28;			//x = y ;
		public static final int MOD_OP = 29;
		public static final int SEMICOLON = 30;
		public static final int IF = 31;
	  	public static final int FOR = 32;
	  	public static final int WHILE = 33;
	  	public static final int INT = 34;
	  	public static final int DOUBLE = 35;
	  	public static final int BOOLEAN = 36;
	  	public static final int CHAR = 37;
	  	public static final int STRING = 38;
	  	public static final int EOF = 0;
	
	
	
}
