package firstLevelShop.products.electronicsProducts;

import firstLevelShop.additionalClasses.enums.AgeRestriction;
import firstLevelShop.products.Product;

public abstract class ElectronicsProduct extends Product {
	
	private int guaranteePeriod;
	
	public ElectronicsProduct(
			String name, 
			double price,
			double quantity,
			AgeRestriction ageRestriction) {
		
		super(name, price, quantity, ageRestriction);
	}
	
	public int getGuaranteePeriod() {
		return this.guaranteePeriod;
	}
	
	public void setGuaranteePeriod(int guaranteePeriod) {
		if (guaranteePeriod < 0) {
			throw new IllegalArgumentException("Guarantee Period can not be negative");
		}
		
		this.guaranteePeriod = guaranteePeriod;
	}
}