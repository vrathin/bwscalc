package org.bws.calc.expression;


public class ValueExpression extends Expression{
	private int value;
	public ValueExpression(int value){this.value=value;}
	public int evaluate(){return value;}

}
