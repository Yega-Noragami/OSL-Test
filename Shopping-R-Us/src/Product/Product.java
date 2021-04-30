// This class is responsible for creating objects 
package Product;

import java.util.Objects;

public class Product {
	
	//create product 
	private  String sku;
	private  String name;
	private  float price;
	
	public Product (String sku, String name, float price){
		this.sku = sku;
		this.name = name;
		this.price = price;
	}
	
	public String getSKU(){
		return this.sku;
	}
	public String getName(){
		return this.name;
	}
	public float getPrice(){
		return this.price;
	}
	
    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) {
        	return false;
        } else if (this == object) return false;
        Product temp_product = (Product) object;
        return this.getSKU() == temp_product.getSKU();
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(getSKU());
    }
    
    public String toString() {
    	return "SKU:" + this.getSKU() +" Name:" + this.getName() + " Price:" +this.getPrice();
    }

	public void setPrice(float price2) {
		this.price=price2;
		
	}
	
}
