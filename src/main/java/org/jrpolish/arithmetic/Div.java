package org.jrpolish.arithmetic;

import org.jrpolish.Operand;

/**
 *
 *
 * @author dylan.chen 2010-7-31
 * 
 */
public class Div extends ArithmeticOperator {
	
	public final static char OPERATOR = '/';
	
	private final static short ICP=4;
	
	private final static short ISP=5;
	
	private final static short AMOUNT_OF_OPERAND=2;
	
	private static class Holder {
		public static Div div = new Div();
	}

	private Div() {
	}

	public static Div getInstance() {
		return Holder.div;
	}

	public Operand calculate(Operand[] operands) {
		ArithmeticOperand leftOperand = (ArithmeticOperand) operands[0];
		ArithmeticOperand rightOperand = (ArithmeticOperand) operands[1];
		return new ArithmeticOperand(leftOperand.getValue() / rightOperand.getValue());
	}

	@Override
	public short getAmountOfOperand() {
		return AMOUNT_OF_OPERAND;
	}

	@Override
	public short getICP() {
		return ICP;
	}

	@Override
	public short getISP() {
		return ISP;
	}

	@Override
	public String toString() {
		return Character.toString(OPERATOR);
	}
}
