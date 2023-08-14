package com.quest.qapigen.services;

import static com.quest.qapigen.constants.ApplicationConstants.OUTPUT_FOLDER;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.quest.qapigen.constants.ApplicationConstants;
import com.quest.qapigen.dto.PayloadRequest;
import com.quest.qapigen.exceptions.BaseException;
import com.quest.qapigen.utils.FileUtils;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ServiceCodeGenService {

	/**
	 * Service class for controller code generation
	 * 
	 * @param payloadRequest
	 * @throws IOException
	 * @throws BaseException
	 */
	public void generateServiceCode() throws IOException, BaseException {
		log.info("Service code generation started.");
		// Generate the code.
		generateService();

	}

	/**
	 * Generate service code for the utility
	 * 
	 * @param payloadRequest
	 * @throws IOException
	 * @throws BaseException
	 */
	private void generateService() throws IOException, BaseException {

		// Generate the repository code
		StringBuilder codeBuilderI = new StringBuilder();
		// adding package declaration
		codeBuilderI.append("// package").append(";\n\n");
		// adding imports
		codeBuilderI.append("import org.springframework.stereotype.Service;\n\n");

		// adding Repository annotation
		codeBuilderI.append("@Service\n");
		// adding controller class details
		codeBuilderI.append("public interface ").append("GeneratedService").append(" {\n\n");

		codeBuilderI.append("}");

		// Generate the repository code
		StringBuilder codeBuilder = new StringBuilder();
		// adding package declaration
		codeBuilder.append("// package").append(";\n\n");

		// adding controller class details
		codeBuilder.append("public class ").append("GeneratedServiceImpl implements GeneratedService").append(" {\n\n");

		codeBuilder.append("}");

		// Create the controller directory if it doesn't exist
		//String folderName = ApplicationConstants.OUTPUT_FOLDER + "service";
		String controllerFilePathI = "GeneratedService.java";
		String controllerFilePath = "GeneratedServiceImpl.java";
		FileUtils.writeToFile(controllerFilePathI, codeBuilderI, ApplicationConstants.FOLDER_SERVICE);
		FileUtils.writeToFile(controllerFilePath, codeBuilder, ApplicationConstants.FOLDER_SERVICE);

		log.info("Service code generated successfully at: " + controllerFilePath);
	}

}
