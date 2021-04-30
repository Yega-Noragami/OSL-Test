// This rule will entitle you to get 3 apple TV for the price of 2 

package coreSystem;

import java.util.ArrayList;

import Product.Product;

public class AppleTv implements rules  {
 
	//the amount can be changed based on any ambient 
	private int ammount=3;
	
	public int getAmmount() {
		return this.ammount;
	}
		
	@Override
	public void ApplyRules(Cart cart) {
		ArrayList<Product> tempProduct = new ArrayList<>();

		tempProduct = Cart.checkoutProducts; 
		int ctr=0;
		for (int i=0 ; i< tempProduct.size() ; i++) {
			
			if (tempProduct.get(i).getSKU().equals("atv")) {
				
				if ((ctr+1)%3==0) {
					Cart.checkoutProducts.get(i).setPrice(0);
				}
				
				ctr+=1;
			}
			
		}
	}

}
