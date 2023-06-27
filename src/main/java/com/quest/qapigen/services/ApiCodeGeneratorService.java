package com.quest.qapigen.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quest.qapigen.exceptions.BaseException;
import com.quest.qapigen.mapper.PayloadRequestMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ApiCodeGeneratorService {

	@Autowired
	private PayloadRequestMapper payloadRequestMapper;
	
	@Autowired
	private ControllerCodeGenService controllerCodeGenService;
	
	public void generateControllerCode(String requestPayload) {
		log.info("API code generation started.");
		
		try {
			payloadRequestMapper.jsonToDto(requestPayload);
			
			controllerCodeGenService.generateControllerCode();
			
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	//private void Request
}
