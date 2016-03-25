package firstLevelShop.products.electronicsProducts;

import firstLevelShop.additionalClasses.enums.AgeRestriction;

public class Computer extends ElectronicsProduct {
	private final int GuaranteePeriodInMonths = 24;
	private final int MinPromotionQuantity = 1000;
	
	public Computer(String name, double price, double quantity, AgeRestriction ageRestriction) {
		super(name, price, quantity, ageRestriction);
		super.setGuaranteePeriod(GuaranteePeriodInMonths);
		this.checkWaranty();
	}
	
	private void checkWaranty() {
		if (super.getQuantity() > MinPromotionQuantity) {
			double newPrice = super.getPrice() * 0.95;			
			super.setPrice(newPrice);
		}
	}
}