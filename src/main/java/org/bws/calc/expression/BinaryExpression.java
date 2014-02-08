package org.bws.calc.expression;


public abstract class BinaryExpression extends Expression{
	public BinaryExpression(Expression left, Expression right){
		this.left = left;
		this.right=right;
	}
	protected Expression left;
	protected Expression right;
	
}