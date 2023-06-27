package com.quest.qapigen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quest.qapigen.dto.PayloadRequest;
import com.quest.qapigen.services.ApiCodeGeneratorService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ApiGeneratorController {

	@Autowired
	private ApiCodeGeneratorService apiCodeGeneratorService;
	
	@PostMapping("/generate-api")
	public void generateApi(@RequestBody PayloadRequest payload) {
		log.info("Testing");
		apiCodeGeneratorService.generateControllerCode(payload);
	}
}
