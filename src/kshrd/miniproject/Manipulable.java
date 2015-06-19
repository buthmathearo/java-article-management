package kshrd.miniproject;
import java.util.List;
import java.util.Scanner;

public interface Manipulable {
	
	public void read(List<ArticleModel> objList, int id);
	public void write(List<ArticleModel> objList, Scanner input);
	public void search(List<ArticleModel> objList, Scanner input);
	public void update(List<ArticleModel> objList, int id, Scanner input);
	public void delete(List<ArticleModel> objList, int id, Scanner input);
	
}
