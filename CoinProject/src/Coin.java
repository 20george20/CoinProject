/**
 * @version 1/31/19
 * @author 20george
 * This is the parent class coin to all the types of coins
 */
public abstract class Coin {
	public abstract double getValue();
	
	public abstract String getName();
	
/**
 * if the object is a penny return pennies but if not it 
 * adds an s onto the object's singular name
 * @return a string of the plural name of the coin object
 */
	public String getPluralName() {
		if(this instanceof Penny)
			return "pennies";
		else
			return getName() + "s";
				
		}
/**
 * @param an object
 * @return true if the object is a coin an if it is equal to 
 * any of the coin values
 */
	public boolean equals(Object other) {
		if(other instanceof Coin) {
			Coin temp = (Coin)other;
			if(temp.getValue() == .01 && this instanceof Penny)
				return true;
			if(temp.getValue() == .05 && this instanceof Nickel)
				return true;
			if(temp.getValue() == .10 && this instanceof Dime)
				return true;
			if(temp.getValue() == .25 && this instanceof Quarter)
				return true;
			if(temp.getValue() == .50 && this instanceof HalfDollar)
				return true;
			if(temp.getValue() == 1.00 && this instanceof Dollar)
				return true;
		}
		return false;
	}
}
