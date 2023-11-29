package driver;


import org.openqa.selenium.WebDriver;


public class DriverContext {

  private static DriverManager driverManager = new DriverManager();

    public static WebDriver getDriver() {
        return driverManager.getDriver();
    }

}
