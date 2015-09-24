package models;

import interfaces.Microphone;

public class SimpleMicrophone extends SimpleArticle implements Microphone {

	boolean cable;

	public SimpleMicrophone(String make, String model, double price, boolean cable) {
		super(make, model, price);
		this.setCable(cable);
	}

	@Override
	public boolean hasCable() {
		return this.cable;
	}

	private void setCable(boolean cable) {
		this.cable = cable;
	}

	@Override
	public String toString() {
		String cableString = this.cable ? "yes" : "no";
		return super.toString() + String.format("Cable: %s\n", cableString);
	}
}
