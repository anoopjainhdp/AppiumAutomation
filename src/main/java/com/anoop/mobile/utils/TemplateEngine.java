/**
 * 
 */
package com.anoop.mobile.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ajain
 *
 */
public class TemplateEngine {

	/**
	 * 
	 */
	public TemplateEngine() {
		// TODO Auto-generated constructor stub
	}

	public static void addFile(String templateFileName, String folderPathInProject, String fileName) {
		String templateFolderpath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
				+ File.separator + "resources" + File.separator + "template";
		String templateDirCreateCommand = "mkdir -p " + folderPathInProject;
		String templateFileCopyCommand = "cp " + templateFolderpath + File.separator + templateFileName + " "
				+ folderPathInProject + File.separator + fileName;

		Process p;
		try {
			p = Runtime.getRuntime()
					.exec(new String[] { "/bin/sh", "-c", templateDirCreateCommand + ";" + templateFileCopyCommand });
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String s;
			while ((s = stdInput.readLine()) != null) {
				System.out.println(s);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
