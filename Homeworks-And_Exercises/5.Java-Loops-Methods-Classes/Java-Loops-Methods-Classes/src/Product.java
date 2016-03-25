import java.math.BigDecimal;
import java.text.DecimalFormat;


public class Product {
	private String name;
	
	private BigDecimal price;

	public Product(String name, BigDecimal price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name.isEmpty()){
			throw new IllegalArgumentException("Product name should not be empty!");
		}
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return String.format("%.2f %s\n", this.price, this.name);
	}
}
