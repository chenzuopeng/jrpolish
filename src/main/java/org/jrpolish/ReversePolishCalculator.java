package org.jrpolish;

import java.util.Stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 *
 * @author dylan.chen 2010-7-31
 * 
 */
public class ReversePolishCalculator {
	
	private static Logger logger=LoggerFactory.getLogger(ReversePolishCalculator.class);

	private Stack<Operand> operandStack=new Stack<Operand>();
	
	public Operand calculate(Symbol[] symbols){
		for (Symbol symbol : symbols) {
			if (SymbolType.OPERAND == symbol.getType()) {
				this.operandStack.push((Operand)symbol);
				logger.debug("push:{}",symbol);
			} else {
				Operator operator=(Operator)symbol;
				logger.debug("operator:{}",operator);
				Operand resultOfCalculation=operator.calculate(getOperands(operator.getAmountOfOperand()));
				this.operandStack.push(resultOfCalculation);
				logger.debug("push:{}",resultOfCalculation);
			}
			logger.debug("operandStack:{}",this.operandStack);
		}
		if(this.operandStack.size()!=1){
			throw new RuntimeException("计算表达式错误");
		}
		return this.operandStack.pop();
	}
	
	private Operand[] getOperands(short amountOfOperand){
		if(this.operandStack.size()>=amountOfOperand){
			Operand[] operands=new Operand[amountOfOperand];
			for (int i = operands.length - 1; i >= 0; i--) {
				operands[i]=this.operandStack.pop();
				logger.debug("pop:{}",operands[i]);
			}
			return operands;
		}
		throw new RuntimeException("当前操作数栈大小:"+this.operandStack.size()+",但是期望的操作数个数:"+amountOfOperand);
	}
}
