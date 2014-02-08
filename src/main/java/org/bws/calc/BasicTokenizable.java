package org.bws.calc;

import java.util.ArrayList;

import org.bws.calc.tokens.MinusToken;
import org.bws.calc.tokens.PlusToken;
import org.bws.calc.tokens.Token;
import org.bws.calc.util.CharUtil;

public class BasicTokenizable implements Tokenizable {

	public ArrayList<Token> tokenize(char[] array){
		ArrayList<Token> tokens = new ArrayList<Token>();
		StringBuilder cur = new StringBuilder();
		for(int i=0;i<array.length;i++){
		   if(CharUtil.isNumber(array[i])){ cur.append(array[i]); }
		   else {
				if(cur.length() > 0 ){
					tokens.add(new Token(cur.toString())); 
					cur = new StringBuilder();
				}
				if(array[i] == '(' ){tokens.add(new Token("("));}
				if(array[i] == ')' ){tokens.add(new Token(")"));}
				if(array[i] == '+' ){tokens.add(new PlusToken("+"));}
				if(array[i] == '-' ){tokens.add(new MinusToken("-"));}
			}
		}
		if(cur.length() > 0 ) tokens.add(new Token(cur.toString()));
	
		return tokens;
	}
}
