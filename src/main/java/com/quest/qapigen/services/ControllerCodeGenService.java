package com.quest.qapigen.services;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.quest.qapigen.constants.ApplicationConstants;
import com.quest.qapigen.dto.PathVariable;
import com.quest.qapigen.dto.PayloadRequest;
import com.quest.qapigen.dto.RequestHeader;
import com.quest.qapigen.dto.RequestParam;
import com.quest.qapigen.exceptions.BaseException;
import com.quest.qapigen.utils.FileUtils;
import com.quest.qapigen.utils.JsonUtils;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ControllerCodeGenService {

	/**
	 * Service class for controller code generation
	 * 
	 * @param payloadRequest
	 * @throws IOException
	 * @throws BaseException
	 */
	public void generateControllerCode(PayloadRequest payloadRequest) throws IOException, BaseException {
		log.info("controller code generation started.");
		// Generate the code.
		generateController(payloadRequest);

	}

	/**
	 * Generate controller code for the utility
	 * 
	 * @param payloadRequest
	 * @throws IOException
	 * @throws BaseException
	 */
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
		codeBuilder.append("\t@ApiResponses(value = { @ApiResponse(code = 200, message = \"Ok\", response = String.class),\n");
		codeBuilder.append("\t@ApiResponse(code = 400, message = \"Bad Request\", response = ErrorMessageDetails.class),\n");
		codeBuilder.append("\t@ApiResponse(code = 404, message = \"Not found\", response = ErrorMessageDetails.class) })\n");
		//		
		
		// adding method details
		codeBuilder.append("\t").append("public ResponseEntity<String> ").append(payloadRequest.getMethodName())
				.append("(\n");
		boolean isMethodParameterAdded = false;
		// adding request parameters as argument if available
		isMethodParameterAdded = getRequestParams(payloadRequest, codeBuilder);
		
		// adding request headers as argument if available
		if(getRequestHeaders(payloadRequest, codeBuilder)) {
			isMethodParameterAdded = true;
		}
		
		// adding path variables as argument if available
		if(getPathVariables(payloadRequest, codeBuilder)) {
			isMethodParameterAdded = true;
		}
		
		if (isMethodParameterAdded) {
			codeBuilder = new StringBuilder(codeBuilder.substring(0, codeBuilder.length() -2));
		}
		
		codeBuilder.append(") {\n\n");
		codeBuilder.append("\t\t// MDC details goes here\n\n");
		codeBuilder.append("\t\t// Controller logic goes here\n");
		
		// adding return statement
		codeBuilder.append("\n\t\treturn new ResponseEntity<>(HttpStatus.OK.value(), HttpStatus.OK);\n");
		codeBuilder.append("\t}\n");
		codeBuilder.append("}");

		// Create the controller directory if it doesn't exist
		String controllerFilePath = className + ".java";
		FileUtils.writeToFile(controllerFilePath, codeBuilder, ApplicationConstants.FOLDER_CONTROLLER);

		log.info("Controller code generated successfully at: " + controllerFilePath);
	}

	/**
	 * Service class to get class name from API url
	 * 
	 * @param apiUrl
	 * @return
	 */
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

	/**
	 * Service class to get RequestParams
	 * 
	 * @param payloadRequest
	 * @param codeBuilder
	 * @return
	 * @throws BaseException
	 */
	private boolean getRequestParams(PayloadRequest payloadRequest, StringBuilder codeBuilder)
			throws BaseException {
		log.info("Controller code checking for request params");
		List<RequestParam> requestParams = payloadRequest.getRequestParams();
		
		if(CollectionUtils.isEmpty(requestParams)) {
			return false;
		}
		boolean isParameterAdded = false;
		for(RequestParam requestParam: requestParams) {
			if (StringUtils.isNotBlank(requestParam.getPropertyName())
					&& StringUtils.isNotBlank(requestParam.getPropertyType())) {
				codeBuilder.append(ApplicationConstants.API_PARAM_NAME).append(requestParam.getPropertyName())
						.append("\", value = \"<PROVIDE PROPERTY DESCRIPTION/DETAILS>\") @RequestParam ")
						.append(requestParam.getPropertyType()).append(" ").append(requestParam.getPropertyName())
						.append(",\n");
				isParameterAdded = true;
			}
		}
		return isParameterAdded;
	}
	
	/**
	 * Service class to get pathVariables
	 * 
	 * @param payloadRequest
	 * @param codeBuilder
	 * @return
	 * @throws BaseException
	 */
	private boolean getPathVariables(PayloadRequest payloadRequest, StringBuilder codeBuilder)
			throws BaseException {
		log.info("Controller code checking for request params");
		List<PathVariable> pathVariables = payloadRequest.getPathVariables();
		
		if(CollectionUtils.isEmpty(pathVariables)) {
			return false;
		}
		boolean isParameterAdded = false;
		for(PathVariable pathVariable: pathVariables) {
			if (StringUtils.isNotBlank(pathVariable.getPropertyName())
					&& StringUtils.isNotBlank(pathVariable.getPropertyType())) {
				codeBuilder.append(ApplicationConstants.API_PARAM_NAME).append(pathVariable.getPropertyName())
						.append("\", value = \"<PROVIDE PROPERTY DESCRIPTION/DETAILS>\") @PathVariable ")
						.append(pathVariable.getPropertyType()).append(" ").append(pathVariable.getPropertyName())
						.append(",\n");
				isParameterAdded = true;
			}
		}
		return isParameterAdded;
	}
	
	/**
	 * Service class to get requestHeaders
	 * 
	 * @param payloadRequest
	 * @param codeBuilder
	 * @return
	 * @throws BaseException
	 */
	private boolean getRequestHeaders(PayloadRequest payloadRequest, StringBuilder codeBuilder) throws BaseException {
		log.info("Controller code checking for request Headers");
		List<RequestHeader> requestHeaders = payloadRequest.getRequestHeaders();
		
		if(CollectionUtils.isEmpty(requestHeaders)) {
			return false;
		} 
		boolean isParameterAdded = false;
		for(RequestHeader requestHeader: requestHeaders) {
			log.info("Testing ******* {}", JsonUtils.toJson(requestHeader));
			if (StringUtils.isNotBlank(requestHeader.getPropertyName())
					&& StringUtils.isNotBlank(requestHeader.getPropertyType())) {
				codeBuilder.append(ApplicationConstants.API_PARAM_NAME).append(requestHeader.getPropertyName())
				.append("\", value = \"<PROVIDE PROPERTY DESCRIPTION/DETAILS>\") @RequestHeader ")
				.append(requestHeader.getPropertyType()).append(" ").append(requestHeader.getPropertyName())
				.append(",\n");
				isParameterAdded = true;
			}
		}
		return isParameterAdded;
	}
	
	/**
	 * Service class to get Method Name
	 * 
	 * @param inputMethodName
	 * @return
	 */
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
