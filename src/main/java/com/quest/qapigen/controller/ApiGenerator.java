package com.quest.qapigen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quest.qapigen.services.ControllerCodeGenService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ApiGenerator {

	@Autowired
	private ControllerCodeGenService controllerCodeGenService;
	
	@PostMapping("generate-api")
	public void generateApi(String payload) {
		log.info("Testing");
		
		controllerCodeGenService.generateControllerCode();
	}
}
