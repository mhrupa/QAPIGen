package com.quest.qapigen.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quest.qapigen.dto.PayloadRequest;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ApiCodeGeneratorService {

	@Autowired
	private ControllerCodeGenService controllerCodeGenService;

	public void generateControllerCode(PayloadRequest requestPayload) {
		log.info("API code generation started.");

//			log.info(JsonUtils.toJson(requestPayload));
		controllerCodeGenService.generateControllerCode(requestPayload);
	}
}
