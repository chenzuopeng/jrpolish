package org.jrpolish;

import org.jrpolish.ReversePolishCalculator;
import org.jrpolish.Symbol;
import org.jrpolish.arithmetic.ArithmeticOperand;
import org.jrpolish.arithmetic.ArithmeticOperatorManager;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 *
 * @author dylan.chen 2010-7-31
 * 
 */
public class ReversePolishCalculatorTest {

	@Test
	public void test1(){
		ReversePolishCalculator evaluation=new ReversePolishCalculator();
		ArithmeticOperand operand=(ArithmeticOperand)evaluation.calculate(new Symbol[]{
					new ArithmeticOperand(1.0),
					new ArithmeticOperand(2.0),
					new ArithmeticOperand(3.0),
					ArithmeticOperatorManager.getOperator('-'),
					new ArithmeticOperand(4.0),
					ArithmeticOperatorManager.getOperator('*'),
					ArithmeticOperatorManager.getOperator('+'),
			});
		Assert.assertEquals(new ArithmeticOperand(-3), operand);
	}
}
