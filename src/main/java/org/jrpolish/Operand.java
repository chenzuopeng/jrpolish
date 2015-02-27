package org.jrpolish;

/**
 *
 *
 * @author dylan.chen 2010-7-30
 * 
 */
public abstract class Operand implements Symbol{
	
	public SymbolType getType(){
		return SymbolType.OPERAND;
	}
	
}
