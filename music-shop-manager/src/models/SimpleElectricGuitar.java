package models;

import interfaces.ElectricGuitar;

public class SimpleElectricGuitar extends SimpleGuitar implements ElectricGuitar {

	private static final int NUMBER_OF_STRINGS = 6;

	private int numberOfAdapters;
	private int numberOfFrets;

	public SimpleElectricGuitar(String make, String model, double price, String color, String bodyWood,
			String fingerBoardWood, int numberOfAdapters, int numberOfFrets) {
		super(make, model, price, color, true, bodyWood, fingerBoardWood, NUMBER_OF_STRINGS);
		this.setNumberOfAdapters(numberOfAdapters);
		this.setNumberOfFrets(numberOfFrets);
	}

	@Override
	public int getNumberOfAdapters() {
		return this.numberOfAdapters;
	}

	private void setNumberOfAdapters(int numberOfAdapters) {
		this.numberOfAdapters = numberOfAdapters;
	}

	@Override
	public int getNumberOfFrets() {
		return this.numberOfFrets;
	}

	private void setNumberOfFrets(int numberOfFrets) {
		this.numberOfFrets = numberOfFrets;
	}

	@Override
	public String toString() {
		return super.toString()
				+ String.format("Adapters: %s\nFrets: %s\n", this.getNumberOfAdapters(), this.getNumberOfFrets());
	}
}
