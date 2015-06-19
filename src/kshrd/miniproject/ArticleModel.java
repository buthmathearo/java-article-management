package kshrd.miniproject;

import java.util.Calendar;

public class ArticleModel implements Comparable<ArticleModel> {
	
	private int id;
	private String title;
	private String author;
	private String content;
	private String date;	
	
	public long getId() {
		return id;
	}
	
	public void setId(int id) {
			this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String year, String month, String date) {
		this.date = year + "/" + month + "/" + date;
	}

	public void setDateByAuto() {
		Calendar calendar = Calendar.getInstance();
		this.date = calendar.get(Calendar.YEAR) + "/" + (calendar.get(Calendar.MONTH) + 1 ) + "/" + calendar.get(Calendar.DATE);
	}

	@Override
	public int compareTo(ArticleModel o) {
		return (this.id < o.id ? -1 : 1);
	}
}
