package com.quest.qapigen.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileUtils {

	public static void writeToFile(String filePath, String content) throws IOException {
		// Using FileWriter
		try (FileWriter fileWriter = new FileWriter(filePath)) {
			fileWriter.write(content);
		}

		// Using BufferedWriter
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
			bufferedWriter.write(content);
		}

		// Using Files.write
		Path path = Path.of(filePath);
		Files.write(path, content.getBytes(), StandardOpenOption.CREATE);
	}
}
