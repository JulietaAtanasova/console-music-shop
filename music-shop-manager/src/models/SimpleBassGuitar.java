package models;

import interfaces.BassGuitar;

public class SimpleBassGuitar extends SimpleGuitar implements BassGuitar {

	private static final int NUMBER_OF_STRINGS = 4;

	public SimpleBassGuitar(String make, String model, double price, String color,
			String bodyWood, String fingerBoardWood) {
		super(make, model, price, color, true, bodyWood, fingerBoardWood, NUMBER_OF_STRINGS);
	}

}
