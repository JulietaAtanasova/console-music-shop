package models;

import interfaces.Instrument;

public abstract class MusicalInstrument extends SimpleArticle implements Instrument {

	private String color;
	private boolean electronic;

	protected MusicalInstrument(String make, String model, double price, String color, boolean electronic) {
		super(make, model, price);
		this.setColor(color);
		this.setElectronic(electronic);
	}

	@Override
	public String getColor() {
		return this.color;
	}

	private void setColor(String color) {
		this.color = color;
	}

	@Override
	public boolean isElectronic() {
		return this.electronic;
	}

	private void setElectronic(boolean electronic) {
		this.electronic = electronic;
	}

	@Override
	public String toString() {
		String electronicString = this.isElectronic() ? "yes" : "no";
		return super.toString() + String.format("Color: %s\nElectronic: %s\n", this.getColor(), electronicString);
	}
}
