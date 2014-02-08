package org.bws.calc.tokens;

import org.bws.calc.expression.Expression;
import org.bws.calc.expression.SubtractionExpression;

public class MinusToken extends OpToken{

	public MinusToken(String value) {
		super(value);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Expression toExpression(Expression left, Expression right){
		return new SubtractionExpression(left, right);
	}
}
