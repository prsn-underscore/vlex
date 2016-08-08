package com.pearson.underscore.vlex.service;

import com.pearson.underscore.vlex.domain.DefinitionResponse;
import com.pearson.underscore.vlex.helper.DictionaryHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DefinitionsSvc {

	@Autowired
	DictionaryHelper dictionaryHelper;

	public DefinitionResponse findDefinitions(String word) {
		DefinitionResponse definitionResponse = new DefinitionResponse();

		String[] words = {word};
		definitionResponse.setOriginalWord(word);
		definitionResponse.setDefinitions(dictionaryHelper.fetchDefinitions(words));

		return definitionResponse;
	}

}
