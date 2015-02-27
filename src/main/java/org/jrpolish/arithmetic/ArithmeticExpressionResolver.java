package org.jrpolish.arithmetic;

import java.util.ArrayList;

import org.jrpolish.ExpressionResolver;
import org.jrpolish.Symbol;

/**
 *
 *
 * @author dylan.chen 2010-7-30
 * 
 */
public class ArithmeticExpressionResolver implements ExpressionResolver {
	
	public Symbol[] resolve(String exp) {
		StringBuilder operand=new StringBuilder();
		ArrayList<Symbol> result=new ArrayList<Symbol>();
		char[] chars=exp.toCharArray();
		for (char _char : chars) {
			if(!ArithmeticOperatorManager.isOperator(_char)){
				operand.append(_char);
			}else{
				if(operand.length()>0){
					result.add(new ArithmeticOperand(Double.valueOf(operand.toString())));
				}
				result.add(ArithmeticOperatorManager.getOperator(_char));
				operand.delete(0,operand.length());
			}
		}
		if(operand.length()>0){
			result.add(new ArithmeticOperand(Double.valueOf(operand.toString())));
		}
        return result.toArray(new Symbol[0]);
	}

}
