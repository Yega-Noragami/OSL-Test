package coreSystem;

import java.util.ArrayList;

import Product.Product;

public class FreeVGA implements rules {

	@Override
	public void ApplyRules(Cart cart) {
		ArrayList<Product> new_temp_checkout = Cart.checkoutProducts;
		for(int i=0 ; i< Cart.checkoutProducts.size() ; i++) {
			if (new_temp_checkout.get(i).getSKU().equals("mbp")) {
				Product temp = new Product("vga","VGA adapter",0);
				Cart.checkoutProducts.add(temp);
			}
		}
		
	}

}
