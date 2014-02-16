package org.bws.calc;

import java.util.ArrayList;
import java.util.List;

import org.bws.calc.exception.ParseException;
import org.bws.calc.expression.Expression;
import org.bws.calc.expression.ValueExpression;
import org.bws.calc.tokens.OpToken;
import org.bws.calc.tokens.Token;

public class SimpleParser implements Parser{

	public Expression parse(List<Token> tokens){	
		if(tokens.size() == 1){
			Token t = tokens.get(0);
			try{
				int intVal = Integer.parseInt(t.getValue());
				return new ValueExpression(intVal);
			}catch(NumberFormatException nfe){
				throw new ParseException("expected int but found: "+t.getValue());
			}
		}
		
		Expression left;
		Expression right;
		
		int index=0;
		Token firstToken = tokens.get(index++);
		
		if("(".equals(firstToken.getValue())){
			int openParens =1;
			while(openParens > 0 ){
				if(index>tokens.size()-1){throw new ParseException("Missing right Parenthesis");}
				Token token = tokens.get(index);
				if("(".equals(token.getValue())){ ++openParens;}
				if(")".equals(token.getValue())){ --openParens;}
				++index;
			}
			if(index == tokens.size()){
				return parse(new ArrayList<Token>(tokens.subList(1, index-1) ) );
			}
			left = parse(new ArrayList<Token>(tokens.subList(1,index-1)));
			
		}else{
			int tokenVal = Integer.parseInt(firstToken.getValue());
			 left = new ValueExpression(tokenVal);
		}
		
		Token op = tokens.get(index);
		if(! (op instanceof OpToken) ){
			throw new ParseException("Invalid Syntax. expected Operator but found:"+op);
		}
		OpToken opToken = (OpToken) op;
		++index;
		
		Token firstRightToken = tokens.get(index++);
		if("(".equals(firstRightToken.getValue() ) ){
			right = parse(new ArrayList<Token>(tokens.subList(index,tokens.size()-1)));			
		}else{
			int tokenVal = Integer.parseInt(firstRightToken.getValue());
			right = new ValueExpression(tokenVal);
		}
		
		return opToken.toExpression(left, right);
	}
}
