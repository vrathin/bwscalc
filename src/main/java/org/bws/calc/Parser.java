package org.bws.calc;

import java.util.List;

import org.bws.calc.expression.Expression;
import org.bws.calc.tokens.Token;

public interface Parser {
	Expression parse(List<Token> tokens);
}
