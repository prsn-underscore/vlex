package com.pearson.underscore.vlex.domain;

import com.pearson.underscore.vlex.domain.internal.Definition;

import java.util.ArrayList;
import java.util.List;


public class ClassificationResponse {

	private List<Definition> definitions = new ArrayList<Definition>();

	public List<Definition> getDefinitions() {
		return definitions;
	}

	public void setDefinitions(List<Definition> definitions) {
		this.definitions = definitions;
	}

	public void addDefinition(Definition definition) {
		this.definitions.add(definition);
	}
}
