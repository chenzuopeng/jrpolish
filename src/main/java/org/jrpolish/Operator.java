package org.jrpolish;

/**
 *
 *
 * @Copyright: Copyright (c) 2008 FFCS All Rights Reserved 
 * @Company: 北京福富软件有限公司 
 * @author 陈作朋 2010-7-30
 * @version 1.00.00
 * @history:
 * 
 */
public abstract class Operator implements Symbol{
	
	public SymbolType getType(){
		return SymbolType.OPERATOR;
	}

	/**
	 * 获取栈内优先级
	 */
	public abstract short getISP();
	
	/**
	 * 获取栈外优先级
	 */
	public abstract short getICP();
	
	/**
	 * 执行运算
	 * @param operands 操作数
	 * @return
	 */
	public abstract Operand calculate(Operand[] operands);
	
	/**
	 * 获取操作数的个数
	 * @return
	 */
	public abstract short getAmountOfOperand();
	
}
