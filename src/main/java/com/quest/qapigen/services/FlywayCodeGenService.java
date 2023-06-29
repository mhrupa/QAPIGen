package com.quest.qapigen.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quest.qapigen.constants.ApplicationConstants;
import com.quest.qapigen.dto.PayloadRequest;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FlywayCodeGenService {

	/**
	 * 
	 * @param payloadRequest
	 */
	public void generateFlywayCode(PayloadRequest payloadRequest) {
		log.info("Flyway Code generation started");
		String folderName = ApplicationConstants.OUTPUT_FOLDER + ApplicationConstants.PATH_DELIMETER + "flyway-migrations";
		String fileName = "V1_1.0_" + "rename_script " + ".sql";
		String fileContent = generateSqlScript(payloadRequest);

		try {
			// Creating the folder
			Path folderPath = Paths.get(folderName);
			Files.createDirectories(folderPath);

			// Creating file inside the folder
			Path filePath = Paths.get(folderName, fileName);
			Files.createFile(filePath);

			// Write content to the file
			Files.write(filePath, fileContent.getBytes());

			log.info("Folder and file created successfully.");
		} catch (IOException e) {
			log.info("Error in file creation and writing ");
		}

		log.info("Flyway Code generation ended");
	}

	/**
	 * 
	 * @param payloadRequest
	 * @return
	 */
	private static String generateSqlScript(PayloadRequest  payloadRequest) {

		StringBuilder sqlScript = new StringBuilder();
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode rootNode = objectMapper.readTree(payloadRequest.toString());

			JsonNode entityNode = rootNode.get("entity");
			String entityName = entityNode.get("entityName").asText();
			String tableName = entityNode.get("tableName").asText();

			sqlScript.append("CREATE TABLE ").append(tableName).append(" (\n");

			JsonNode propertiesNode = entityNode.get("properties");
			for (JsonNode propertyNode : propertiesNode) {
				String propertyName = propertyNode.get("propertyName").asText();
				String propertyType = propertyNode.get("propertyType").asText();

				sqlScript.append("\t").append(propertyName).append(" ").append(propertyType);

				JsonNode validationsNode = propertyNode.get("validations");
				if (validationsNode.isArray() && validationsNode.size() > 0) {
					sqlScript.append(" ").append(generateValidations(validationsNode));
				}

				sqlScript.append(",\n");
			}

			sqlScript.deleteCharAt(sqlScript.lastIndexOf(",")); // Remove the last comma
			sqlScript.append(");\n");

			log.info("Entity Name: " + entityName);
			log.info("Table Name: " + tableName);
			log.info("SQL Script:\n" + sqlScript.toString());
			return sqlScript.toString();
		} catch (Exception e) {
			log.info("error in generating sql script");
		}
		return sqlScript.toString();
	}

	/**
	 * 
	 * @param validationsNode
	 * @return
	 */
	private static String generateValidations(JsonNode validationsNode) {
		StringBuilder validations = new StringBuilder();
		for (JsonNode validationNode : validationsNode) {
			String validation = validationNode.asText();
			validations.append(validation).append(" ");
		}
		return validations.toString().trim();
	}
}
