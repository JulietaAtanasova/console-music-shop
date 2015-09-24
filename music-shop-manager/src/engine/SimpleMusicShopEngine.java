package engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import engine.factories.SimpleArticleFactory;
import engine.factories.SimpleMusicShopFactory;
import interfaces.Article;
import interfaces.MusicShop;
import interfaces.engine.ArticleFactory;
import interfaces.engine.Command;
import interfaces.engine.MusicShopEngine;
import interfaces.engine.UserInterface;
import models.StringMaterial;

public class SimpleMusicShopEngine implements MusicShopEngine {

	private static MusicShopEngine instance;

	private final SimpleMusicShopFactory musicShopFactory;
	private final ArticleFactory articleFactory;

	private final Map<String, MusicShop> musicShops;
	private final Map<String, Article> articles;

	private final UserInterface userInterface;

	public SimpleMusicShopEngine() {
		this.musicShopFactory = new SimpleMusicShopFactory();
		this.articleFactory = new SimpleArticleFactory();
		this.musicShops = new HashMap<String, MusicShop>();
		this.articles = new HashMap<String, Article>();
		this.userInterface = new ConsoleInterface();
	}

	private SimpleMusicShopFactory getMusicShopFactory() {
		return this.musicShopFactory;
	}

	private ArticleFactory getArticleFactory() {
		return this.articleFactory;
	}

	private Map<String, MusicShop> getMusicShops() {
		return this.musicShops;
	}

	private Map<String, Article> getArticles() {
		return this.articles;
	}

	private UserInterface getUserInterface() {
		return this.userInterface;
	}

	public static MusicShopEngine getInstance() {
		if (instance == null) {
			instance = new SimpleMusicShopEngine();
		}

		return instance;
	}

	@Override
	public void start() {
		List<Command> commands = this.readCommands();
		Iterable<String> commandResults = this.processCommands(commands);
		this.getUserInterface().output(commandResults);
	}

	private List<Command> readCommands() {
		List<Command> commands = new ArrayList<>();
		for (String line : this.getUserInterface().input()) {
			commands.add(SimpleCommand.parse(line));
		}
		return commands;
	}

	private Iterable<String> processCommands(List<Command> commands) {
		List<String> commandsResults = new ArrayList<>();
		for (Command command : commands) {
			String commandResult = null;
			switch (command.getName()) {
			case EngineConstants.CREATE_MUSIC_SHOP_COMMAND:
				commandResult = this.createMusicShop(command.getParameters().get("name"));
				break;
			case EngineConstants.CREATE_MICROPHONE_COMMAND:
				commandResult = this.createMicrophone(command.getParameters().get("make"),
						command.getParameters().get("model"), Double.parseDouble(command.getParameters().get("price")),
						this.ParseBoolean(command.getParameters().get("cable")));
				break;
			case EngineConstants.CREATE_DRUMS_COMMAND:
				commandResult = this.createDrums(command.getParameters().get("make"),
						command.getParameters().get("model"), Double.parseDouble(command.getParameters().get("price")),
						command.getParameters().get("color"), Integer.parseInt(command.getParameters().get("width")),
						Integer.parseInt(command.getParameters().get("height")));
				break;
			case EngineConstants.CREATE_ELECTRIC_GUITAR_COMMAND:
				commandResult = this.createElectricGuitar(command.getParameters().get("make"),
						command.getParameters().get("model"), Double.parseDouble(command.getParameters().get("price")),
						command.getParameters().get("color"), command.getParameters().get("body"),
						command.getParameters().get("fingerboard"),
						Integer.parseInt(command.getParameters().get("adapters")),
						Integer.parseInt(command.getParameters().get("frets")));
				break;
			case EngineConstants.CREATE_ACOUSTIC_GUITAR_COMMAND:
				commandResult = this.createAcousticGuitar(command.getParameters().get("make"),
						command.getParameters().get("model"), Double.parseDouble(command.getParameters().get("price")),
						command.getParameters().get("color"), command.getParameters().get("body"),
						command.getParameters().get("fingerboard"),
						this.ParseBoolean(command.getParameters().get("case")), command.getParameters().get("strings"));
				break;
			case EngineConstants.CREATE_BASS_GUITAR_COMMAND:
				commandResult = this.createBassGuitar(command.getParameters().get("make"),
						command.getParameters().get("model"), Double.parseDouble(command.getParameters().get("price")),
						command.getParameters().get("color"), command.getParameters().get("body"),
						command.getParameters().get("fingerboard"));
				break;
			case EngineConstants.ADD_ARTICLE_TO_SHOP_COMMAND:
				commandResult = this.addArticleToShop(command.getParameters().get("name"),
						command.getParameters().get("make"), command.getParameters().get("model"));
				break;
			case EngineConstants.REMOVE_ARTICLE_FROM_SHOP_COMMAND:
				commandResult = this.removeArticleFromShop(command.getParameters().get("name"),
						command.getParameters().get("make"), command.getParameters().get("model"));
				break;
			case EngineConstants.LIST_ARTICLES_COMMAND:
				commandResult = this.listArticles(command.getParameters().get("name"));
				break;
			default:
				commandResult = String.format(EngineConstants.INVALID_COMMAND_MESSAGE, command.getName());
				break;
			}
			commandsResults.add(commandResult);
		}
		return commandsResults;
	}

	private boolean ParseBoolean(String boolValue) {
		if (boolValue.equals("yes")) {
			return true;
		} else if (boolValue.equals("no")) {
			return false;
		} else {
			throw new IllegalArgumentException("Invalid boolean value provided: " + boolValue);
		}
	}

	private String createMusicShop(String name) {
		if (this.getMusicShops().containsKey(name)) {
			return String.format(EngineConstants.MUSIC_SHOP_EXISTS_MESSAGE, name);
		}

		MusicShop musicShop = this.getMusicShopFactory().createMusicShop(name);
		this.getMusicShops().put(name, musicShop);
		return String.format(EngineConstants.MUSIC_SHOP_CREATED_MESSAGE, name);
	}

	private String createMicrophone(String make, String model, double price, boolean hasCable) {
		String name = make + " " + model;
		try {
			this.ensureUniqueArticle(make, model);
		} catch (IllegalArgumentException e) {
			return String.format(EngineConstants.ARTICLE_EXISTS_MESSAGE, name);
		}

		Article microphone = (Article) this.getArticleFactory().createMirophone(make, model, price, hasCable);
		this.getArticles().put(name, microphone);
		return String.format(EngineConstants.ARTICLE_CREATED_MESSAGE, "Microphone", name);
	}

	private String createDrums(String make, String model, double price, String color, int width, int height) {
		String name = make + " " + model;
		try {
			this.ensureUniqueArticle(make, model);
		} catch (IllegalArgumentException e) {
			return String.format(EngineConstants.ARTICLE_EXISTS_MESSAGE, name);
		}

		Article drums = (Article) this.getArticleFactory().createDrums(make, model, price, color, width, height);
		this.getArticles().put(name, drums);
		return String.format(EngineConstants.ARTICLE_CREATED_MESSAGE, "Drums", name);
	}

	private String createElectricGuitar(String make, String model, double price, String color, String bodyWood,
			String fingerboardWood, int numberOfAdapters, int numberOfFrets) {
		String name = make + " " + model;
		try {
			this.ensureUniqueArticle(make, model);
		} catch (IllegalArgumentException e) {
			return String.format(EngineConstants.ARTICLE_EXISTS_MESSAGE, name);
		}

		Article electricGuitar = (Article) this.getArticleFactory().createElectricGuitar(make, model, price, color,
				bodyWood, fingerboardWood, numberOfAdapters, numberOfFrets);
		this.getArticles().put(name, electricGuitar);
		return String.format(EngineConstants.ARTICLE_CREATED_MESSAGE, "Electric guitar", name);
	}

	private String createAcousticGuitar(String make, String model, double price, String color, String bodyWood,
			String fingerboardWood, boolean caseIncluded, String stringMaterial) {
		String name = make + " " + model;
		try {
			this.ensureUniqueArticle(make, model);
		} catch (IllegalArgumentException e) {
			return String.format(EngineConstants.ARTICLE_EXISTS_MESSAGE, name);
		}

		Article acousticGuitar = (Article) this.getArticleFactory().createAcousticGuitar(make, model, price, color,
				bodyWood, fingerboardWood, caseIncluded, StringMaterial.valueOf(stringMaterial));
		this.getArticles().put(name, acousticGuitar);
		return String.format(EngineConstants.ARTICLE_CREATED_MESSAGE, "Acoustic guitar", name);
	}

	private String createBassGuitar(String make, String model, double price, String color, String bodyWood,
			String fingerboardWood) {
		String name = make + " " + model;
		try {
			this.ensureUniqueArticle(make, model);
		} catch (IllegalArgumentException e) {
			return String.format(EngineConstants.ARTICLE_EXISTS_MESSAGE, name);
		}

		Article bassGuitar = (Article) this.getArticleFactory().createBassGuitar(make, model, price, color, bodyWood,
				fingerboardWood);
		this.getArticles().put(name, bassGuitar);
		return String.format(EngineConstants.ARTICLE_CREATED_MESSAGE, "Bass guitar", name);
	}

	private void ensureUniqueArticle(String make, String model) {
		String name = make + " " + model;
		if (this.getArticles().containsKey(name)) {
			throw new IllegalArgumentException(String.format(EngineConstants.ARTICLE_EXISTS_MESSAGE, name));
		}
	}

	private String addArticleToShop(String shopName, String make, String model) {
		if (!this.getMusicShops().containsKey(shopName)) {
			return String.format(EngineConstants.MUSIC_SHOP_DOES_NOT_EXISTS_MESSAGE, shopName);
		}

		String articleName = make + " " + model;
		if (!this.getArticles().containsKey(articleName)) {
			return String.format(EngineConstants.ARTICLE_DOES_NOT_EXISTS_MESSAGE, articleName);
		}

		if (!this.getMusicShops().get(shopName).getArticles().stream().map(a -> a.getMake() + " " + a.getModel())
				.filter(a -> a.equals(articleName)).collect(Collectors.toList()).isEmpty()) {
			return String.format(EngineConstants.ARTICLE_EXISTS_IN_SHOP_MESSAGE, articleName, shopName);
		}

		this.getMusicShops().get(shopName).addArticle(this.getArticles().get(articleName));
		return String.format(EngineConstants.ARTICLE_ADDED_MESSAGE, articleName, shopName);
	}

	private String removeArticleFromShop(String shopName, String make, String model) {
		if (!this.getMusicShops().containsKey(shopName)) {
			return String.format(EngineConstants.MUSIC_SHOP_DOES_NOT_EXISTS_MESSAGE, shopName);
		}

		String articleName = make + " " + model;
		if (!this.getArticles().containsKey(articleName)) {
			return String.format(EngineConstants.ARTICLE_DOES_NOT_EXISTS_MESSAGE, articleName);
		}

		if (this.getMusicShops().get(shopName).getArticles().stream().map(a -> a.getMake() + " " + a.getModel())
				.filter(a -> a.equals(articleName)).collect(Collectors.toList()).isEmpty()) {
			return String.format(EngineConstants.ARTICLE_DOES_NOT_EXISTS_IN_SHOP_MESSAGE, articleName, shopName);
		}

		this.getMusicShops().get(shopName).removeArticle(this.getArticles().get(articleName));
		return String.format(EngineConstants.ARTICLE_REMOVED_MESSAGE, articleName, shopName);
	}

	private String listArticles(String shopName) {
		if (!this.getMusicShops().containsKey(shopName)) {
			return String.format(EngineConstants.MUSIC_SHOP_DOES_NOT_EXISTS_MESSAGE, shopName);
		}
		
		return this.getMusicShops().get(shopName).listArticles();
	}
}
