package models;

import interfaces.Guitar;

public abstract class SimpleGuitar extends MusicalInstrument implements Guitar {

	private String bodyWood;
	private String fingerBoardWood;
	private int numberOfStrings;

	protected SimpleGuitar(String make, String model, double price, String color, boolean electronic, String bodyWood,
			String fingerBoardWood, int numberOfStrings) {
		super(make, model, price, color, electronic);
		this.setBodyWood(bodyWood);
		this.setFingerBoardWood(fingerBoardWood);
		this.setNumberOfStrings(numberOfStrings);
	}

	@Override
	public String getBodyWood() {
		return this.bodyWood;
	}

	private void setBodyWood(String bodyWood) {
		this.bodyWood = bodyWood;
	}

	@Override
	public String getFingerBoardWood() {
		return this.fingerBoardWood;
	}

	private void setFingerBoardWood(String fingerBoardWood) {
		this.fingerBoardWood = fingerBoardWood;
	}

	@Override
	public int getNumberOfStrings() {
		return this.numberOfStrings;
	}

	private void setNumberOfStrings(int numberOfStrings) {
		this.numberOfStrings = numberOfStrings;
	}

	@Override
	public String toString() {
		return super.toString() + String.format("Strings: %s\nBody wood: %s\nFingerboard wood: %s\n",
				this.getNumberOfStrings(), this.getBodyWood(), this.getFingerBoardWood());
	}
}
