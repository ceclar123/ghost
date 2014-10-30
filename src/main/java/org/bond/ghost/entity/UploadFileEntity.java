package org.bond.ghost.entity;

public class UploadFileEntity {
	private String filePath;
	private String fileName;
	private long fileSize;
	private String message;

	public UploadFileEntity(String filePath, String fileName, long fileSize, String message) {
		super();
		this.filePath = filePath;
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.message = message;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
