package models;

import interfaces.Article;

public abstract class SimpleArticle implements Article {
	private String make;
	private String model;
	private double price;

	protected SimpleArticle(String make, String model, double price) {
		this.setMake(make);
		this.setModel(model);
		this.setPrice(price);
	}

	@Override
	public String getMake() {
		return this.make;
	}

	private void setMake(String make) {
		this.make = make;
	}
	
	@Override
	public String getModel() {
		return this.model;
	}

	private void setModel(String model) {
		this.model = model;
	}
	
	@Override
	public double getPrice() {
		return this.price;
	}

	private void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return String.format("= %s %s =\nPrice: $%.2f\n", this.getMake(), this.getModel(), this.getPrice());
	}
}
