package kshrd.miniproject;

public class Main {
	public static void main(String[] args) {
		ArticleController objController = new ArticleController(new ArticleModel(), new ArticleView("Korea Software HRD Center", 139));
	}
}
