package com.pearson.underscore.vlex.controller;

import com.pearson.underscore.vlex.domain.DefinitionResponse;
import com.pearson.underscore.vlex.domain.WordAssociationResponse;
import com.pearson.underscore.vlex.service.DefinitionsSvc;
import com.pearson.underscore.vlex.service.WordAssociationSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/vlex/v1/wordassociations/{word}")
public class WordAssociationsController {

	@Autowired
	WordAssociationSvc wordAssociationSvc;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public
	@ResponseBody
	WordAssociationResponse findAssociations(@PathVariable String word) {
		return wordAssociationSvc.findAssociationsByWord(word);
	}

}
