package firstLevelShop.products;

import firstLevelShop.additionalClasses.enums.AgeRestriction;
import firstLevelShop.interfaces.Buyable;

public abstract class Product implements Buyable {
	private String name;
	private double price;
	private double quantity;
	private AgeRestriction ageRestriction;
	
	protected Product(
			String name, 
			double price,
			double quantity,
			AgeRestriction ageRestriction) {
		
		this.setName(name);
		this.setPrice(price);
		this.setQuantity(quantity);
		this.setAgeRestriction(ageRestriction);
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("Prouct name can not be null or empty");
		}
		
		this.name = name;
	}
	
	@Override
	public double getPrice() {
		return this.price;
	}
	
	public void setPrice(double price) {
		
		if (price < 0) {
			throw new IllegalArgumentException("Prouct price can not be negative");
		}
		
		this.price = price;
	}
	
	public double getQuantity() {
		return this.quantity;
	}
	
	public void setQuantity(double quantity) {
		
		if (price < 0) {
			throw new IllegalArgumentException("Prouct quantity can not be negative");
		}
		
		this.quantity = quantity;
	}
	
	public AgeRestriction getAgeRestriction() {
		return this.ageRestriction;
	}
	
	public void setAgeRestriction(AgeRestriction ageRestriction) {
		this.ageRestriction = ageRestriction;
	}
}