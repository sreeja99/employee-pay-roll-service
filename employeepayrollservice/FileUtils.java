package com.capgemini.employeepayrollservice;

import java.io.File;
import java.nio.file.Files;

public class FileUtils {

	public static boolean deleteFiles(File filesToDelete) {
		File[] allContents = filesToDelete.listFiles();
		if(allContents!=null) {
			for(File file:allContents) {
				deleteFiles(file);
			}
		}
			return filesToDelete.delete();
		
	}

}
