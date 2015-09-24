package models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import interfaces.AcousticGuitar;
import interfaces.Article;
import interfaces.BassGuitar;
import interfaces.Drums;
import interfaces.ElectricGuitar;
import interfaces.Microphone;
import interfaces.MusicShop;

public class SimpleMusicShop implements MusicShop {

	private String name;
	private List<Article> articles;

	public SimpleMusicShop(String name) {
		this.setName(name);
		this.articles = new ArrayList<>();
	}

	@Override
	public String getName() {
		return this.name;
	}

	private void setName(String name) {
		this.name = name;
	}

	@Override
	public List<Article> getArticles() {
		return this.articles;
	}

	@Override
	public void addArticle(Article article) {
		this.getArticles().add(article);
	}

	@Override
	public void removeArticle(Article article) {
		this.getArticles().remove(article);
	}

	@Override
	public String listArticles() {
		return this.toString();
	}

	@Override
	public String toString() {
		String shop = String.format("===== %s =====\n", this.getName());
		String shopArticles = "";
		if (this.getArticles().isEmpty()) {
			shopArticles = "The shop is empty. Come back soon.\n";
		} else {
			shopArticles += addArticles(Microphone.class, "Microphones");
			shopArticles += addArticles(Drums.class, "Drums");
			shopArticles += addArticles(ElectricGuitar.class, "Electric guitars");
			shopArticles += addArticles(AcousticGuitar.class, "Acoustic guitars");
			shopArticles += addArticles(BassGuitar.class, "Bass guitars");
		}

		return shop + shopArticles;
	}

	private String addArticles(Class<?> articleType, String articlesName) {
		String articlesString = "";
		List<Article> articles = this.getArticles().stream().filter(a -> articleType.isInstance(a))
				.collect(Collectors.toList());
		if (!articles.isEmpty()) {
			articlesString += "----- " + articlesName + " -----\n";
			articles = sortArticlesByName(articles);
			articlesString = addArticlesToString(articlesString, articles);
		}
		return articlesString;
	}

	private List<Article> sortArticlesByName(List<Article> articles) {
		articles = articles.stream()
				.sorted((a, b) -> (a.getMake() + " " + a.getModel()).compareTo(b.getMake() + " " + b.getModel()))
				.collect(Collectors.toList());
		return articles;
	}
	
	private String addArticlesToString(String shopArticles, List<Article> articles) {
		for (Article article : articles) {
			shopArticles += article;
		}
		return shopArticles;
	}
	
}
