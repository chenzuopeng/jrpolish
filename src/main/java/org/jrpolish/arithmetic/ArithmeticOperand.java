package org.jrpolish.arithmetic;

import org.jrpolish.Operand;

/**
 *
 *
 * @author dylan.chen 2010-7-30
 * 
 */
public class ArithmeticOperand extends Operand {

	private double value;
	
	public ArithmeticOperand(double value){
		this.value=value;
	}
	
	public double getValue(){
		return this.value;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(value);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArithmeticOperand other = (ArithmeticOperand) obj;
		if (Double.doubleToLongBits(value) != Double.doubleToLongBits(other.value))
			return false;
		return true;
	}

	public String toString() {
		return Double.toString(this.value);
	}
}
