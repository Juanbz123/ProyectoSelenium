package codigo;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.MetodosGenericos;

import java.util.concurrent.TimeUnit;

public class EjemploBancoBCI {

    public static void main(String[] args) throws InterruptedException {



        String rutaDriver = "C:\\Users\\juan.brizuela\\Desktop\\InteliJ\\ExampleSelenium3\\src\\test\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",rutaDriver);
        //inicializamos el objeto webDriver de chrome, para manejar los localizadores
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.bci.cl/personas");
        driver.manage().window().maximize();

        //Espera implicita
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(100,TimeUnit.SECONDS);

        //Click botton hazte socio
        driver.findElement(By.xpath("//button[@class='btn btn-sm btn-primary']")).click();
        //Espera explicita para localizar un elemento
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Abrir plan cu')]")));
        element.click();

        //Localizamos el IFRAME
        WebElement iframe = driver.findElement(By.xpath("//iframe[@class='height-2']"));
        driver.switchTo().frame(iframe);
        //driver.switchTo().defaultContent();

      /*  //Inicializamos la clase Actions
        Actions actions = new Actions(driver);
        actions.moveToElement(iframe).perform();*/


        //Rellenamos los datos del IFRAME
        driver.findElement(By.id("names")).sendKeys("Juan");
        driver.findElement(By.id("apellidoPaterno")).sendKeys("Benitez");
        driver.findElement(By.id("apellidoMaterno")).sendKeys("Brizuel");

        driver.findElement(By.name("rut")).sendKeys("22345621");
        driver.findElement(By.id("selectPoliza")).sendKeys("45895762");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,100)", "");
        WebElement locatorEmail = driver.findElement(By.id("correoElectronico"));
        locatorEmail.sendKeys("juanB@hotmail.com");

        Thread.sleep(7000);
        By locatorBTNCheck = By.id("checkPrivacidad");
        WebElement btnCheck = driver.findElement(locatorBTNCheck);

        //Scroll a un elemento visible
        js.executeScript("arguments[0].scrollIntoView();",btnCheck);
        btnCheck.click();

        //JavaScripExecutor
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,200)", "");


        Thread.sleep(4000);
        driver.findElement(By.id("botonOculto")).click();

        String resultadoEsperado = "Tu código de seguimiento es";
        String resultadoActual = MetodosGenericos.correjirFormato(driver.findElement(By.xpath("//p[@class='cod-seguimiento']")).getText());

        System.out.println("Esperado: "+resultadoEsperado);
        System.out.println("Actual: "+resultadoActual);
        //Validamos si resultado actual es igual al esperado
        if (resultadoActual.equalsIgnoreCase(resultadoEsperado)){
            System.out.println("Resultado OK");
            driver.quit();
        }else{
            System.out.println("La persona ya fue registrada");
        }

//        Robot robot = new Robot();


    }

}
