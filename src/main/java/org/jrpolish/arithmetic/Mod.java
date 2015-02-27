package org.jrpolish.arithmetic;

import org.jrpolish.Operand;

/**
 *
 *
 * @author dylan.chen 2010-7-31
 * 
 */
public class Mod extends ArithmeticOperator {

	public final static char OPERATOR = '%';
	
	private final static short ICP=4;
	
	private final static short ISP=5;
	
	private final static short AMOUNT_OF_OPERAND=2;
	
	private static class Holder {
		public static Mod mod = new Mod();
	}

	private Mod() {
	}

	public static Mod getInstance() {
		return Holder.mod;
	}

	public Operand calculate(Operand[] operands) {
		ArithmeticOperand leftOperand = (ArithmeticOperand) operands[0];
		ArithmeticOperand rightOperand = (ArithmeticOperand) operands[1];
		return new ArithmeticOperand(leftOperand.getValue() % rightOperand.getValue());
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
