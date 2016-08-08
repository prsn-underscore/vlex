package com.pearson.underscore.vlex.helper;

import com.memetix.mst.language.Language;
import com.memetix.mst.translate.Translate;
import com.pearson.underscore.vlex.domain.internal.DictionaryDefinitions;
import com.pearson.underscore.vlex.domain.internal.DictionaryResult;
import com.pearson.underscore.vlex.domain.internal.DictionarySense;
import com.pearson.underscore.vlex.domain.internal.DictionaryTranslation;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
public class DictionaryHelper {

	/*
	public List<String> fetchDefinitions(String word, String type, String dictionary) {

		List<String> definitions = new ArrayList<String>();
		RestTemplate restTemplate = new RestTemplate();

		String url = "http://api.pearson.com/v2/dictionaries/" + dictionary + "/entries?headword=" + word + ((type==null) ? "" : ("&part_of_speech=" + type));

		ResponseEntity<DictionaryDefinitions> response = restTemplate.getForEntity(url, DictionaryDefinitions.class);

		for (DictionaryResult dictionaryResult: response.getBody().getResults()) {
			if(dictionaryResult.getHeadword().equals(word)) {
				for (DictionarySense sense: dictionaryResult.getSenses()) {
					for (DictionaryTranslation translations: sense.getTranslations()) {
						for(String translation: translations.getText()) {
							definitions.add(translation);
						}
					}
				}
			}
		}

		return definitions;
	}
	*/

	public List<String> fetchDefinitions(String[] phrases) {
		List<String> translatedSentences = null;

		try {
			translatedSentences = Arrays.asList(Translate.execute(phrases, Language.ENGLISH, Language.PORTUGUESE));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return translatedSentences;
	}

}
