package org.bond.ghost.model;

import java.io.Serializable;

public class MaximModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6805402532099929742L;
	private long id;
	private String title;
	private String content;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
