package codigo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.MetodosGenericos;

import java.util.concurrent.TimeUnit;

public class EvaluaciónSelenieumBrizuelaJuan {

    WebDriver driver;
    String rutaDriver = "C:\\Users\\juan.brizuela\\Desktop\\InteliJ\\ExampleSelenium3\\src\\test\\resources\\chromedriver.exe";

    //Before configuración staticas del proyecto, que por lo general no cambian
    @BeforeEach
    public void preCondiciones(){
        System.setProperty("webDriver.chrome.driver",rutaDriver);
        driver = new ChromeDriver();
        driver.get("https://www.papajohns.cl/");
        MetodosGenericos.waitImplicit(10);
        driver.manage().window().maximize();
    }

    @AfterEach
    public void PosCondiciones(){
        driver.quit();
    }

    @Test
    public void CP001_RegistroExitoso(){

    }

    @Test
    public void CP002_InicioSesionNoExitoso(){

    }

    @Test
    public void CP003_InicioSesionExitoso(){

    }

    @Test
    public void CP004_SeleccionarPizza(){

    }

    @Test
    public void CP005_AñadirPizzaCarrito(){

    }
}



