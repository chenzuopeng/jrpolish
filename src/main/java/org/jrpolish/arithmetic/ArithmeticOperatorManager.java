package org.jrpolish.arithmetic;

import java.util.Hashtable;

import org.apache.commons.lang.ArrayUtils;
import org.jrpolish.Operator;

/**
 *
 *
 * @author dylan.chen 2010-7-31
 * 
 */
public final class ArithmeticOperatorManager {
	
	private static Hashtable<Character, Operator> registry;
	
	private static char[] operators;

	private ArithmeticOperatorManager(){
	}
	
	static{
		registry=new Hashtable<Character, Operator>();
		registry.put(Plus.OPERATOR,Plus.getInstance());
		registry.put(Minus.OPERATOR,Minus.getInstance());
		registry.put(Mult.OPERATOR,Mult.getInstance());
		registry.put(Div.OPERATOR,Div.getInstance());
		registry.put(Mod.OPERATOR,Mod.getInstance());
		registry.put(LSParenthesis.OPERATOR,LSParenthesis.getInstance());
		registry.put(RSParenthesis.OPERATOR,RSParenthesis.getInstance());
		
		operators=ArrayUtils.toPrimitive(registry.keySet().toArray(new Character[0]));
	}
	
	public static boolean isOperator(char operator){
		return ArrayUtils.contains(operators,operator);
	}
	
	public static Operator getOperator(char operator){
		return registry.get(operator);
	}
}
