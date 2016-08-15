/**
 * 
 */
package com.anoop.mobile.automation;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import com.anoop.mobile.utils.ConfigEnum;
import com.anoop.mobile.utils.ConfigManager;

/**
 * @author ajain
 *
 */
public class MobileTestProject {

	/**
	 * Create a new mobile test project.
	 */
	public MobileTestProject() {
		createProject();
	}

	private void createProject() {
		String projectHome = ConfigManager.getConfigValue(ConfigEnum.PROJECT_HOME);
		String projectFolderName = ConfigManager.getConfigValue(ConfigEnum.MAVEN_ARTIFACTID);
		String mavenPath = ConfigManager.getConfigValue(ConfigEnum.MAVEN_HOME);

		String projectGroupId = ConfigManager.getConfigValue(ConfigEnum.MAVEN_GROUPID);
		String projectArtifactId = ConfigManager.getConfigValue(ConfigEnum.MAVEN_ARTIFACTID);

		if (projectHome == null)
			projectHome = ".";

		String removeCommandDir = "rm -rf " + projectHome + File.separator + projectFolderName;
		String changeCommandDir = "cd " + projectHome;

		String mavenCommandForNewProject = mavenPath + " archetype:generate -DgroupId=" + projectGroupId
				+ " -DartifactId=" + projectArtifactId + " -DinteractiveMode=false";

		Process p;
		try {
			p = Runtime.getRuntime().exec(new String[] { "/bin/sh", "-c",
					removeCommandDir + ";" + changeCommandDir + " ; " + mavenCommandForNewProject });
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

	/**
	 * Run the tests
	 */
	public void runTests() {
		String projectHome = ConfigManager.getConfigValue(ConfigEnum.PROJECT_HOME);
		String projectFolderName = ConfigManager.getConfigValue(ConfigEnum.MAVEN_ARTIFACTID);
		String mavenPath = ConfigManager.getConfigValue(ConfigEnum.MAVEN_HOME);
		String changeCommandDir = "cd " + projectHome + File.separator + projectFolderName;
		String testRunCommand = mavenPath + " test -Dtest=tests.AppiumTest1";
		Process p;
		try {
			p = Runtime.getRuntime().exec(new String[] { "/bin/sh", "-c", changeCommandDir + " ; " + testRunCommand });
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

	/**
	 * Setup environment
	 */
	public void setupEnvironment() {
		String appiumPath = ConfigManager.getConfigValue(ConfigEnum.APPIUM_HOME);
		Process p;
		try {
			p = Runtime.getRuntime().exec(appiumPath);
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
