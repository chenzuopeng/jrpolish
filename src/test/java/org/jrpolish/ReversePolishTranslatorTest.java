package org.jrpolish;

import org.jrpolish.ReversePolishTranslator;
import org.jrpolish.Symbol;
import org.jrpolish.arithmetic.ArithmeticExpressionResolver;
import org.jrpolish.arithmetic.ArithmeticOperand;
import org.jrpolish.arithmetic.ArithmeticOperatorManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 *
 * @Copyright: Copyright (c) 2008 FFCS All Rights Reserved 
 * @Company: 北京福富软件有限公司 
 * @author 陈作朋 2010-7-31
 * @version 1.00.00
 * @history:
 * 
 */
public class ReversePolishTranslatorTest {
	
	private ArithmeticExpressionResolver expressionResolver;
	
	private ReversePolishTranslator translator=new ReversePolishTranslator();
	
	@Before
	public void init(){
		expressionResolver=new ArithmeticExpressionResolver();
	}

	@Test
	public void test1(){
			Symbol[] symbols=translator.translate(expressionResolver.resolve("1+(2-3)*4"));
			Assert.assertArrayEquals(new Symbol[]{
					new ArithmeticOperand(1.0),
					new ArithmeticOperand(2.0),
					new ArithmeticOperand(3.0),
					ArithmeticOperatorManager.getOperator('-'),
					new ArithmeticOperand(4.0),
					ArithmeticOperatorManager.getOperator('*'),
					ArithmeticOperatorManager.getOperator('+'),
			}, symbols);
	}
	
	@Test
	public void test2(){
			Symbol[] symbols=translator.translate(expressionResolver.resolve("1+2*(3-4)"));
			Assert.assertArrayEquals(new Symbol[]{
					new ArithmeticOperand(1.0),
					new ArithmeticOperand(2.0),
					new ArithmeticOperand(3.0),
					new ArithmeticOperand(4.0),
					ArithmeticOperatorManager.getOperator('-'),
					ArithmeticOperatorManager.getOperator('*'),
					ArithmeticOperatorManager.getOperator('+'),
			}, symbols);
	}
	
	@Test
	public void test3(){
			Symbol[] symbols=translator.translate(expressionResolver.resolve("1+(2-3)"));
			Assert.assertArrayEquals(new Symbol[]{
					new ArithmeticOperand(1.0),
					new ArithmeticOperand(2.0),
					new ArithmeticOperand(3.0),
					ArithmeticOperatorManager.getOperator('-'),
					ArithmeticOperatorManager.getOperator('+'),
			}, symbols);
	}
	
	@Test
	public void test4(){
			Symbol[] symbols=translator.translate(expressionResolver.resolve("1/2"));
			Assert.assertArrayEquals(new Symbol[]{
					new ArithmeticOperand(1.0),
					new ArithmeticOperand(2.0),
					ArithmeticOperatorManager.getOperator('/'),
			}, symbols);
	}
	
	@Test
	public void test5(){
			Symbol[] symbols=translator.translate(expressionResolver.resolve("1%2"));
			Assert.assertArrayEquals(new Symbol[]{
					new ArithmeticOperand(1.0),
					new ArithmeticOperand(2.0),
					ArithmeticOperatorManager.getOperator('%'),
			}, symbols);
	}
	
	@Test
	public void test6(){
			Symbol[] symbols=translator.translate(expressionResolver.resolve("1+(2-3)*4/(5-6)%7"));
			Assert.assertArrayEquals(new Symbol[]{
					new ArithmeticOperand(1.0),
					new ArithmeticOperand(2.0),
					new ArithmeticOperand(3.0),
					ArithmeticOperatorManager.getOperator('-'),
					new ArithmeticOperand(4.0),
					ArithmeticOperatorManager.getOperator('*'),
					new ArithmeticOperand(5.0),
					new ArithmeticOperand(6.0),
					ArithmeticOperatorManager.getOperator('-'),
					ArithmeticOperatorManager.getOperator('/'),
					new ArithmeticOperand(7.0),
					ArithmeticOperatorManager.getOperator('%'),
					ArithmeticOperatorManager.getOperator('+'),
			}, symbols);
	}
}
