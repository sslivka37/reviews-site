package org.wecancodeit.reviews;

public class Review {
	
	private long id;
	private String title;
	private String category;
	private String content;
	private String url;

	public Review(long id, String title, String category, String content, String url) {
		this.id = id;
		this.title = title;
		this.category = category;
		this.content = content;
		this.url = url;
	}

	public Long getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getCategory() {
		return category;
	}
	
	public String getContent() {
		return content;
	}
	
	public String getUrl() {
		return url;
	}

}
