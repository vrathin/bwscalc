package org.bws.calc;

import java.util.List;

import org.bws.calc.exception.ParseException;
import org.bws.calc.tokens.Token;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

	Tokenizable t;
	Parsable p;
	Calculator c;
	
	@Before
	public void setup(){
		t = new BasicTokenizable();
		p = new SimpleParser();
		c = new Calculator(t, p);		
		
	}
	
	@Test
	public void tokenizeWithOneOperator(){

		List<Token> tokens = c.tokenize("1+1".toCharArray() );
		Assert.assertEquals(3, tokens.size());
		Assert.assertEquals("1", tokens.get(0).getValue() );
		Assert.assertEquals("+",   tokens.get(1).getValue());
		Assert.assertEquals("1",  tokens.get(2).getValue() );
	}

	@Test
	public void evaluateZeroOperators(){

		int result = c.evaluate("1" );
		Assert.assertEquals(1,result);

	}
	
	@Test
	public void evaluateOneOperator(){

		int result = c.evaluate("1+1" );
		Assert.assertEquals(2,result);

	}
	
	@Test
	public void evaluateOneOperatorWithParens(){

		int result = c.evaluate("(1+1)" );
		Assert.assertEquals(2,result);

	}

	@Test
	public void evaluateTwoOperatorWithParens(){

		int result = c.evaluate("((1-0)+(1-1))" );
		Assert.assertEquals(1,result);

	}

	@Test
	public void evaluateThreeOperatorWithInnerParens(){

		int result = c.evaluate("(1-1)+(1+1)" );
		Assert.assertEquals(2,result);

	}

	@Test(expected=ParseException.class)
	public void evaluateMissingParens(){

		c.evaluate("((1+1)" );
	}
	
	@Test(expected=ParseException.class)
	public void evaluateMissingParens2(){

		c.evaluate("(1+1))" );
	}	
}
