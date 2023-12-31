package com.quest.qapigen.controller;

import java.io.IOException;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quest.qapigen.dto.PayloadRequest;
import com.quest.qapigen.exceptions.BaseException;
import com.quest.qapigen.services.ApiCodeGeneratorService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ApiGeneratorController {

	@Autowired
	private ApiCodeGeneratorService apiCodeGeneratorService;

	/**
	 * Controller class for the utility
	 * 
	 * @param payload
	 */
	@PostMapping("/generate-api")
	public void generateApi(@RequestBody PayloadRequest payload) {
		log.info("Code generation API called.");
		try {
			apiCodeGeneratorService.generateApiCode(payload);
		} catch (IOException | BaseException e) {
			log.error(ExceptionUtils.getStackTrace(e));
		}
	}
}
