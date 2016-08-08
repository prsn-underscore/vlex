package com.pearson.underscore.vlex.domain.internal;

import com.pearson.underscore.vlex.domain.WordAssociationResponse;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;


public class WordAssociation {

	@Id private String id;
	private String word;
	private String translation;
	private int occurences;
	private List<Tag> relatedTags = new ArrayList<Tag>();

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

	public List<Tag> getRelatedTags() {
		return relatedTags;
	}

	public void setRelatedTags(List<Tag> relatedTags) {
		this.relatedTags = relatedTags;
	}

	public void addRelatedTag(Tag relatedTag) {
		this.relatedTags.add(relatedTag);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
