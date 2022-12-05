package managers;

import dataProvider.ConfigFileReader;

public class FileReaderManager {

	private static FileReaderManager fileReaderManager = new FileReaderManager();
	private static ConfigFileReader configFileReader;

	private FileReaderManager() {
	}

	//Use this to access other public methods of this class
	public static FileReaderManager getInstance() {
		
		return fileReaderManager;
	}

	public ConfigFileReader getConfigReader() {
		
		return (configFileReader == null) ? new ConfigFileReader() : configFileReader;
	}
}