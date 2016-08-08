package com.pearson.underscore.vlex.domain;

import com.pearson.underscore.vlex.domain.internal.RankedTag;
import com.pearson.underscore.vlex.domain.internal.Tag;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;


public class WordAssociationResponse {

	private String word;
	private String translation;
	private int occurences;
	private List<RankedTag> relatedTags = new ArrayList<RankedTag>();

	public WordAssociationResponse(String word, String translation, int occurences) {
		this.word = word;
		this.translation = translation;
		this.occurences = occurences;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getTranslation() {
		return translation;
	}

	public void setTranslation(String translation) {
		this.translation = translation;
	}

	public int getOccurences() {
		return occurences;
	}

	public void setOccurences(int occurences) {
		this.occurences = occurences;
	}

	public List<RankedTag> getRelatedTags() {
		return relatedTags;
	}

	public void setRelatedTags(List<RankedTag> relatedTags) {
		this.relatedTags = relatedTags;
	}

}
