package test;

import junit.framework.TestCase;
import domini.Product;
import domini.ProductNotFoundException;
import domini.ShoppingCart;


public class ShoppingCartTest extends TestCase  {
		
	private ShoppingCart _bookCart;
	private Product _defaultBook;



	public ShoppingCartTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		_bookCart = new ShoppingCart ();
		_defaultBook = new Product ("Extreme Programming", 23.95);
		_bookCart.addItem (_defaultBook);

	}

	protected void tearDown() throws Exception {
		_bookCart = null;
	}

	public void testEmpty () {

	_bookCart.empty ();
	assertTrue (_bookCart.isEmpty ());
	} 
	
	public void testProductAdd () {
		Product newBook = new Product ("Refactoring", 53.95);
		_bookCart.addItem (newBook);

		double expectedBalance = _defaultBook.getPrice () + newBook.getPrice ();
		assertEquals (expectedBalance, _bookCart.getBalance (), 0.0);

		assertEquals (2, _bookCart.getItemCount ());
		} 

}
