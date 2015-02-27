package org.jrpolish;

/**
 *
 * 表达式解析器,用于将表达式的各个元素解析出来(即将操作数和操作符解析出来).
 * 
 * @author dylan.chen 2010-7-30
 * 
 */
public interface ExpressionResolver {

	public Symbol[] resolve(String exp);
}
