package org.bws.calc.expression;


public class AdditionExpression extends BinaryExpression{
	public AdditionExpression(Expression left, Expression right){
		super(left,right);
	}
	public int evaluate(){
		return (left.evaluate() + right.evaluate());
	}
}