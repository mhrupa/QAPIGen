package com.quest.qapigen.services;

import static com.quest.qapigen.constants.ApplicationConstants.OUTPUT_FOLDER;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.quest.qapigen.constants.ApplicationConstants;
import com.quest.qapigen.dto.PayloadRequest;
import com.quest.qapigen.utils.FileUtils;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ValidatorCodeGenService {

	/**
	 * Generate data model class
	 * 
	 * @param payloadRequest
	 * @throws IOException
	 */
	public void generateDTOValidator(PayloadRequest payloadRequest) throws IOException {
		String dtoName = payloadRequest.getRequestBody().getDtoName();
		String ValidatorName = dtoName.concat("Validator");
		// Generate the controller code
		StringBuilder codeBuilder = new StringBuilder();
		// adding package declaration
		codeBuilder.append("// package").append(";\n\n");
		// adding imports
		codeBuilder.append("import java.util.function.Function;\n");
		codeBuilder.append("import org.springframework.http.ResponseEntity;\n\n");

		// adding controller class details
		codeBuilder.append("public class " + ValidatorName).append("extends Function<").append(dtoName)
				.append(", String>").append(" {\n\n");
		codeBuilder.append("static" + ValidatorName).append("isDtoNamePatternValid");

		codeBuilder.append("}");
		// Create the controller directory if it doesn't exist
		String controllerFilePath = OUTPUT_FOLDER + "/" + dtoName + ".java";
		FileUtils.writeToFile(controllerFilePath, codeBuilder, ApplicationConstants.FOLDER_DTO);

		log.info("Controller code generated successfully at: " + controllerFilePath);
	}

}
