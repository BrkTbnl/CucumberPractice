package Utilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Locale;

public class GWD {

    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    public static ThreadLocal<String> threadBrowserName = new ThreadLocal<>();

    public static WebDriver getDriver() {

        //language settings for non english computers. you need do add it if not extent report won't work.
        Locale.setDefault(new Locale("EN"));
        System.setProperty("user.language", "EN");

        if (threadBrowserName.get() == null) {
            threadBrowserName.set("firefox");
        }

        if (threadDriver.get() == null) {
            switch (threadBrowserName.get()) {
                case "firefox":
                    threadDriver.set(new FirefoxDriver());
                    break;
                case "edge":
                    threadDriver.set(new EdgeDriver());
                    break;
                case "chrome":
                    threadDriver.set(new ChromeDriver());
                    break;
                default:
                    threadDriver.set(new FirefoxDriver());

            }
        }

        threadDriver.get().manage().window().maximize();
        threadDriver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        return threadDriver.get();
    }


    public static void quitDriver() {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if(threadDriver.get()!=null)
        {
            threadDriver.get().quit();

            WebDriver driver = threadDriver.get();
            driver = null;

            threadDriver.set(driver);
        }

    }

}


