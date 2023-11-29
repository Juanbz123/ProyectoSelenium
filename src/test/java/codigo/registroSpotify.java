package codigo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class registroSpotify {

    public static void main(String[] args) throws InterruptedException {

     String rutaDriver = "C:\\Users\\juan.brizuela\\Desktop\\InteliJ\\ExampleSelenium3\\src\\test\\resources\\chromedriver.exe";

     System.setProperty("webdriver.chrome.driver", rutaDriver);

     //Inicializamos el objeto webDriver de chrome, para manejar los localizadores
     WebDriver driver = new ChromeDriver();

     //Metodo get(obtener datos) que nos permite traer una pagina
     driver.get("https://open.spotify.com/intl-es?");
     driver.manage().window().maximize();
     Thread.sleep(3000);

     //Ingresar datos del nuevo usuario
     By locatorBtnInSesion = By.xpath("//button[@class='Button-sc-1dqy6lx-0 eOxaqu sibxBMlr_oxWTfBrEz2G']");
     driver.findElement(locatorBtnInSesion).click();
     Thread.sleep(6000);


     By locatorInputEmail = By.id("username");
     driver.findElement(locatorInputEmail).sendKeys("Juan.brizuela@hotmail.com");
     Thread.sleep(3000);
     By locatorBtnNext = By.xpath("//span[@class='ButtonInner-sc-14ud5tc-0 bhKQRg encore-bright-accent-set']");
     driver.findElement(locatorBtnNext).click();
     Thread.sleep(5000);
     By locatorInputContrasenia = By.id("new-password");
     driver.findElement(locatorInputContrasenia).sendKeys("CursoSelenium22!");
     Thread.sleep(3000);

     By locatorBtnNext2 = By.xpath("//span[@class='ButtonInner-sc-14ud5tc-0 bhKQRg encore-bright-accent-set']");
     driver.findElement(locatorBtnNext2).click();
     Thread.sleep(4000);

     //Hablanos de ti
     By locatorInputName = By.name("displayName");
     driver.findElement(locatorInputName).sendKeys("Juan Zarate");
     Thread.sleep(4000);
     By locatorInputDay = By.id("day");
     driver.findElement(locatorInputDay).sendKeys("13");
     Thread.sleep(4000);
     By locatorSelectMes = By.name("month");
     driver.findElement(locatorSelectMes).click();
     Thread.sleep(4000);

     //Seleccionar un mes de la lista
     WebElement btnMes = driver.findElement(By.xpath("(//*[contains(text(), 'Febrero')])[1]"));
     btnMes.click();
     Thread.sleep(4000);
     By locatorInputAnio = By.name("year");
     driver.findElement(locatorInputAnio).sendKeys("1998");
     Thread.sleep(3000);

     WebElement btnGenero = driver.findElement(By.xpath("(//*[contains(text(), 'Hombre')])[1]"));
     btnGenero.click();
     Thread.sleep(4000);

     By locatorBtnNext3 = By.xpath("//span[@class='ButtonInner-sc-14ud5tc-0 bhKQRg encore-bright-accent-set']");
     driver.findElement(locatorBtnNext3).click();
     Thread.sleep(5000);

     //Terminos y Condiciones
     By locatorCheck1 = By.xpath("(//span[@class='Indicator-sc-1airx73-0 jCsyxi'])[1]");
     driver.findElement(locatorCheck1).click();
     Thread.sleep(4000);
     By locatorCheck2 = By.xpath("(//span[@class='Indicator-sc-1airx73-0 jCsyxi'])[2]");
     driver.findElement(locatorCheck2).click();
     Thread.sleep(5000);

     //Finalizar registro
     By locatorBtnRegistrarte = By.xpath("//button[@class='Button-sc-qlcn5g-0 cKYEKO']");
     driver.findElement(locatorBtnRegistrarte).click();
     Thread.sleep(6000);

    }
}
