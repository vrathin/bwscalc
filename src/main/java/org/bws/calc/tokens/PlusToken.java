package org.bws.calc.tokens;

import org.bws.calc.expression.AdditionExpression;
import org.bws.calc.expression.Expression;

public class PlusToken extends OpToken{

	public PlusToken(String value) {
		super(value);
		// TODO Auto-generated constructor stub
	}
	
	public Expression toExpression(Expression left, Expression right){
		return new AdditionExpression(left, right);
	}
	
}