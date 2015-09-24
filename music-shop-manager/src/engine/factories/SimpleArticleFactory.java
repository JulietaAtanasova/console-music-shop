package engine.factories;

import interfaces.AcousticGuitar;
import interfaces.BassGuitar;
import interfaces.Drums;
import interfaces.ElectricGuitar;
import interfaces.Microphone;
import interfaces.engine.ArticleFactory;
import models.SimpleAcousticGuitar;
import models.SimpleBassGuitar;
import models.SimpleDrums;
import models.SimpleElectricGuitar;
import models.SimpleMicrophone;
import models.StringMaterial;

public class SimpleArticleFactory implements ArticleFactory {

	@Override
	public Microphone createMirophone(String make, String model, double price, boolean hasCable) {
		return new SimpleMicrophone(make, model, price, hasCable);
	}

	@Override
	public Drums createDrums(String make, String model, double price, String color, int width, int height) {
		return new SimpleDrums(make, model, price, color, width, height);
	}

	@Override
	public ElectricGuitar createElectricGuitar(String make, String model, double price, String color, String bodyWood,
			String fingerboardWood, int numberOfAdapters, int numberOfFrets) {
		return new SimpleElectricGuitar(make, model, price, color, bodyWood, fingerboardWood, numberOfAdapters,
				numberOfFrets);
	}

	@Override
	public AcousticGuitar createAcousticGuitar(String make, String model, double price, String color, String bodyWood,
			String fingerboardWood, boolean caseIncluded, StringMaterial stringMaterial) {
		return new SimpleAcousticGuitar(make, model, price, color, bodyWood, fingerboardWood, caseIncluded,
				stringMaterial);
	}

	@Override
	public BassGuitar createBassGuitar(String make, String model, double price, String color, String bodyWood,
			String fingerboardWood) {
		return new SimpleBassGuitar(make, model, price, color, bodyWood, fingerboardWood);
	}

}
