package org.bond.ghost.model;

import java.io.Serializable;

public class UserModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8694421309370342349L;
	private long uid;
	private String logname;
	private String name;
	private String psd;
	private String md5psd;
	private short status;

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public String getLogname() {
		return logname;
	}

	public void setLogname(String logname) {
		this.logname = logname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPsd() {
		return psd;
	}

	public void setPsd(String psd) {
		this.psd = psd;
	}

	public String getMd5psd() {
		return md5psd;
	}

	public void setMd5psd(String md5psd) {
		this.md5psd = md5psd;
	}

	public short getStatus() {
		return status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

}
