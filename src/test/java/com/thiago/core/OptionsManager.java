package com.thiago.core;

import java.io.File;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
 
public class OptionsManager {
 
    //Get Chrome Options
    public ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        //options.setHeadless(true);
        System.setProperty("webdriver.chrome.driver",new File("src/test/resources/chromedriver.exe").getAbsolutePath());
        return options;
    }
 
    //Get Firefox Options
    public FirefoxOptions getFirefoxOptions () {
        FirefoxOptions options = new FirefoxOptions();
        FirefoxProfile profile = new FirefoxProfile();
        //Accept Untrusted Certificates
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(false);
        //Use No Proxy Settings
        profile.setPreference("network.proxy.type", 0);
        //Set Firefox profile to capabilities
        options.setCapability(FirefoxDriver.PROFILE, profile);
        return options;
    }
    public DesiredCapabilities getRemoteDriverChrome() {
    	try {
    		DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
    		desiredCapabilities.setPlatform(Platform.LINUX);
    		desiredCapabilities.setCapability("chrome.verbose", true);
    		return desiredCapabilities;
    	}catch (Exception e) {
			Assert.fail(e.getMessage());
		}
    	return null;
    }	
}