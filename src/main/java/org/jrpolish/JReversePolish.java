package org.jrpolish;

/**
 *
 *
 * @author dylan.chen 2010-8-1
 * 
 */
public class JReversePolish {

	private ExpressionResolver expressionResolver;
	
	private ReversePolishCalculator reversePolishCalculator;
	
	private ReversePolishTranslator reversePolishTranslator;
	
	public JReversePolish(ExpressionResolver expressionResolver){
		this.expressionResolver=expressionResolver;
		this.reversePolishCalculator=new ReversePolishCalculator();
		this.reversePolishTranslator=new ReversePolishTranslator();
	}
	
	@SuppressWarnings("unchecked")
	public <T extends Operand> T calculate(String exp){
		Symbol[] originalSymbols=this.expressionResolver.resolve(exp);
		Symbol[] reversePolishSymbols=this.reversePolishTranslator.translate(originalSymbols);
		return (T)this.reversePolishCalculator.calculate(reversePolishSymbols);
	}
}
