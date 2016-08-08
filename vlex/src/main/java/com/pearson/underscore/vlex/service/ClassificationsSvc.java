package com.pearson.underscore.vlex.service;

import com.clarifai.api.ClarifaiClient;
import com.clarifai.api.RecognitionRequest;
import com.clarifai.api.RecognitionResult;
import com.clarifai.api.Tag;
import com.pearson.underscore.vlex.domain.internal.Definition;
import com.pearson.underscore.vlex.domain.ClassificationRequest;
import com.pearson.underscore.vlex.domain.ClassificationResponse;
import com.pearson.underscore.vlex.helper.DictionaryHelper;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassificationsSvc {

	@Autowired
	DictionaryHelper dictionaryHelper;
	//list of classifications to ignore
	private List<String> ignoreList = new ArrayList<String>();

	public ClassificationsSvc() {
		super();
		ignoreList.add("no person");
	}

	public ClassificationResponse findClassifications(ClassificationRequest request) {

		ClassificationResponse response = new ClassificationResponse();

		String[] classifications = this.classifyImage(request.getImage());

		System.out.println("Requesting translations");
		List<String> translations = dictionaryHelper.fetchDefinitions(classifications);

		/*
		for(String classification: classifications) {
			Definition definition = new Definition();
			definition.setEnglishWord(classification);
			//definition.setNativeLanguageDefinitions(dictionaryHelper.fetchDefinitions(classification, "noun", "brep"));
			//definition.setNativeLanguageDefinition(dictionaryHelper.fetchDefinitions(classification));
			response.addDefinition(definition);
		}
		*/

		for (int i=0; i<classifications.length; i++) {
			Definition definition = new Definition();
			definition.setEnglishWord(classifications[i]);
			definition.setNativeLanguageDefinition(translations.get(i));
			response.addDefinition(definition);
		}

		return response;
	}

	private String[] classifyImage(String imageBase64) {
		String[] classifications = new String[5];
		String trimmedString = imageBase64.trim();
		System.out.println("****************Base64String***********");
		System.out.println(trimmedString);
		System.out.println("****************Base64String***********");

		ClarifaiClient client = new ClarifaiClient("z7V2DBW8OkA5NCD5AtH5djUgDh4o5Omb6U4P_rkV", "nefr5dPH9lBhu5hA6xfa0dEfQupDJH6OkDAEA0mg");
		//byte[] imageByteArr = Base64.getDecoder().decode(trimmedString);
		byte[] imageByteArr = Base64.decodeBase64(trimmedString);

		System.out.println("Sending classification request to clarifai");
		//List<RecognitionResult> results = client.recognize(new RecognitionRequest("https://upload.wikimedia.org/wikipedia/commons/e/e3/Bouteille.jpg"));
		List<RecognitionResult> results = client.recognize(new RecognitionRequest(imageByteArr));
		System.out.println("Classifications received");

		//limiting to top 5 classifications for demonstration purposes
		int current = 0;
		for (int i = 0; (i<5 && current<results.get(0).getTags().size()); i++) {
			Tag tag = results.get(0).getTags().get(current++);
			if(!ignoreList.contains(tag.getName())) {
				classifications[i] = tag.getName();
			} else {
				i--;
			}
		}

		System.out.println(classifications.toString());
		return classifications;
	}

}
