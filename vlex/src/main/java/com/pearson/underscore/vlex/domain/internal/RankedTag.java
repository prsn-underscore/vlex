package com.pearson.underscore.vlex.domain.internal;


public class RankedTag {
	private String tag;
	private String translation;
	private String type;
	private double rank;

	public RankedTag(String tag, String translation, String type) {
		this.tag=tag;
		this.translation=translation;
		this.type=type;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getTranslation() {
		return translation;
	}

	public void setTranslation(String translation) {
		this.translation = translation;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getRank() {
		return rank;
	}

	public void setRank(double rank) {
		this.rank = rank;
	}
}
