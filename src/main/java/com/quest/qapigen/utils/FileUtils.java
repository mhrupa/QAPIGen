package com.quest.qapigen.utils;

import static com.quest.qapigen.constants.ApplicationConstants.OUTPUT_FOLDER;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {

	public static void writeToFile(String filePath, StringBuilder content) throws IOException {
		File dir = new File(OUTPUT_FOLDER);
		dir.mkdirs();

		// Write the controller code to a file
		FileWriter writer = new FileWriter(filePath);
		writer.write(content.toString());
		writer.flush();
		writer.close();
	}
}
