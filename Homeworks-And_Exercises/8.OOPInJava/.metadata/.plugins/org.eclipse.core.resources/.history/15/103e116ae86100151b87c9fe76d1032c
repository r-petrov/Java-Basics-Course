package firstLevelShop.products.electronicsProducts;

import firstLevelShop.additionalClasses.enums.AgeRestriction;

public class Appliance extends ElectronicsProduct {
	private final int GuaranteePeriodInMonths = 6;
	private final int MinPromotionQuantity = 50;
	
	public Appliance(String name, double price, double quantity, AgeRestriction ageRestriction) {
		super(name, price, quantity, ageRestriction);
		super.setGuaranteePeriod(GuaranteePeriodInMonths);
		this.checkWaranty();
	}
	
	private void checkWaranty() {
		if (super.getQuantity() < MinPromotionQuantity) {
			double newPrice = super.getPrice() * 1.05;		
			super.setPrice(newPrice);
		}
	}
}