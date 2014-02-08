package org.bws.calc.tokens;

import org.bws.calc.expression.Expression;
import org.bws.calc.expression.ValueExpression;

public class IntToken extends Token {
	public IntToken(String value) {
		super(value);
		intValue = Integer.parseInt(value);
	}

	public Expression toExpression() {
		return new ValueExpression(intValue);
	}

	private int intValue;

	public int getIntValue() {
		return intValue;
	}

}