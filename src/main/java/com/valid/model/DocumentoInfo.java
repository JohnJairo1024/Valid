package com.valid.model;

public class DocumentoInfo {
	private String nombrearchivo;
	private String url;
	
	public DocumentoInfo(String nombrearchivo, String url) {
		this.nombrearchivo = nombrearchivo;
		this.url = url;
	}
	
	public String getFilename() {
		return this.nombrearchivo;
	}
	
	public void setFilename(String nombrearchivo) {
		this.nombrearchivo = nombrearchivo;
	}
	
	public String getUrl() {
		return this.url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
}

