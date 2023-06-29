package com.quest.qapigen.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.quest.qapigen.constants.ApplicationConstants;
import com.quest.qapigen.dto.Entity;
import com.quest.qapigen.dto.PayloadRequest;
import com.quest.qapigen.dto.Property;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FlywayCodeGenService {

	/**
	 * 
	 * @param payloadRequest
	 */
	public void generateFlywayCode(PayloadRequest requestPayload) {
		log.info("Flyway Code generation started");
		String folderName = ApplicationConstants.OUTPUT_FOLDER + ApplicationConstants.PATH_DELIMETER
				+ "flyway-migrations";
		String fileName = "V1_1.0_" + "rename_script " + ".sql";
		String fileContent = generateSqlScript(requestPayload.getEntity());

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
	private static String generateSqlScript(Entity entity) {

		StringBuilder sqlScript = new StringBuilder();
		try {
			String entityName = entity.getEntityName();
			List<Property> properties = entity.getProperties();

			List<String> propertyNames = new ArrayList<>();
			List<String> propertyTypes = new ArrayList<>();

			for (Property property : properties) {
				String propertyName = property.getPropertyName();
				String propertyType = property.getPropertyType();

				propertyNames.add(propertyName);
				propertyTypes.add(propertyType);
			}

			sqlScript.append("CREATE TABLE ").append(entityName).append(" (\n");

			for (int i = 0; i < propertyNames.size(); i++) {
				String propertyName = propertyNames.get(i);
				String propertyType = propertyTypes.get(i);

				sqlScript.append("\t").append(propertyName).append(" ").append(propertyType).append(",\n");
			}

			// Remove the last comma
			sqlScript.deleteCharAt(sqlScript.lastIndexOf(","));
			sqlScript.append(");\n");

			log.info("SQL Script:\n" + sqlScript.toString());
		} catch (Exception e) {
			log.info("error in generating sql script" + e);
		}
		return sqlScript.toString();
	}
}
