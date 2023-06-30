package com.quest.qapigen.utils;

import java.io.*;
import java.util.zip.*;

public class ZipUtils {
	
	ZipUtils(){}

	/**
	 * Create a Zip file
	 * 
	 * @param sourceFolderPath
	 * @param destinationZipPath
	 * @throws IOException
	 */
	public static void createZip(String sourceFolderPath, String destinationZipPath) throws IOException {
		FileOutputStream fos = new FileOutputStream(destinationZipPath);
		ZipOutputStream zipOut = new ZipOutputStream(fos);

		File fileToZip = new File(sourceFolderPath);

		zipFile(fileToZip, fileToZip.getName(), zipOut);

		zipOut.close();
		fos.close();
	}

	/**
	 * Code to zip the contents
	 * 
	 * @param fileToZip
	 * @param fileName
	 * @param zipOut
	 * @throws IOException
	 */
	private static void zipFile(File fileToZip, String fileName, ZipOutputStream zipOut) throws IOException {
		if (fileToZip.isHidden()) {
			return;
		}
		if (fileToZip.isDirectory()) {
			if (fileName.endsWith("/")) {
				zipOut.putNextEntry(new ZipEntry(fileName));
				zipOut.closeEntry();
			} else {
				zipOut.putNextEntry(new ZipEntry(fileName + "/"));
				zipOut.closeEntry();
			}
			File[] children = fileToZip.listFiles();
			for (File childFile : children) {
				zipFile(childFile, fileName + "/" + childFile.getName(), zipOut);
			}
			return;
		}
		FileInputStream fis = new FileInputStream(fileToZip);
		ZipEntry zipEntry = new ZipEntry(fileName);
		zipOut.putNextEntry(zipEntry);

		byte[] bytes = new byte[1024];
		int length;
		while ((length = fis.read(bytes)) >= 0) {
			zipOut.write(bytes, 0, length);
		}
		fis.close();
	}
}
