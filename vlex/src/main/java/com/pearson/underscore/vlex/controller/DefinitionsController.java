package com.pearson.underscore.vlex.controller;

import com.pearson.underscore.vlex.domain.DefinitionResponse;
import com.pearson.underscore.vlex.service.DefinitionsSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vlex/v1/definitions/{word}")
public class DefinitionsController {

	@Autowired
	DefinitionsSvc definitionsSvc;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public
	@ResponseBody
	DefinitionResponse define(@PathVariable String word) {

		return definitionsSvc.findDefinitions(word);

	}

}
