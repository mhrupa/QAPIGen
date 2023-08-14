package com.quest.qapigen.services;

import static com.quest.qapigen.constants.ApplicationConstants.OUTPUT_FOLDER;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.quest.qapigen.constants.ApplicationConstants;
import com.quest.qapigen.dto.Entity;
import com.quest.qapigen.dto.PayloadRequest;
import com.quest.qapigen.dto.Property;
import com.quest.qapigen.dto.RequestBody;
import com.quest.qapigen.utils.FileUtils;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EntityCodeGenService {

	/**
	 * Generate data model class
	 * 
	 * @param payloadRequest
	 * @throws IOException
	 */
	public void generateModel(PayloadRequest payloadRequest) throws IOException {
		log.info("Entity & DTO generation started");
		
		RequestBody dtoRequest = payloadRequest.getRequestBody();
		if (!StringUtils.isEmpty(dtoRequest.getDtoName())) {
			StringBuilder dtoCode = generateDataModel(dtoRequest.getDtoName(), dtoRequest.getProperties(),
					ApplicationConstants.DTO);
			// Create the controller directory if it doesn't exist
			writeFile(dtoCode, dtoRequest.getDtoName(), ApplicationConstants.FOLDER_DTO);
			log.info("DTO generation completed " + dtoCode);
		}
		for (int i = 0; i < payloadRequest.getEntity().size(); i++) {
			Entity entityRequest = payloadRequest.getEntity().get(i);
			if (!StringUtils.isEmpty(entityRequest.getEntityName())) {
				StringBuilder entityCode = generateDataModel(entityRequest.getEntityName(),
						entityRequest.getProperties(), ApplicationConstants.ENTITY);
				// Create the controller directory if it doesn't exist
				writeFile(entityCode, entityRequest.getEntityName(), ApplicationConstants.FOLDER_ENTITY);
				log.info("Entity generation completed " + entityCode);
			}
		}
	}

	/**
	 * write file with the content
	 * 
	 * @param stringBuilder
	 * @param className
	 * @throws IOException
	 */
	private void writeFile(StringBuilder stringBuilder, String className, String folderName) throws IOException {
		String controllerFilePath =  className + ".java"; //dto/customer_dto.java
		//folderName + ApplicationConstants.PATH_DELIMETER +
		FileUtils.writeToFile(controllerFilePath, stringBuilder, folderName);
	}

	/**
	 * Generate Model classes
	 * 
	 * @param className
	 * @param fields
	 * @param classType
	 * @return
	 */
	private static StringBuilder generateDataModel(String className, List<Property> fields, String classType) {
		StringBuilder sb = new StringBuilder();

		// adding package declaration
		sb.append("// package").append(";\n\n");

		if (StringUtils.equals(classType, ApplicationConstants.ENTITY)) {
			// adding imports
			sb.append("import jakarta.persistence.*;\n");
		}
		// adding imports
		sb.append("import lombok.*;\n\n");

		// adding required lombok annotations
		sb.append("@Data\n");
		sb.append("@Builder\n");
		sb.append("@NoArgsConstructor\n");
		sb.append("@AllArgsConstructor\n");
		sb.append("@Getter\n");
		sb.append("@Setter\n");
		if (StringUtils.equals(classType, ApplicationConstants.ENTITY)) {
			sb.append("@Table(name = \"rename_table\")\n");
			sb.append("@Entity\n");
		}

		// Class declaration
		sb.append("public class ").append(className).append(" {\n\n");

		// Fields
		for (Property field : fields) {
			sb.append("    private ").append(field.getPropertyType()).append(" ").append(field.getPropertyName())
					.append(";\n");
		}
		sb.append("\n");

		// Class closing brace
		sb.append("}");

		return sb;
	}

}
