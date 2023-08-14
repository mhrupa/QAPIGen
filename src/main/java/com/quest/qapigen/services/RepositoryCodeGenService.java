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
public class RepositoryCodeGenService {

	/**
	 * Service class for controller code generation
	 * 
	 * @param payloadRequest
	 * @throws IOException
	 * @throws BaseException
	 */
	public void generateRepositoryCode(PayloadRequest payloadRequest) throws IOException, BaseException {
		log.info("Repository code generation started.");
		// Generate the code.
		generateRepository(payloadRequest);

	}

	/**
	 * Generate repository code for the utility
	 * 
	 * @param payloadRequest
	 * @throws IOException
	 * @throws BaseException
	 */
	private void generateRepository(PayloadRequest payloadRequest) throws IOException, BaseException {
		String entityName = payloadRequest.getEntity().get(0).getEntityName();

		// Generate the repository code
		StringBuilder codeBuilder = new StringBuilder();
		// adding package declaration
		codeBuilder.append("// package").append(";\n\n");
		// adding imports
		codeBuilder.append("import org.springframework.stereotype.Repository;\n\n");

		// adding Repository annotation
		codeBuilder.append("@Repository\n");
		// adding controller class details
		codeBuilder.append("public class ").append(entityName).append("Repository extends JpaRepository")
				.append("<" + entityName + " String>").append(" {\n\n");

		codeBuilder.append("}");

		// Create the controller directory if it doesn't exist
		String controllerFilePath = entityName + "Repository.java";
		FileUtils.writeToFile(controllerFilePath, codeBuilder, ApplicationConstants.FOLDER_REPO);

		log.info("Repository code generated successfully at: " + controllerFilePath);
	}

}
