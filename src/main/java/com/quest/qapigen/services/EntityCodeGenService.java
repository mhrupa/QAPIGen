package com.quest.qapigen.services;

import org.springframework.stereotype.Service;

import com.quest.qapigen.dto.PayloadRequest;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EntityCodeGenService {

	public void generateEntity(PayloadRequest payloadRequest) {
		log.info("Entity generation started");

		log.info("Entity generation completed");
	}
}
