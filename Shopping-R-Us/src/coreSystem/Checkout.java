// ->Checkout system is used for scanning and reading the items which will be added to an Cart 
// ->allProducts has a list of products which are available. 

// FOR TESTING PURPOSES YOU CAN UN-COMMENT THE TESTING REGION CODE 
// input type: (atv,atv,atv) , (atv,ipd,ipd,ipd,mbp) , etc..
package coreSystem;

import java.io.IOException;
import java.nio.*;
import java.nio.file.*;
import java.util.ArrayList;
import Product.Product;

import java.util.*;

public class Checkout {
	
	// list of unique products 
	private static ArrayList<Product> allProducts = new ArrayList<>();
	
	// This is the cart 
	static Cart newCart = new Cart();
	
	//MAP the product to the rule 
	public static Map<Product , rules> rule= new HashMap<>();
	
	public Checkout (Map<Product , rules> newRule) {
		rule = newRule;
	}
//	------ This is used to read the product list from a text file and create a list of all products 
	
	public static void main(String... args) throws IOException {
		System.out.println("Hello to Shopping-R-Us");
		
		Path list_path = Paths.get("src","coreSystem","itemlist.txt");

		ArrayList<String> readingFiles = (ArrayList<String>) Files.readAllLines(list_path);
		
		for (String x : readingFiles) {
			x.trim();
			String[] temp = x.split(",");
			float f = Float.parseFloat(temp[2]);
			Product temp_product = new Product(temp[0],temp[1],f);
			allProducts.add(temp_product);
		}

		
//		----- add rules 
		
		rule.put(new Product("ipd","Super iPad",(float) 549.99), new BulkDiscount());
		rule.put(new Product("mbp","MacBook Pro iPad",(float) 1399.99), new FreeVGA());
		rule.put(new Product("atv","Apple TV",(float) 109.50), new AppleTv());
		
		
/*
//		 ----- how to test this out 
		Scanner in = new Scanner(System.in);
		
		
		System.out.println("SKUs Scanned:");
		String getInput = in.nextLine();
		
		String[] allItems = getInput.split(",");

		for ( String items : allItems) {
			if (items.equals("ipd")) {
				//add product 
				
				Product temp = new Product("ipd","Super iPad",(float) 549.99);
				newCart.addItem(temp);
				rules applyRule =  rule.get(temp);
				if(rule != null) {
					applyRule.ApplyRules(newCart);
				}
				
			}
			else if (items.equals("mbp")) {
				//add product 
				
				Product temp = new Product("mbp","MacBook Pro iPad",(float) 1399.99);
				newCart.addItem(temp);
				rules applyRule =  rule.get(temp);
				if(rule != null) {
					applyRule.ApplyRules(newCart);
				}
			}		
			else if (items.equals("atv")) {
				//add product 
				Product temp = new Product("atv","Apple TV",(float) 109.50);
				newCart.addItem(temp);
				rules applyRule =  rule.get(temp);
				if(rule != null) {
					applyRule.ApplyRules(newCart);
				}
			}
			else if (items.equals("vga")) {
				//add product
				Product temp = new Product("vga","VGA adapter",(float) 30.00);
				newCart.addItem(temp);			
			}
		}
		
		System.out.println("Total expected: $"+newCart.getTotal() );
		
		in.close();	
*/
	}
	
	// scan and add product and check with the rule if you need to apply any rule
	public void scan(Product product) {
		if(product == null) {
			System.out.print("Product does not exist");
		}
		
		if (allProducts.contains(product)) {
			newCart.addItem(product);
		}
		rules applyRule =  rule.get(product);
		if(rule != null) {
			applyRule.ApplyRules(newCart);
		}
	}
	
	// return the total bill 
	public float total() {
		return newCart.getTotal();
	}

}
