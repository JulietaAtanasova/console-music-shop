package interfaces;

import java.util.List;

public interface MusicShop {
	String getName();

	List<Article> getArticles();

	void addArticle(Article article);

	void removeArticle(Article article);

	String listArticles();
}
