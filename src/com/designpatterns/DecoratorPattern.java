package com.designpatterns;

/**
 * Decorator design pattern (S)
 * 
 * Decorator design pattern is used to enhance the functionality of a particular
 * object at run-time or dynamically. · At the same time other instance of same
 * class will not be affected by this so individual object gets the new
 * behavior. · Basically we wrap the original object through decorator object. ·
 * Decorator design pattern is based on abstract classes and we derive concrete
 * implementation from those classes, · It’s a structural design pattern and
 * most widely used.
 * 
 * Use When Object responsibilities and behaviors should be dynamically
 * modifiable. Concrete implementations should be decoupled from
 * responsibilities and behaviors. Subclassing to achieve modification is
 * impractical or impossible. Specific functionality should not reside high in
 * the object hierarchy. A lot of little objects surrounding a concrete
 * implementation is acceptable.
 * 
 * Example Many businesses set up their mail systems to take advantage of
 * decorators. When messages are sent from someone in the company to an external
 * address the mail server decorates the original message with copyright and
 * confidentiality information. As long as the message remains internal the
 * information is not attached. This decoration allows the message itself to
 * remain unchanged until a runtime decision is made to wrap the message with
 * additional information.
 */
public class DecoratorPattern {
	public static void main(String[] args) {

		// without adding decorators
		Currency curr = new Dollar();
		System.out.println(curr.getDescription() + ". " + curr.cost(2.0));

		// adding decorators
		Currency curr2 = new USDDecorator(new Dollar());
		System.out.println(curr2.getDescription() + " dollar. " + curr2.cost(64.0));

		Currency curr3 = new SGDDecorator(new Dollar());
		System.out.println(curr3.getDescription() + " dollar. " + curr3.cost(44.0));
	}
}

abstract class Currency {
	String description = "Unknown currency";

	public String getDescription() {
		return description;
	}

	public abstract double cost(double value);

}

// Concrete Component
class Dollar extends Currency {
	double value;

	public Dollar() {
		description = "Default Dollar";
	}

	public double cost(double v) {
		value = v;

		return value;

	}

}

/*class Rupee extends Currency {
	double value;

	public Rupee() {
		description = "indian rupees";
	}

	public double cost(double v) {
		value = v;
		return value;
	}

}*/



// Decorator
abstract class Decorator extends Currency {

	public abstract String getDescription();

}

// Concrete Decorator
class USDDecorator extends Decorator {

	Currency currency;

	public USDDecorator(Currency currency) {
		this.currency = currency;
	}

	public String getDescription() {
		return "USD";
	}

	@Override
	public double cost(double value) {
		return currency.cost(value);
	}

}

// Another Concrete Decorator

class SGDDecorator extends Decorator {
	Currency currency;

	public SGDDecorator(Currency currency) {
		this.currency = currency;
	}

	public String getDescription() {
		return "SGD";
	}

	@Override
	public double cost(double value) {
		return currency.cost(value);
	}

}
