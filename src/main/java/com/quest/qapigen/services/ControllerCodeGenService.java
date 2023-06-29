package com.quest.qapigen.services;

import static com.quest.qapigen.constants.ApplicationConstants.OUTPUT_FOLDER;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.quest.qapigen.dto.PayloadRequest;
import com.quest.qapigen.dto.RequestParam;
import com.quest.qapigen.exceptions.BaseException;
import com.quest.qapigen.utils.FileUtils;
import com.quest.qapigen.utils.JsonUtils;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ControllerCodeGenService {

	public void generateControllerCode(PayloadRequest payloadRequest) throws IOException, BaseException {
		log.info("controller code generation started.");
		// Generate the code.
		generateController(payloadRequest);

	}

	private void generateController(PayloadRequest payloadRequest) throws IOException, BaseException {
		String className = getClassNameFromApiUrl(payloadRequest.getApiUrl());

		// Generate the controller code
		StringBuilder codeBuilder = new StringBuilder();
		// adding package declaration
		codeBuilder.append("// package").append(";\n\n");
		// adding imports
		codeBuilder.append("import org.springframework.http.ResponseEntity;\n");
		codeBuilder.append("import org.springframework.web.bind.annotation.*;\n");
		codeBuilder.append("import io.swagger.annotations.*;\n\n");
		
		// adding RestController annotation
		codeBuilder.append("@RestController\n");
		// adding API documentation details
		codeBuilder.append("@Api(tags = \"<add description here>\")\n");
		// adding controller class details
		codeBuilder.append("public class GeneratedController").append(" {\n\n");
		// adding method details to controller
		codeBuilder.append("\t").append("@").append(getMethodName(payloadRequest.getMethod().toUpperCase()))
				.append("(\"").append(payloadRequest.getApiUrl()).append("\")").append("\n");
		// adding API documentation details
		codeBuilder.append("\t@ApiOperation(value = \"Subscription cancellation for store\",")
				.append(" produces = \"application/json\",").append("\n\t\tconsumes = \"application/json\")\n");
		codeBuilder.append("\t@ApiResponses(value = { @ApiResponse(code = 200, message = \"Ok\", response = SuccessResponseDetails.class),\n");
		codeBuilder.append("\t@ApiResponse(code = 400, message = \"Bad Request\", response = ErrorMessageDetails.class),\n");
		codeBuilder.append("\t@ApiResponse(code = 404, message = \"Not found\", response = ErrorMessageDetails.class) })\n");
		//		
		
		// adding method details
		codeBuilder.append("\t").append("public ResponseEntity<String> ").append(payloadRequest.getMethodName())
				.append("(");
		// adding request parameters as argument if available
		getRequestParams(payloadRequest, codeBuilder);
		
		// adding request headers as argument if available
		// getRequestHeaders(payloadRequest, codeBuilder);
		
		codeBuilder.append(") {\n\n");
		codeBuilder.append("\t\t// MDC details goes here\n\n");
		codeBuilder.append("\t\t// Controller logic goes here\n");
		
		codeBuilder.append("\n\t\treturn new ResponseEntity<>(HttpStatus.OK.value(), HttpStatus.OK);\n");
		
		codeBuilder.append("\t}\n");
		codeBuilder.append("}");

		// Create the controller directory if it doesn't exist
		String controllerFilePath = OUTPUT_FOLDER + "/" + className + ".java";
		FileUtils.writeToFile(controllerFilePath, codeBuilder);

		log.info("Controller code generated successfully at: " + controllerFilePath);
	}

	private static String getClassNameFromApiUrl(String apiUrl) {
		String[] parts = apiUrl.split("/");
		StringBuilder classNameBuilder = new StringBuilder();
		for (String part : parts) {
			if (!part.isEmpty()) {
				classNameBuilder.append(Character.toUpperCase(part.charAt(0))).append(part.substring(1));
			}
		}
		return classNameBuilder.toString();
	}

	private void getRequestParams(PayloadRequest payloadRequest, StringBuilder codeBuilder) throws BaseException {
		
		List<RequestParam> requestParams = payloadRequest.getRequestParams();
		
		if(CollectionUtils.isEmpty(requestParams)) {
			return;
		} 
		boolean isParameterAdded = false;
		StringBuilder requestParamString = new StringBuilder();
		for(RequestParam requestParam: requestParams) {
			log.info("Testing ******* {}", JsonUtils.toJson(requestParam));
			if (StringUtils.isNotBlank(requestParam.getPropertyName())
					&& StringUtils.isNotBlank(requestParam.getPropertyType())) {
				requestParamString.append("@RequestParam ").append(requestParam.getPropertyType())
				.append(" ") .append(requestParam.getPropertyName()).append(",\n\t\t ");
				isParameterAdded = true;
			}
		}
		
		if (isParameterAdded) {
			codeBuilder.append(requestParamString.substring(0, requestParamString.length() - 5));
		}
	}
	
private void getRequestHeaders(PayloadRequest payloadRequest, StringBuilder codeBuilder) throws BaseException {
		
		List<RequestParam> requestParams = payloadRequest.getRequestParams();
		
		if(CollectionUtils.isEmpty(requestParams)) {
			return;
		} 
		boolean isParameterAdded = false;
		StringBuilder requestParamString = new StringBuilder();
		for(RequestParam requestParam: requestParams) {
			log.info("Testing ******* {}", JsonUtils.toJson(requestParam));
			if (StringUtils.isNotBlank(requestParam.getPropertyName())
					&& StringUtils.isNotBlank(requestParam.getPropertyType())) {
				requestParamString.append("@RequestParam ").append(requestParam.getPropertyType())
				.append(" ") .append(requestParam.getPropertyName()).append(",\n\t\t ");
				isParameterAdded = true;
			}
		}
		
		if (isParameterAdded) {
			codeBuilder.append(requestParamString.substring(0, requestParamString.length() - 5));

		}
		
	}
	
	private String getMethodName(String inputMethodName) {

		switch (inputMethodName) {
		case "PUT":
			return "PutMapping";
		case "GET":
			return "GetMapping";
		case "DELETE":
			return "DeleteMapping";
		case "POST":
			return "PostMapping";
		case "PATCH":
			return "PatchMapping";
		default:
			throw new IllegalArgumentException("Unexpected value: " + inputMethodName);
		}
	}

}
