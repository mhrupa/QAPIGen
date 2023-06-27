package com.quest.qapigen.services;

import static com.quest.qapigen.constants.ApplicationConstants.OUTPUT_FOLDER;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.quest.qapigen.dto.PayloadRequest;
import com.quest.qapigen.utils.FileUtils;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ControllerCodeGenService {

	public void generateControllerCode(PayloadRequest payloadRequest) throws IOException {
		log.info("controller code generation started.");
		// Generate the code.
		generateController(payloadRequest);

	}

	private void generateController(PayloadRequest payloadRequest) throws IOException {
		String className = getClassNameFromApiUrl(payloadRequest.getApiUrl());

		// Generate the controller code
		StringBuilder codeBuilder = new StringBuilder();
		codeBuilder.append("// package").append(";\n\n");
		codeBuilder.append("import org.springframework.http.ResponseEntity;\n");
		codeBuilder.append("import org.springframework.web.bind.annotation.*;\n\n");
		codeBuilder.append("@RestController\n");
		codeBuilder.append("@RequestMapping(\"").append(payloadRequest.getApiUrl()).append("\")\n");
		codeBuilder.append("public class ").append(className).append(" {\n\n");
		codeBuilder.append("\t").append("@").append(payloadRequest.getMethod()).append("\n");
		codeBuilder.append("\t").append("public ResponseEntity<String> ").append(payloadRequest.getMethodName())
				.append("(");
//		        if (requestDtoName != null && !requestDtoName.isEmpty()) {
//		            codeBuilder.append("@RequestBody ").append(requestDtoName).append(" requestDto");
//		            if (responseDtoName != null && !responseDtoName.isEmpty()) {
//		                codeBuilder.append(", ");
//		            }
//		        }
//		        if (responseDtoName != null && !responseDtoName.isEmpty()) {
//		            codeBuilder.append("@PathVariable String pathVariable");
//		        }
		codeBuilder.append(") {\n");
		codeBuilder.append("\t\t// Controller logic goes here\n");
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

}
