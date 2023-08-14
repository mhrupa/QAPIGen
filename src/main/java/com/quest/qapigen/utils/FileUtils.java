package com.quest.qapigen.utils;

import static com.quest.qapigen.constants.ApplicationConstants.OUTPUT_FOLDER;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.quest.qapigen.constants.ApplicationConstants;

public class FileUtils {
	
	FileUtils(){}

	/**
	 * Write content to file
	 * 
	 * @param filePath
	 * @param content
	 * @throws IOException
	 */
	public static void writeToFile(String filePath, StringBuilder content, String folderName) throws IOException {
		String writefilePath = OUTPUT_FOLDER + ApplicationConstants.PATH_DELIMETER + folderName + ApplicationConstants.PATH_DELIMETER + filePath; 
		File dir = new File(OUTPUT_FOLDER + ApplicationConstants.PATH_DELIMETER + folderName);
		dir.mkdirs();

		// Write to a file
		FileWriter writer = new FileWriter(writefilePath);
		writer.write(content.toString());
		writer.flush();
		writer.close();
	}
}
