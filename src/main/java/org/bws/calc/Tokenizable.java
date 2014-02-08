package org.bws.calc;

import java.util.ArrayList;

import org.bws.calc.tokens.Token;

public interface Tokenizable {

	ArrayList<Token> tokenize(char[] array);
}
