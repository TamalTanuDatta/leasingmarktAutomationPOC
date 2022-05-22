package resources;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

//adding logs
//generating html reports
//screenshots on failure
//jenkins integration
public class Base {

	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {

		//for local Test Run: 
		
		/* prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\leasingMarkt.resources\\data.properties");

		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver");
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			// Firefox
		} else if (browserName.equals("IE")) {
			// IE code
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;*/
		
		//for Hub Run:
		
		String host = "localhost";
        MutableCapabilities mutableCapabilities;

        if (System.getProperty("BROWSER") != null &&
                System.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
            mutableCapabilities = new FirefoxOptions();
        } else {
            mutableCapabilities = new ChromeOptions();
        }

        if (System.getProperty("HUB_HOST") != null) {
            host = System.getProperty("HUB_HOST");
        }


        String completeUrl = "http://" + host + ":4444/wd/hub";
        // mutableCapabilities.setCapability("name");
        this.driver = new RemoteWebDriver(new URL(completeUrl), mutableCapabilities);
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}

	/*public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}*/

}
