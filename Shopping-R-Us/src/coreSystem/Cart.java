// Cart contains the list of all products that have been scanner by the user.

package coreSystem;

import java.util.ArrayList;

import Product.Product;

public class Cart {
	
	public static ArrayList<Product> checkoutProducts = new ArrayList<>();


	public void addItem(Product product) {
		// TODO Auto-generated method stub
		checkoutProducts.add(product);
	}


	public float getTotal() {
		float total_amt  =0;
		for (Product p: checkoutProducts ) {
			total_amt += p.getPrice();
		}
		return total_amt;
	}

	public int totalByType(String str) {
		int total = 0;
		for (Product p : checkoutProducts) {
			if(p.getSKU().equals(str)) {
				total+=1;
			}
		}
		return total;
	}
	
}
