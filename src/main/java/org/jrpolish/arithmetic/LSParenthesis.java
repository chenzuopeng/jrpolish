package org.jrpolish.arithmetic;

import org.jrpolish.Operand;

/**
 *
 *
 * @author dylan.chen 2010-7-31
 * 
 */
public class LSParenthesis extends ArithmeticOperator {
	
	public final static char OPERATOR = '(';
	
	private final static short ICP=8;
	
	private final static short ISP=1;
	
	private final static short AMOUNT_OF_OPERAND=0;
	
	private static class Holder {
		public static LSParenthesis lsparenthesis = new LSParenthesis();
	}

	private LSParenthesis() {
	}

	public static LSParenthesis getInstance() {
		return Holder.lsparenthesis;
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
