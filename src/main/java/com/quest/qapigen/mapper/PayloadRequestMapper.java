package com.quest.qapigen.mapper;

import org.springframework.stereotype.Component;

import com.quest.qapigen.dto.PayloadRequest;
import com.quest.qapigen.exceptions.BaseException;
import com.quest.qapigen.utils.JsonUtils;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class PayloadRequestMapper {

	/**
	 * Mapper class for json to dto mapping
	 * 
	 * @param jsonPayload
	 * @return
	 * @throws BaseException
	 */
	public PayloadRequest jsonToDto(String jsonPayload) throws BaseException {
		log.info("converting request payload to PayloadRequest DTO.");
		return JsonUtils.fromJson(jsonPayload, PayloadRequest.class);
	}
}
