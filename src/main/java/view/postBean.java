package view;

public class postBean {
	private String title, text, tag;
	private int postId;

	public int getPostId() {
		return postId;
	}

	public String getTitle() {
		return title;
	}
	
	public String getText() {
		return text;
	}
	
	public String getTag() {
		return tag;
	}
	
	public void setPostId(int postId) {
		this.postId = postId;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public void setTag(String tag) {
		this.tag = tag;
	}
}