package org.jrpolish;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * 
 * @author dylan.chen 2010-7-30
 * 
 */
public class ReversePolishTranslator {
	
	private static Logger logger=LoggerFactory.getLogger(ReversePolishTranslator.class);

	private List<Symbol> reversePolishExpression = new ArrayList<Symbol>();

	private Stack<Operator> operatorStack = new Stack<Operator>();

	public Symbol[] translate(Symbol[] symbols) {
		for (Symbol symbol : symbols) {
			if (SymbolType.OPERAND == symbol.getType()) {
				this.reversePolishExpression.add(symbol);
			} else {
				doOperator((Operator) symbol);
			}
			logger.debug("Symbol:{}", symbol.toString());
			logger.debug("operatorStack:{}", operatorStack);
			logger.debug("reversePolishExpression:{}", reversePolishExpression);
		}
		while (!this.operatorStack.isEmpty()){
			this.reversePolishExpression.add(this.operatorStack.pop());
		};
		logger.debug("final reversePolishExpression:{}",reversePolishExpression);
		return this.reversePolishExpression.toArray(new Symbol[0]);
	}

	private void doOperator(Operator currentOperator) {
		if (this.operatorStack.isEmpty()) {
			this.operatorStack.push(currentOperator);
			return;
		}
		Operator topStackOperator = this.operatorStack.peek();
		if (topStackOperator.getISP() > currentOperator.getICP()) {
			this.reversePolishExpression.add(this.operatorStack.pop());
			doOperator(currentOperator);
		} else if (topStackOperator.getISP() == currentOperator.getICP()) {
			this.operatorStack.pop();
		} else {
			this.operatorStack.push(currentOperator);
		}
	}
    
}
