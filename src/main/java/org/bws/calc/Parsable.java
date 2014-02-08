package org.bws.calc;

import java.util.ArrayList;

import org.bws.calc.expression.Expression;
import org.bws.calc.tokens.Token;

public interface Parsable {
	Expression parse(ArrayList<Token> tokens);
}
