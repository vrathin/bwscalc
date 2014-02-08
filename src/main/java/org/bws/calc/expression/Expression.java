package org.bws.calc.expression;

public abstract class Expression{

	public abstract int evaluate();
	public String toString(){
		return evaluate() + "";
	}
}
