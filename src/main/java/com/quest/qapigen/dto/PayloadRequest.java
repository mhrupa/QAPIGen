package com.quest.qapigen.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PayloadRequest {

	private String apiUrl;
	private String method;
	private String methodName;
	private RequestBody requestBody;
	private List<RequestHeader> requestHeaders;
	private List<RequestParam> requestParams;
	private List<PathVariable> pathVariables;
	private String response;
	private List<Entity> entity;

}
