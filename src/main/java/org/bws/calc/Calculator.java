package org.bws.calc;

import java.util.ArrayList;

import org.bws.calc.exception.InvalidOperationException;
import org.bws.calc.expression.Expression;
import org.bws.calc.tokens.Token;

public class Calculator{
	
	private Tokenizable tokenizer;
	private Parsable parser;
	
	public Calculator(Tokenizable t, Parsable p){
		this.tokenizer=t;
		this.parser = p;
	}
	
	public int evaluate(String expression) throws InvalidOperationException{
		if(expression == null ){throw new InvalidOperationException("expression was null");}
		
		char[] array  = expression.toCharArray();
		ArrayList<Token> tokenList = tokenize(array);
		Expression root = parse( tokenList );
		return root.evaluate();
	}
	
	public Expression parse(ArrayList<Token> tokens){
		return parser.parse(tokens);
	}
	
	public ArrayList<Token> tokenize(char [] array){
		return tokenizer.tokenize(array);
	}
	
}
