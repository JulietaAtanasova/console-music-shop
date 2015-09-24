package engine.factories;

import interfaces.MusicShop;
import interfaces.engine.MusicShopFactory;
import models.SimpleMusicShop;

public class SimpleMusicShopFactory implements MusicShopFactory {

	@Override
	public MusicShop createMusicShop(String name) {
		return new SimpleMusicShop(name);
	}

}
