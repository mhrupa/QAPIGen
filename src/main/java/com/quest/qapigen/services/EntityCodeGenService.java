package com.quest.qapigen.services;

import java.io.IOException;
import java.util.List;
import static com.quest.qapigen.constants.ApplicationConstants.OUTPUT_FOLDER;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.quest.qapigen.dto.Entity;
import com.quest.qapigen.dto.PayloadRequest;
import com.quest.qapigen.dto.Property;
import com.quest.qapigen.dto.RequestBody;
import com.quest.qapigen.utils.FileUtils;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EntityCodeGenService {

	public void generateEntity(PayloadRequest payloadRequest) throws IOException {
		log.info("Entity & DTO generation started");
		Entity entityRequest = payloadRequest.getEntity();
		RequestBody dtoRequest = payloadRequest.getRequestBody();
		if (!StringUtils.isEmpty(dtoRequest.getDtoName())) {
			StringBuilder dtoCode = generateEntityClass(dtoRequest.getDtoName(), dtoRequest.getProperties());
			// Create the controller directory if it doesn't exist
			writeFile(dtoCode, dtoRequest.getDtoName());
			log.info("DTO generation completed " + dtoCode);
		}
		if (!StringUtils.isEmpty(entityRequest.getEntityName())) {
			StringBuilder entityCode = generateEntityClass(entityRequest.getEntityName(),
					entityRequest.getProperties());
			// Create the controller directory if it doesn't exist
			writeFile(entityCode, entityRequest.getEntityName());
			log.info("Entity generation completed " + entityCode);
		}
	}

	private void writeFile(StringBuilder stringBuilder, String className) throws IOException {
		String controllerFilePath = OUTPUT_FOLDER + "/" + className + ".java";
		FileUtils.writeToFile(controllerFilePath, stringBuilder);
	}

	private static StringBuilder generateEntityClass(String className, List<Property> fields) {
		StringBuilder sb = new StringBuilder();

		// Package declaration (if applicable)
		// sb.append("package com.example.entities;\n\n");

		// Class declaration
		sb.append("public class ").append(className).append(" {\n\n");

		// Fields
		for (Property field : fields) {
			sb.append("    private ").append(field.getPropertyType()).append(" ").append(field.getPropertyName())
					.append(";\n");
		}
		sb.append("\n");

		// Default constructor
		sb.append("    public ").append(className).append("() {\n");
		sb.append("    }\n\n");

		// Parameterized constructor
		sb.append("    public ").append(className).append("(");
		for (int i = 0; i < fields.size(); i++) {
			Property field = fields.get(i);
			sb.append(field.getPropertyType()).append(" ").append(field.getPropertyName());
			if (i < fields.size() - 1) {
				sb.append(", ");
			}
		}
		sb.append(") {\n");
		for (Property field : fields) {
			sb.append("        this.").append(field.getPropertyName()).append(" = ").append(field.getPropertyName())
					.append(";\n");
		}
		sb.append("    }\n\n");

		// Getters and setters
		for (Property field : fields) {
			String capitalizedFieldName = capitalizeFirstLetter(field.getPropertyName());
			sb.append("    public ").append(field.getPropertyType()).append(" get").append(capitalizedFieldName)
					.append("() {\n");
			sb.append("        return ").append(field.getPropertyName()).append(";\n");
			sb.append("    }\n\n");

			sb.append("    public void set").append(capitalizedFieldName).append("(").append(field.getPropertyType())
					.append(" ").append(field.getPropertyName()).append(") {\n");
			sb.append("        this.").append(field.getPropertyName()).append(" = ").append(field.getPropertyName())
					.append(";\n");
			sb.append("    }\n\n");
		}

		// Class closing brace
		sb.append("}");

		return sb;
	}

	private static String capitalizeFirstLetter(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}
}
