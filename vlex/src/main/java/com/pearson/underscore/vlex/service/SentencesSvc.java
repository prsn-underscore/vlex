package com.pearson.underscore.vlex.service;

import com.memetix.mst.language.Language;
import com.memetix.mst.translate.Translate;
import com.pearson.underscore.vlex.domain.SentenceRequest;
import com.pearson.underscore.vlex.domain.SentenceResponse;
import com.pearson.underscore.vlex.domain.internal.Translation;
import com.pearson.underscore.vlex.helper.DictionaryHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import simplenlg.framework.*;
import simplenlg.lexicon.*;
import simplenlg.realiser.english.*;
import simplenlg.phrasespec.*;
import simplenlg.features.*;

import java.util.List;


@Service
public class SentencesSvc {


	private Lexicon lexicon = Lexicon.getDefaultLexicon();
	private NLGFactory nlgFactory = new NLGFactory(lexicon);
	private Realiser realiser = new Realiser(lexicon);

	@Autowired
	WordAssociationSvc wordAssociationSvc;

	@Autowired
	DictionaryHelper dictionaryHelper;

	public SentencesSvc() {
		super();
		Translate.setClientId("madura_Growth_Hack_123");
		Translate.setClientSecret("ZC86/nxqVXABE6paNFO1eIc0vWFg31NFgA24DxzgNBI=");
	}

	public SentenceResponse assembleSentence(SentenceRequest request) {
		String subject = request.getSubject();
		String object = request.getObject();
		String verb = request.getVerb();

		SentenceResponse response = new SentenceResponse();
		String[] sentences = this.constructSentences(subject, object, verb);

		List<String> translatedSentences = dictionaryHelper.fetchDefinitions(sentences);
		for (int i = 0; i < 4; i++) {
			Translation translation = new Translation();
			translation.setSentence(sentences[i]);
			translation.setTranslation(translatedSentences.get(i));
			response.addTranslation(translation);
		}

		response.setObject(object);
		response.setSubject(subject);
		response.setVerb(verb);
		response.setTranslatedLanguage("pt");

		//save word combination in db
		wordAssociationSvc.updateWordAssociation(object, verb);

		return response;
	}

	private String[] constructSentences(String subject, String object, String verb) {
		String[] sentences = new String[4];


		SPhraseSpec sentence = nlgFactory.createClause();
		NPPhraseSpec objectPhrase = nlgFactory.createNounPhrase(object);
		objectPhrase.setDeterminer("this");
		sentence.setSubject(subject);
		sentence.setObject(objectPhrase);
		sentence.setVerb(verb);

		//past
		sentence.setFeature(Feature.TENSE, Tense.PAST);
		sentences[0] = realiser.realiseSentence(sentence);

		//future
		sentence.setFeature(Feature.TENSE, Tense.FUTURE);
		sentences[1] = realiser.realiseSentence(sentence);

		//q - may I
		sentence.setFeature(Feature.INTERROGATIVE_TYPE, InterrogativeType.YES_NO);
		sentence.setFeature(Feature.MODAL, "may");
		sentences[2] = realiser.realiseSentence(sentence);

		//q - how can
		sentence.setFeature(Feature.INTERROGATIVE_TYPE, InterrogativeType.HOW);
		sentence.setFeature(Feature.MODAL, "can");
		sentences[3] = realiser.realiseSentence(sentence);


		return sentences;
	}

}
