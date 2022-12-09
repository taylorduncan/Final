package TestFinal;
import java.util.List;
import java.util.Scanner; 


/* 
 * An instant of this class should exist In the Complier Class
b. Takes in aa list of Token object in its constructor
c. Outputs a parse tree of called functions that would recognize the input is
syntactically correct
d. REQUIRE YOU CREATE GRAMMAR RULES THAT WOULD SATISFY A TOP DOWN PARSER
e. Should be coded in the style of a recursive decent parser
f. Code should be able to handle multiple code statements
i. A valid code file should be able to have 0 or many valid statements
g. A statement should be able to be one of the following
	i. Code block
	ii. Selection Statement
	iii. Loop Statement
	iv. Assignment Statement
		1. Should be able to assign an expression to a variable
		2. Expressions should be able to have Boolean solutions
		3. Operands in expressions can be variables, real_literal, natural_literal, bool_literal, charl_literal, string_literal, function_call
		4. Expressions should allow for unary negation operator
			a. If this symbol comes after any sumbol outside of the assignment operator or the opening symbol(s) to specify 
			   the breaking order of operations it should require it to be in the symbol(s) to specify the breaking order of operations
	v. Declaration statement
		1. Variables
		2. Functions Definition
 */


/* RULES 
 * 		<program> --> <stmt>
		<program> --> <stmt> <program>
		<stmt> --> <if_stmt> | <while_stmt> | <assign_stmt> | <block_stmt>
		<block_stmt> (structure) --> ‘{‘ { <stmt> ‘;’ } ‘}’
		<if_stmt> --> ‘if’ ‘(‘ <bool_expr> ‘)’ <stmt> [ ‘else’ <stmt> ]
		
		 	//Need help g. iv. 2
		<bool_expr> --> <band> {'OR' <band>}
		<band> --> <beq> {'AND' <beq>}
		<beq> --> <brel> {('!=' | '==') <brel>}
		<brel> --> <bexpr> {( '<=' | '>=' | '<' | '>') <bexpr>}
		<bexpr> --> <bterm> {( '+' | '-')<bterm> }
		<bterm> <bnot> {('*' | '\' | '%') <bnot> }
		<bnot> --> [!]<bfactor>
		<bfactor> ‘id’ | ‘int_lit’  | ‘float_lit’ | ‘(‘ <expr> ‘)’| bool_lit | '(' <bexpr> ')'
		
		<while_stmt> --> ‘while’ ‘(’ <bool_expr> ’)’ <stmt> 
		<assign_stmt> --> ‘id’ ‘=’ <expr> ';'
		<expr> --> <term> { ( ‘+’ | ‘-‘ ) <term> }| <bool_expr>
		<term> --> <factor> { ( ‘*’ | ‘\’ | ‘%’ ) <factor> }
		<factor> --> ‘id’ | ‘int_lit’  | 'double' | ‘(‘ <expr> ‘)’| bool_lit 
		 //need declaration statement?//NEED HELP with function stuff
		 */
public class Parser {


static Token nexttoken; 
static Lex l;
	
	public Parser() {}
	
	public Parser(Lex lex){ 
			 
			nexttoken=lex.lex();
			l=lex;
	} 
		public	void parse() { 
		//System.out.println("	parse() called");
			program(); 
		}
		
	 void program() {
		// System.out.println("	program() called");
		// nexttoken=l.lex();
		
		 if(nexttoken.getTokenID()==SpecialTokens.EOF)
		 	{ 
		 		System.out.println(" ***** EXITING PROGRAM! **** ");
		 	//	nexttoken=l.lex();
		 //	System.out.println(nexttoken);
		 	//	System.exit(-1);
		 	}
		// else
		  stmt();
		 	while(nexttoken.getTokenID()!=SpecialTokens.EOF) 
				stmt();
		 	
		}
		
		//<stmt>  <if_stmt> | <while_stmt> | <assign_stmt> | <block_stmt>
		public void stmt() { 
				
		//	System.out.println("About to call assign");
			System.out.println(nexttoken);
		//	Scanner sc= new Scanner(System.in); 
		//	String s=sc.nextLine();
			System.out.println("	stmt() called");
			if (nexttoken.getTokenID()==SpecialTokens.IF){
					if_stmt();
			}
			else if (nexttoken.getTokenID()==SpecialTokens.WHILE){	 
					while_stmt();
			}
			else if (nexttoken.getTokenID()==SpecialTokens.IDENT){
					assign_stmt(); 
				//	System.out.println("	Exit <assign_stmt> ");
			}
			else if (nexttoken.getTokenID()==SpecialTokens.LCURLY){
					block_stmt();
			}
			
			else if (nexttoken.getTokenID()==SpecialTokens.RCURLY){
					//
					//nexttoken=l.lex() ;
					if(nexttoken.getTokenID()!=SpecialTokens.RCURLY)
					{
					System.out.println("Valid! code file: i. Code block ");
					//System.exit(-1);	
					block_stmt();
					}
					else
						System.out.println("Valid code file: i. Code block ");
						nexttoken=l.lex() ;
						program();
			}
			
			else if (nexttoken.getTokenID()==SpecialTokens.EOF){ 
				//System.out.println(" IN STMT EOF" + nexttoken);
			//	
				System.out.println(" 	Exit <stmt>");
				//program();
				//System.exit(-1);
			}
			
			//default
			else	
					
					error("ERROR inside stmt()");
					//	System.exit(-1);
		}	
		public void block_stmt() { 
			//<block_stmt> (structure)  ‘{‘ { <stmt> ‘;’ } ‘}’	
			System.out.println("	block_stmt() called");
				if(nexttoken.getTokenID()==SpecialTokens.LCURLY) 
				{
					nexttoken=l.lex() ;
					program();
					//System.out.println(nexttoken);
					if(nexttoken.getTokenID()==SpecialTokens.RCURLY)
					{ 	
						System.out.println(nexttoken);
					//	error("NEED }! ");
					}
					else 
					{ 	
				//	System.out.println(nexttoken);	
				//	nexttoken=l.lex() ;
				//		System.out.println("****	INSIDE BLOCK " + nexttoken);
						if (nexttoken.getTokenID()==SpecialTokens.EOF)
						{
					//		System.out.println("****	INSIDE BLOCK DONEEEE" );
				//			System.exit(-1);
					//		program();
						}
						else
				//			program();
						error("NEED } ");
						
					}
				} 
				else error("NEED { ");
				
				//System.out.println("	Exit <block_stmt>" + nexttoken);
			}
		
			//<if_stmt>  ‘if’ ‘(‘ <bool_expr> ‘)’ <stmt> [ ‘else’ <stmt> ]	
			public void if_stmt() { 
				//System.out.println(nexttoken);
				System.out.println("	if_stmt() called");
				if(nexttoken.getTokenID()==SpecialTokens.IF){ 
					nexttoken=l.lex() ;
					if(nexttoken.getTokenID()==SpecialTokens.LPAREN){ 
						nexttoken=l.lex() ;
						//System.out.println(nexttoken);
						expr();
						if(nexttoken.getTokenID()==SpecialTokens.RPAREN){ 
							nexttoken=l.lex() ;
							
							stmt();
						}
						else
							error("NEED )");
					}
					else 
						error("NEED (");
				}
				else 
					error("NEED IF"); 	
				//System.out.println("	Exit <if_stmt>");
			}
			//NEED HELP
			/* 
			<bool_expr> --> <band> {'OR' <band>}
			<band> --> <beq> {'AND' <beq>}
			<beq> --> <brel> {('!=' | '==') <brel>}
			<brel> --> <bexpr> {( '<=' | '>=' | '<' | '>') <bexpr>}
			<bexpr> --> <bterm> {( '+' | '-')<bterm> }
			<bterm> <bnot> {('*' | '\' | '%') <bnot> }
			<bnot> --> [!]<bfactor>
			<bfactor> ‘id’ | ‘int_lit’  | ‘float_lit’ | ‘(‘ <expr> ‘)’| bool_lit | '(' <bexpr> ')'
			
			public void bool_expr(){ 
			
			}		
			
			public void band(){ 
			
			}
			public void beq(){ 
			
			}
			public void brel(){ 
			
			}
			public void bexpr(){ 
			
			}
			public void bterm(){ 
			
			}
			public void bnot(){ 
			
			}
			public void bfactor(){ 
			
			}
			*/
			
			
			//<while_stmt>  ‘while’ ‘(’ <bool_expr> ’)’ <stmt> 
			public void while_stmt() { 
				System.out.println("	while_stmt() called");
				if(nexttoken.getTokenID()==SpecialTokens.WHILE){ 
					nexttoken=l.lex() ;
					if(nexttoken.getTokenID()==SpecialTokens.LPAREN){ 
						nexttoken.getTokenID(); 
						expr();
						if(nexttoken.getTokenID()==SpecialTokens.RPAREN){
							System.out.println("Valid code file: iii. Loop Statement ");
							nexttoken=l.lex() ;
							stmt();
						}
						else
							error("NEED )");
					}
					else 
						error("NEED ("); 
				}
				else 
					error("NEED WHILE"); 
				System.out.println("	Exit <while_stmt>");
			}
			
			//<assign_stmt>  ‘id’ ‘=’ <expr> ';'
			public void assign_stmt() { 
				System.out.println("	assign_stmt() called");
				if(nexttoken.getTokenID()==SpecialTokens.IDENT) {
					nexttoken=l.lex();
					if(nexttoken.getTokenID()==SpecialTokens.ASSIGN_OP){ 
					//	System.out.println("ASSIGN" + nexttoken);
						nexttoken=l.lex(); 
						expr(); 
						if(nexttoken.getTokenID()==SpecialTokens.SEMICOLON) {
						//	System.out.println("Valid code file: ii. Assignment Statement "); 
							nexttoken=l.lex();
						//	program();
						}
						else 
							error("	NEED ;");
					}
					else 
						error("HNEED =");
				}
				else 
					error("NEED VALID ID"); 
				//System.out.println(" 	exit <assign_stmt>");
			}
			
			//<expr>  <term> { ( ‘+’ | ‘-‘ | > | < |!=) <term> }| <bool_expr>
			public void expr() { 
				//System.out.println(nexttoken+"IN EXPR");
				System.out.println("	expr() called");
				term(); 
				while(nexttoken.getTokenID()==SpecialTokens.ADD_OP||
						nexttoken.getTokenID()==SpecialTokens.SUB_OP||
					nexttoken.getTokenID()==SpecialTokens.GRTRTHAN_OP||
					nexttoken.getTokenID()==SpecialTokens.LESSTHAN_OP||
					nexttoken.getTokenID()==SpecialTokens.LOG_NOT){
					nexttoken=l.lex() ; 
					term(); 
				}
			//	System.out.println(nexttoken);
			//	System.out.println("	Exit <expr>");
			}
			
			//<term>  <factor> { ( ‘*’ | ‘\’ | ‘%’|!= ) <factor> }
			public void term() { 
				//System.out.println(nexttoken+"IN TERM");
			//	System.out.println(nexttoken);
				System.out.println("	term() called");
				factor(); 
				while(nexttoken.getTokenID()==SpecialTokens.MULT_OP||
						nexttoken.getTokenID()==SpecialTokens.DIV_OP||
						nexttoken.getTokenID()==SpecialTokens.MOD_OP||
						nexttoken.getTokenID()==SpecialTokens.ASSIGN_OP)
						
				{ 
						nexttoken=l.lex() ; 
						factor(); 
				}
			//	System.out.println(nexttoken);
			//	System.out.println("	Exit <term>");
			}
			
			/* 
			   <factor>  ‘id’ | ‘int_lit’  | ‘double’ | ‘(‘ <expr> ‘)’ 
			   FIRST(<factor>)  rule for {id} {int_lit} {float_lit} { ‘(‘ }
			 */
			public void factor() { 
				//get current token youre looking at 
				//System.out.println(nexttoken+"IN FACTOR");
			//	System.out.println(nexttoken);
				System.out.println("	factor() called");
				if (nexttoken.getTokenID()==SpecialTokens.IDENT||
					nexttoken.getTokenID()==SpecialTokens.INT_LIT||
					nexttoken.getTokenID()==SpecialTokens.DOUBLE||
					nexttoken.getTokenID()==SpecialTokens.BOOLEAN||
					nexttoken.getTokenID()==SpecialTokens.LPARAMf)
				{
					//get next token
					//System.out.println(nexttoken);
					nexttoken=l.lex() ;
					
					//program();
					
				}
				//else if
				else { 
						if(nexttoken.getTokenID()==SpecialTokens.LPAREN){ 
							nexttoken=l.lex() ; 
							expr(); 
							//make sure you have  “)”
							if(nexttoken.getTokenID()==SpecialTokens.RPAREN){
								nexttoken=l.lex() ; 
							}	
							else{
								error("NEED )") ; 
							}	
						}
						else
							//else no “(“
							error("NEED ( "); 
					}
			//	System.out.println("	Exit <factor>");
			}
			
			public void error(String s) { 
				System.out.println("SYNTAX ERROR() "+ s);
			//	System.exit(-1); 
			}
}
