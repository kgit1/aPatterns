package x.Project;

import java.math.BigDecimal;

public class Product {

	private String product;
	private BigDecimal quantity;
	private BigDecimal price;

	public Product(String product, BigDecimal quantity, BigDecimal price) {
		this.product = product;
		this.quantity = quantity;
		this.price = price;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [product=" + product + ", quantity=" + quantity + ", price=" + price + "]";
	}

}

// The float and double types are particularly ill-suited for monetary
// calculations because it is impossible to represent 0.1 (or any other negative
// power of ten) as a float or double exactly.
//
// For example, suppose you have $1.03 and you spend 42c. How much money do you
// have left?
//
// System.out.println(1.03 - .42);
// prints out 0.6100000000000001.
//
// The right way to solve this problem is to use BigDecimal, int or long for
// monetary calculations.

// Because floats and doubles cannot accurately represent the base 10 multiples
// we use for money. This issue isn't just for Java, it's for any programming
// language that uses native floating-point types, as it stems from how
// computers handle floating-point numbers by default.
//
// This is how an IEEE-754 floating-point number works: it dedicates a bit for
// the sign, a few bits to store an exponent for the base, and the rest for a
// multiple of that elevated base. This leads to numbers like 10.25 being
// represented in a form similar to 1025 * 10-2; except that instead of the base
// being 10, for floats and doubles, it's two, so that would be 164 * 2-4.
// (That's still not exactly how they are represented in hardware, but this is
// simple enough and the math holds the same way.)
//
// Even in base 10, this notation cannot accurately represent most simple
// fractions. For instance, with most calculators, 1/3 results in a repeating
// 0.333333333333, with as many 3's as the digital display allows, because you
// just can't write 1/3 in decimal notation. However, for the purpose of money
// (at least for countries whose money value is within an order of magnitude of
// the US dollar), in most scenarios all you need is to be able to store
// multiples of 10-2, so we don't really care if 1/3 doesn't have an exact
// representation as an integer times a power of 10, and even the cheapest
// calculators handle cents just fine.
//
// The problem with floats and doubles is that the vast majority of money-like
// numbers don't have an exact representation as a integer times a power of two.
// In fact, the only fractions of a hundred between 0/100 and 100/100 (which are
// significant when dealing with money because they're integer cents) that can
// be represented exactly as an IEEE-754 binary floating-point number are 0,
// 0.25, 0.5, 0.75 and 1. All the others are off by a small amount.
//
// Representing money as a double or float will probably look good at first as
// the software rounds off the tiny errors, but as you perform more additions,
// subtractions, multiplications and divisions on inexact numbers, you'll lose
// more and more precision as the errors add up. This makes floats and doubles
// inadequate for dealing with money, where perfect accuracy for multiples of
// base 10 powers is required.
//
// A solution that works in just about any language is to use integers instead,
// and count cents. For instance, 1025 would be $10.25. Several languages also
// have built-in types to deal with money. Among others, Java has the BigDecimal
// class
