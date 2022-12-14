# Final
PLC Final Test 
my path to file: "/Users/Alexandria/Documents/Fall2022/TestFinal/src/TestFinal/testfile.txt"
/* RULES 
		
		
		<start>	--> <program>
 		<program> --> <stmt>
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
