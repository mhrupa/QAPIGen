package com.quest.qapigen.services;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quest.qapigen.constants.ApplicationConstants;
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
	
	@Autowired
	private FlywayCodeGenService flywayCodeGenService;
	
	@Autowired
	private ZipService zipService;
	
	/**
	 * API code generation service class
	 * 
	 * @param requestPayload
	 * @throws IOException
	 * @throws BaseException
	 */
	public void generateApiCode(PayloadRequest requestPayload) throws IOException, BaseException {
		log.info("API code generation started.");
		
		entityCodeGenService.generateModel(requestPayload);
		controllerCodeGenService.generateControllerCode(requestPayload);
		flywayCodeGenService.generateFlywayCode(requestPayload);
		String zipFilePath = "generated-source.zip";
		zipService.createZip(ApplicationConstants.OUTPUT_FOLDER, zipFilePath);
	}
}
