package com.quest.qapigen.utils;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quest.qapigen.exceptions.BaseException;
import com.quest.qapigen.exceptions.BadRequestException;

/**
 * Utility class used for json related conversions.
 * 
 * @author RanjanRo
 *
 */
public class JsonUtils {

	public static final String ERROR_STRING = "Invalid JSON received.";

	private JsonUtils() {
	}

	/**
	 * @param object
	 * @return converted object to the json string
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static String toJson(Object object) throws BaseException {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:MM:SS a");
		ObjectMapper mapper = new ObjectMapper();
		mapper.setDateFormat(dateFormat);
		try {
			return mapper.writeValueAsString(object);
		} catch (IOException exception) {
			throw new BadRequestException("Error occured while converting Object to JSON");
		}
	}

	/**
	 * Converts a json String into a java object
	 *
	 * @param jsonString JSON string
	 * @param clazz      class of target entity
	 * @return Instance of class of given type
	 * @throws BaseException
	 */
	public static <T> T fromJson(String jsonString, Class<T> clazz) throws BaseException {
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(jsonString, clazz);
		} catch (IOException exception) {
			throw new BadRequestException(ERROR_STRING);
		}
	}

	/**
	 * Converts a json String into a java object
	 *
	 * @param jsonString JSON string
	 * @param type       class of target entity with template class
	 * @return Instance of class of given type
	 * @throws BaseException
	 */
	public static <T> T fromJson(String jsonString, JavaType type) throws BaseException {
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(jsonString, type);
		} catch (IOException exception) {
			throw new BadRequestException(ERROR_STRING);
		}
	}

	/**
	 * @param jsonString
	 * @param type
	 * @return T
	 * @throws BaseException
	 */
	public static <T> T fromJson(String jsonString, TypeReference<T> type) throws BaseException {
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(jsonString, type);
		} catch (IOException exception) {
			throw new BadRequestException(ERROR_STRING);
		}
	}

	/**
	 * Converts a json String into a java list object
	 * 
	 * @param jsonString JSON string
	 * @param clazz      class of target entity
	 * @return List of Instance of class of given type
	 * @throws BaseException
	 */
	public static <T> List<T> fromJsonList(final String json, Class<T> clazz) throws BaseException {
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, clazz));
		} catch (IOException exception) {
			throw new BadRequestException(ERROR_STRING);
		}

	}
}
