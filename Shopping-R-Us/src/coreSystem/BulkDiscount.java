// This rule will give you the option to get discounted price on purchase of 4 or more ipad 
package coreSystem;

public class BulkDiscount implements rules{

	private int min_ammount = 4;
	private float discount_price = 499;
	
	public int getAmmount() {
		return this.min_ammount;
	}
	
	public float getDiscountPrice() {
		return this.discount_price;
	}

	@Override
	public void ApplyRules(Cart cart) {

		
		int number_ipad= cart.totalByType("ipd");
		if (number_ipad>= this.min_ammount) {
			for (int i=0 ; i< Cart.checkoutProducts.size() ; i++) {
				if (Cart.checkoutProducts.get(i).getSKU().equals("ipd")) {
					Cart.checkoutProducts.get(i).setPrice((float)499.99);
				}
				

			}
		}
	}

}
