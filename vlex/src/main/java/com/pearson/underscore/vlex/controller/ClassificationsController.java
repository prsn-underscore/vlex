package com.pearson.underscore.vlex.controller;

import com.pearson.underscore.vlex.domain.ClassificationRequest;
import com.pearson.underscore.vlex.domain.internal.Definition;
import com.pearson.underscore.vlex.service.ClassificationsSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vlex/v1/classifications")
public class ClassificationsController {

	@Autowired
	ClassificationsSvc classificationsSvc;

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public
	@ResponseBody
	String[] classify(@RequestBody ClassificationRequest classificationRequest) {

		String[] classifications = new String[5];

		int i = 0;
		for (Definition definition:classificationsSvc.findClassifications(classificationRequest).getDefinitions()) {
			classifications[i] = definition.getEnglishWord() + " (" +definition.getNativeLanguageDefinition() + ")";
			i++;
		}

		return classifications;

	}

}
