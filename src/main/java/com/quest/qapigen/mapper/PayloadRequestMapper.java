package com.quest.qapigen.mapper;

import org.springframework.stereotype.Component;

import com.quest.qapigen.dto.PayloadRequest;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class PayloadRequestMapper {

	public PayloadRequest jsonToDto(String jsonPayload) {
		log.info("converting request payload to PayloadRequest DTO.");
		
		return null;
	}
}
