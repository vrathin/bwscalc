package org.bws.calc.expression;


public class SubtractionExpression extends BinaryExpression{
	public SubtractionExpression(Expression left, Expression right){
		super(left,right);
	}
	public int evaluate(){
		return (left.evaluate() - right.evaluate());
	}
}