package com.quest.qapigen.services;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quest.qapigen.dto.PayloadRequest;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ApiCodeGeneratorService {

	@Autowired
	private ControllerCodeGenService controllerCodeGenService;

	public void generateControllerCode(PayloadRequest requestPayload) throws IOException {
		log.info("API code generation started.");
		controllerCodeGenService.generateControllerCode(requestPayload);
	}
}
