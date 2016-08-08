package com.pearson.underscore.vlex.domain;


public class SentenceRequest {

	private String object;
	private String subject;
	private String verb;

	/*public SentenceRequest(String subject, String object, String verb) {
		this.subject = subject;
		this.object = object;
		this.verb = verb;
	}*/

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getVerb() {
		return verb;
	}

	public void setVerb(String verb) {
		this.verb = verb;
	}
}
