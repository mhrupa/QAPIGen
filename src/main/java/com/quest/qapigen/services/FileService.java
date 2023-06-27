package com.quest.qapigen.services;

import java.io.IOException;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Service;

import com.quest.qapigen.utils.FileUtils;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FileService {
	public static void createFile(String[] args) {
		String filePath = "/path/to/file.txt";
		String content = "Hello, World!";

		try {
			FileUtils.writeToFile(filePath, content);
			log.info("Content written to the file successfully.");
		} catch (IOException e) {
			log.error("Error writing to the file: " + ExceptionUtils.getStackTrace(e));
		}
	}
}
