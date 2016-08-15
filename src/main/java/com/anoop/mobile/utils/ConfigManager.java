/**
 * 
 */
package com.anoop.mobile.utils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

/**
 * @author ajain
 *
 */
public class ConfigManager {

	// List of config files.
	// Files in read in order. Same config in lower files will be overwritten.
	// If two file have same config. Config value will be taken from file at
	// location 1 not from location 0.
	private static String[] configFiles = new String[] { "default.config" };

	// Configuration Map
	private static HashMap<String, String> configMap = new HashMap<String, String>();

	// Variable to see if config is already read.
	private static boolean isConfigPopulated = false;

	/**
	 * Reads the configuration from config file.
	 */
	public ConfigManager() {

	}

	/**
	 * Reads the value of configuration from config file
	 */
	public static HashMap<String, String> readConfig() {
		// If config is alread read return that.

		if (isConfigPopulated)
			return configMap;

		// Read the config file in order of element in configFiles.
		int numConfigFiles = configFiles.length;

		for (int i = 0; i < numConfigFiles; i++) {
			String filePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
					+ File.separator + "resources" + File.separator + configFiles[i];
			// Read the file using File Utils
			File f = new File(filePath);
			try {
				List<String> configurationList = FileUtils.readLines(f);

				// Split the configuration and store the value in Hash Map.
				for (String configuration : configurationList) {
					String[] configKeyValue = configuration.split("=");
					String configKey = configKeyValue[0].trim();
					String configVal = configKeyValue[1].trim();
					// Keep the key and value in map. Key may be overwritten.
					configMap.put(configKey, configVal);
				}

			} catch (IOException e) {
				// Exception while reading the file
				// Log the Exception.
				// TODO - Log Exception
				e.printStackTrace();
			}
		}
		isConfigPopulated = true;
		return configMap;
	}

	/**
	 * Reads the value of configuration from config file again. Use this for
	 * reading config again.
	 */
	public static HashMap<String, String> readConfig(boolean force) {
		isConfigPopulated = !force;
		return readConfig();
	}

	/**
	 * Fetch the config value
	 */
	public static String getConfigValue(ConfigEnum configKey) {
		if (!isConfigPopulated)
			readConfig();

		if (configMap.containsKey(configKey.toString()))
			return configMap.get(configKey.toString());
		else
			return null;
	}

}
