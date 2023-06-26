package com.quest.qapigen.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ApiGenerator {

	@PostMapping("generate-api")
	public void generateApi() {
		log.info("Testing");
	}
}
