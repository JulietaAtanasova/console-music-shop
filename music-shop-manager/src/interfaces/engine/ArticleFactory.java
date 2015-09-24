package interfaces.engine;

import interfaces.AcousticGuitar;
import interfaces.BassGuitar;
import interfaces.Drums;
import interfaces.ElectricGuitar;
import interfaces.Microphone;
import models.StringMaterial;

public interface ArticleFactory {
	Microphone createMirophone(String make, String model, double price, boolean hasCable);

    Drums createDrums(String make, String model, double price, String color, int width, int height);

    ElectricGuitar createElectricGuitar(String make, String model, double price, String color,
    		String bodyWood, String fingerboardWood, int numberOfAdapters, int numberOfFrets);

    AcousticGuitar createAcousticGuitar(String make, String model, double price, String color,
    		String bodyWood, String fingerboardWood, boolean caseIncluded, StringMaterial stringMaterial);

    BassGuitar createBassGuitar(String make, String model, double price, String color, String bodyWood, String fingerboardWood);
}
