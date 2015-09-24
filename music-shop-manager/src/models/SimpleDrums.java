package models;

import interfaces.Drums;

public class SimpleDrums extends MusicalInstrument implements Drums {

	private int width;
	private int height;

	public SimpleDrums(String make, String model, double price, String color, int width, int height) {
		super(make, model, price, color, false);
		this.setWidth(width);
		this.setHeight(height);
	}

	@Override
	public int getWidth() {
		return this.width;
	}

	private void setWidth(int width) {
		this.width = width;
	}

	@Override
	public int getHeight() {
		return this.height;
	}

	private void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return super.toString() + String.format("Size: %scm x %scm\n", this.getWidth(), this.getHeight());
	}
}
