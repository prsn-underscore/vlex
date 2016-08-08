package com.pearson.underscore.vlex.controller;

import com.pearson.underscore.vlex.domain.SentenceRequest;
import com.pearson.underscore.vlex.domain.SentenceResponse;
import com.pearson.underscore.vlex.domain.internal.Translation;
import com.pearson.underscore.vlex.service.SentencesSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/vlex/v1/sentences")
public class SentencesController {

	@Autowired
	SentencesSvc sentencesSvc;

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public
	@ResponseBody
	List<Translation> createSentence(@RequestBody SentenceRequest sentenceRequest) {

		return sentencesSvc.assembleSentence(sentenceRequest).getTranslations();

	}

}
