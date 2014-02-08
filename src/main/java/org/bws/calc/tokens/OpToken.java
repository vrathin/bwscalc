package org.bws.calc.tokens;

import org.bws.calc.expression.Expression;

public abstract class OpToken extends Token {
	public OpToken(String value) {
		super(value);
	}

	public String getValue() {
		return value;
	}

	public abstract Expression toExpression(Expression left, Expression right);
}