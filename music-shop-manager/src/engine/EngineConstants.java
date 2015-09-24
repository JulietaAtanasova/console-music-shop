package engine;

public class EngineConstants {
	public static final String CREATE_MUSIC_SHOP_COMMAND = "CreateMusicShop";
	public static final String CREATE_MICROPHONE_COMMAND = "CreateMicrophone";
	public static final String CREATE_DRUMS_COMMAND = "CreateDrums";
	public static final String CREATE_ELECTRIC_GUITAR_COMMAND = "CreateElectricGuitar";
	public static final String CREATE_ACOUSTIC_GUITAR_COMMAND = "CreateAcousticGuitar";
	public static final String CREATE_BASS_GUITAR_COMMAND = "CreateBassGuitar";
	public static final String ADD_ARTICLE_TO_SHOP_COMMAND = "AddArticleToShop";
	public static final String REMOVE_ARTICLE_FROM_SHOP_COMMAND = "RemoveArticleFromShop";
	public static final String LIST_ARTICLES_COMMAND = "ListArticles";
	
	public static final String INVALID_COMMAND_MESSAGE = "Invalid command name: %s";
	public static final String MUSIC_SHOP_EXISTS_MESSAGE = "The music shop %s already exists";
	public static final String ARTICLE_EXISTS_MESSAGE = "The article %s already exists";
	public static final String ARTICLE_EXISTS_IN_SHOP_MESSAGE = "The article %s already exists in shop %s";
	public static final String ARTICLE_DOES_NOT_EXISTS_IN_SHOP_MESSAGE = "The article %s does not exist in shop %s";
	public static final String MUSIC_SHOP_DOES_NOT_EXISTS_MESSAGE = "The music shop %s does not exist";
	public static final String ARTICLE_DOES_NOT_EXISTS_MESSAGE = "The article %s does not exist";
	
	public static final String MUSIC_SHOP_CREATED_MESSAGE = "Music shop %s created";
	public static final String ARTICLE_CREATED_MESSAGE = "%s %s created";
	public static final String ARTICLE_ADDED_MESSAGE = "Article %s successfully added to music shop %s";
	public static final String ARTICLE_REMOVED_MESSAGE = "Article %s successfully removed from music shop %s";
}
