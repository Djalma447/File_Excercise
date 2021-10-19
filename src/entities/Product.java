package entities;

public class Product {

	private String name;
	private Double price;
	private Integer unity;
	
	public Product(String name, Double price, Integer unity) {
		this.name = name;
		this.price = price;
		this.unity = unity;
	}

	public String getName() {
		return name;
	}

	public Double getPrice() {
		return price;
	}

	public Integer getUnity() {
		return unity;
	}
	
	public Double total() {
		return price * unity;
	}
}
