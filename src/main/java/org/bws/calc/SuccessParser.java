package org.bws.calc;

import java.util.List;
import java.util.ListIterator;

import org.bws.calc.exception.ParseException;
import org.bws.calc.expression.Expression;
import org.bws.calc.expression.ValueExpression;
import org.bws.calc.tokens.OpToken;
import org.bws.calc.tokens.Token;

/**
 * 
 * EXPRESSION = BINARY_EXPRESSION | TERM
 * BINARY_EXPRESSION = EXPRESSION "+"/"-" TERM
 * TERM = VALUE_EXPRESSION |
 *     PARENTHESIZED_EXPRESSION
 * VALUE_EXPRESSION = number
 * PARENTHESIZED_EXPRESSION = "(" EXPRESSION ")"
 * 
 *
 */
public class SuccessParser implements Parser{
	
	public Expression parse(List<Token> tokens) {
        ListIterator<Token> tokenIter = tokens.listIterator();
        Expression expr = parseExpression(tokenIter);
        if (tokenIter.hasNext()) {
            throw new ParseException("Extra text after expression: " + tokenIter.next().getValue());
        }
        return expr;
    }

    private Expression parseExpression(ListIterator<Token> tokenIter) {
        if (!tokenIter.hasNext()) {
            throw new ParseException("Premature end of expression");
        }

        Expression expr = parseTerm(tokenIter);
        while (tokenIter.hasNext()) {
            Token op = tokenIter.next();
            if (op instanceof OpToken) {
                expr = parseBinaryExpression(expr, (OpToken)op, tokenIter);
            } else {
                tokenIter.previous();
                break;
            }
        }
        return expr;
    }

    private Expression parseBinaryExpression(Expression leftExpr, OpToken op, ListIterator<Token> tokenIter) {
        return op.toExpression(leftExpr, parseTerm(tokenIter));
    }

    private Expression parseTerm(ListIterator<Token> tokenIter) {
        Token t = tokenIter.next();
        if ("(".equals(t.getValue())) {
            return parseParenthesizedExpression(tokenIter);
        } else {
            return parseValueExpression(t);
        }
    }

    private Expression parseValueExpression(Token t) {
        try {
            int intVal = Integer.parseInt(t.getValue());
            return new ValueExpression(intVal);
        } catch (NumberFormatException nfe) {
            throw new ParseException("expected int but found: " + t.getValue());
        }
    }

    private Expression parseParenthesizedExpression(ListIterator<Token> tokenIter) {
        Expression innerExpr = parseExpression(tokenIter);
        if (!tokenIter.hasNext() || !")".equals(tokenIter.next().getValue())) {
            throw new ParseException("Missing right parenthesis");
        }
        return innerExpr;
    }
}
