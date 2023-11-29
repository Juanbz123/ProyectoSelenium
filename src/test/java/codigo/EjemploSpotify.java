package codigo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import utils.MetodosGenericos;

import java.util.concurrent.TimeUnit;

public class EjemploSpotify {

    public static void main(String[] args){
        String rutaDriver = "C:\\Users\\juan.brizuela\\Desktop\\InteliJ\\ExampleSelenium3\\src\\test\\resources\\Edge\\msedgedriver.exe";
        System.setProperty("webdriver.edge.driver",rutaDriver);


        //inicializamos el objeto webDriver de chrome, para manejar los localizadores
        WebDriver driver = new EdgeDriver();
        driver.get("https://open.spotify.com/intl-es?");
        driver.manage().window().maximize();


        //Espera implicita para localizar los elementos
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Espera implicita para esperar que la pagina cargue correctamente
        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
        //Espera implicita para la carga de los script de la pagina
        driver.manage().timeouts().setScriptTimeout(100,TimeUnit.SECONDS);
        //Thear.sleep() es una condición implicita también


        driver.findElement(By.xpath("//button[contains(text(),'Reg')]")).click();

        driver.findElement(By.partialLinkText("Usar el n")).click();

        driver.findElement(By.id("phonelogin-phonenumber")).sendKeys("380491548211349");

        driver.findElement(By.id("phonelogin-button")).click();

        //Explicit wait (Esperar a que aparezca un determinado elemento siempre y cuando cumpla alguna condición "EJ: Bton desactivado")
/*
        WebDriverWait espera = new WebDriverWait(driver,10);
        WebElement element = espera.until(ExpectedConditions.elementToBeClickable(By.id("phonelogin-button")));
*/

        //Validamos el texto de una advertencia que sea el esperado
        String resultadoEsperado = "Verifica tu número de teléfono.";
        String resultadoActual = MetodosGenericos.correjirFormato(driver.findElement(By.xpath("//span[@class='Message-sc-15vkh7g-0 dHbxKh']")).getText());
        //Comparamos resultados
        //Assertions.assertEquals(resultadoEsperado,MetodosGenericos.correjirFormato(resultadoActual));

        System.out.println("Esperado: "+resultadoEsperado);
        System.out.println("Actual: "+resultadoActual);
        //Validamos si resultado actual es igual al esperado
        if (resultadoActual.equalsIgnoreCase(resultadoEsperado)){
            System.out.println("Resultado OK");
            driver.quit();
        }

    }

}
