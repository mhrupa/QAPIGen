package com.quest.qapigen.services;

import java.io.IOException;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Service;

import com.quest.qapigen.utils.ZipUtils;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ZipService {

	public void createZip(String sourceFolderPath, String destinationZipPath) {
		// String sourceFolderPath = "/path/to/source/folder";
		// String destinationZipPath = "/path/to/destination/archive.zip";

		try {
			ZipUtils.createZip(sourceFolderPath, destinationZipPath);
			log.info("ZIP file created successfully.");
		} catch (IOException e) {
			log.error("Error creating ZIP file: " + ExceptionUtils.getStackTrace(e));
		}
	}
}
