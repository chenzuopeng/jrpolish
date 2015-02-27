package org.jrpolish.arithmetic;

import org.jrpolish.Operand;

/**
 *
 *
 * @author dylan.chen 2010-7-31
 * 
 */
public class RSParenthesis extends ArithmeticOperator {

public final static char OPERATOR = ')';
	
	private final static short ICP=1;
	
	private final static short ISP=8;
	
	private final static short AMOUNT_OF_OPERAND=0;
	
	private static class Holder {
		public static RSParenthesis rsparenthesis = new RSParenthesis();
	}

	private RSParenthesis() {
	}

	public static RSParenthesis getInstance() {
		return Holder.rsparenthesis;
	}

	@Override
	public Operand calculate(Operand[] operands) {
		return null;
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
