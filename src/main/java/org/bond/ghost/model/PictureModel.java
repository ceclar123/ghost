package org.bond.ghost.model;

import java.io.Serializable;

public class PictureModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1311868898162319946L;
	private long id;
	private long aid;
	private String fileName;
	private String filePath;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getAid() {
		return aid;
	}

	public void setAid(long aid) {
		this.aid = aid;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

}
