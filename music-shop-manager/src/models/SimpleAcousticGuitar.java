package models;

import interfaces.AcousticGuitar;

public class SimpleAcousticGuitar extends SimpleGuitar implements AcousticGuitar {

	private static final int NUMBER_OF_STRINGS = 6;

	private boolean caseIncluded;
	private StringMaterial stringMaterial;

	public SimpleAcousticGuitar(String make, String model, double price, String color, String bodyWood,
			String fingerBoardWood, boolean caseIncluded, StringMaterial stringMaterial) {
		super(make, model, price, color, false, bodyWood, fingerBoardWood, NUMBER_OF_STRINGS);
		this.setCaseIncluded(caseIncluded);
		this.setStringMaterial(stringMaterial);
	}

	@Override
	public boolean isCaseIncuded() {
		return this.caseIncluded;
	}

	private void setCaseIncluded(boolean caseIncluded) {
		this.caseIncluded = caseIncluded;
	}

	@Override
	public StringMaterial getStringMaterial() {
		return this.stringMaterial;
	}

	private void setStringMaterial(StringMaterial stringMaterial) {
		this.stringMaterial = stringMaterial;
	}

	@Override
	public String toString() {
		String caseString = this.isCaseIncuded() ? "yes" : "no";
		return super.toString()
				+ String.format("Case included: %s\nString material: %s\n", caseString, this.getStringMaterial());
	}
}
