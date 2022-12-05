package dataProvider;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import constants.Constant;
import enums.DriverType;
import enums.EnvironmentType;

public class ConfigFileReader {
	
	private Properties properties; 
	
	public ConfigFileReader() {
		
		InputStream dataStream;

		try {
			dataStream = getClass().getClassLoader()
						.getResourceAsStream(Constant.FileReaderConstant.CONFIGURATION_FILE);

			properties = new Properties();
			
			try {
				properties.load(dataStream);
				dataStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (Exception  e) {
		    e.printStackTrace();
		}
	}
	
	public String getUserName() {
		
		String userName = properties.getProperty(Constant.FileReaderConstant.USERNAME);
		
		if (userName != null) {
			return userName;
		} else {
			throw new RuntimeException("username not specified in the config.properties file.");		
		}
	}
	
	public String getPassword() {		
		
		String password = properties.getProperty(Constant.FileReaderConstant.PASSWORD);
		
		if (password != null) {
			return password;
		} else {
			throw new RuntimeException("password not specified in the config.properties file.");		
		}
	}
	
	public String getApplicationUrl() {
		
		String url = properties.getProperty(Constant.FileReaderConstant.URL);
		
		if (url != null) {
			return url;
		} else {
			throw new RuntimeException("url not specified in the config.properties file.");
		}
	}
	
	public long getImplicitWait() {
		
		String implicitWait = properties.getProperty(Constant.FileReaderConstant.IMPLICIT_WAIT);
		
		if (implicitWait != null) {
			try {
				return Long.parseLong(implicitWait);
			} catch (NumberFormatException e) {
				throw new RuntimeException("Not able to parse value : " 
											+ implicitWait + " in to Long");
			}
		}
		
		return 30;		
	}
	
	public long getExplicitWait() {
		
		String explicitWait = properties.getProperty(Constant.FileReaderConstant.EXPLICIT_WAIT);
		
		if (explicitWait != null) {
			try {
				return Long.parseLong(explicitWait);
			} catch (NumberFormatException e) {
				throw new RuntimeException("Not able to parse value : " 
											+ explicitWait + " in to Long");
			}
		}
		
		return 30;		
	}
	
	public DriverType getBrowser() {
		
		String browserName = properties.getProperty(Constant.FileReaderConstant.BROWSER);
		
		if (browserName == null || browserName.equals(Constant.FileReaderConstant.CHROME)) {
			return DriverType.CHROME;
		} else if (browserName.equalsIgnoreCase(Constant.FileReaderConstant.FIREFOX)) {
			return DriverType.FIREFOX;
		} else if (browserName.equals(Constant.FileReaderConstant.IEXPLORER)) {
			return DriverType.INTERNET_EXPLORER;
		} else {
			throw new RuntimeException("Browser Name Key value in config.properties is not matched : " 
										+ browserName);
		}
	}
	
	public EnvironmentType getEnvironment() {
		
		String environmentName = properties.getProperty(Constant.FileReaderConstant.ENVIRONMENT);
		
		if (environmentName == null 
				|| environmentName.equalsIgnoreCase(Constant.FileReaderConstant.LOCAL)) {
			return EnvironmentType.LOCAL;
		} else if (environmentName.equals(Constant.FileReaderConstant.REMOTE)) {
			return EnvironmentType.REMOTE;
		} else {
			throw new RuntimeException("Environment Type Key value in config.properties is not matched : " 
										+ environmentName);
		}
	}
	
	public Boolean getBrowserWindowSize() {
		
		String windowSize = properties.getProperty(Constant.FileReaderConstant.WINDOW_MAXIMIZED);
		
		if (windowSize != null) {
			return Boolean.valueOf(windowSize);
		}
		
		return true;
	}
}