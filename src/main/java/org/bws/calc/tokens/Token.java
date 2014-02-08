package org.bws.calc.tokens;

public class Token {
	
	public Token(String value) {
		this.value = value;
	}

	protected String value;

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return value;
	}
}
