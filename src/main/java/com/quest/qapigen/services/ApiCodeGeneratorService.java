package com.quest.qapigen.services;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quest.qapigen.dto.PayloadRequest;
import com.quest.qapigen.exceptions.BaseException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ApiCodeGeneratorService {

	@Autowired
	private ControllerCodeGenService controllerCodeGenService;

	@Autowired
	private EntityCodeGenService entityCodeGenService;
	
	public void generateApiCode(PayloadRequest requestPayload) throws IOException, BaseException {
		log.info("API code generation started.");
		
		entityCodeGenService.generateModel(requestPayload);
		controllerCodeGenService.generateControllerCode(requestPayload);
	}
}
