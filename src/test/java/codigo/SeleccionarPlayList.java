package codigo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SeleccionarPlayList {

    public static void main(String[] args) throws InterruptedException {
        String rutaDriver = "C:\\Users\\juan.brizuela\\Desktop\\InteliJ\\ExampleSelenium3\\src\\test\\resources\\chromedriver.exe";

        System.setProperty("webdriver.chrome.driver",rutaDriver);

        //inicializamos el objeto webDriver de chrome, para manejar los localizadores
        WebDriver driver = new ChromeDriver();

        driver.get("https://open.spotify.com/intl-es?");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(100,TimeUnit.SECONDS);

        //Boton iniciar Sesion
        By locatorBtnLogin = By.xpath("(//button[@class='Button-sc-qlcn5g-0 fyugtm'])[2]");
        driver.findElement(locatorBtnLogin).click();
        Thread.sleep(1000);

        //Login
        By locatorInputEmail = By.id("login-username");
        driver.findElement(locatorInputEmail).sendKeys("Juan.brizuela@hotmail.com");
        By locatorInputContrasenia = By.id("login-password");
        driver.findElement(locatorInputContrasenia).sendKeys("CursoSelenium22!");

        //BtnRecordarme más BtnLogin Spotify
        By locatorBtnRecordarme = By.xpath("//span[@class='Wrapper-sc-16y5c87-0 imHfsA']");
        driver.findElement(locatorBtnRecordarme).click();

        By locatorBtnLogin2 = By.id("login-button");
        driver.findElement(locatorBtnLogin2).click();


        /*
        //Selección de primer PlayList que aparezca
        By locatorBtnPlayList1 = By.xpath("(//div[@class='LunqxlFIupJw_Dkx6mNx'])[1]");
        driver.findElement(locatorBtnPlayList1).click();
        Thread.sleep(4000); */

        //Seleccionar Play List Argentina
        By locatorBtnPlayListArg = By.xpath("//a[@href='/playlist/37i9dQZF1DXbbu94YBG7Ye']");
        driver.findElement(locatorBtnPlayListArg).click();

        //Extraer texto deseado de la play list buscada
        String mensaje = driver.findElement(By.xpath("//span[@class='rEN7ncpaUeSGL9z0NGQR']")).getText();
        System.out.println("Mensaje: "+mensaje);


        //Btn Play a la lista
        By locatorBtnPlay = By.xpath("//button[@class='Button-sc-qlcn5g-0 hCReiC']");
        driver.findElement(locatorBtnPlay).click();
        Thread.sleep(7000);

        //Btn Stop a la lista
        By locatorBtnStop= By.xpath("//button[@class='Button-sc-qlcn5g-0 hCReiC']");
        driver.findElement(locatorBtnStop).click();


        //Btn Pagina principal
        By locatorBtnPaginaPrincipal = By.xpath("(//ul/li[@class='LU0q0itTx2613uiATSig InvalidDropTarget'])[1]");
        driver.findElement(locatorBtnPaginaPrincipal).click();
        Thread.sleep(3000);

        //Btn Buscar
        By locatorBtnBuscar = By.xpath("(//ul/li[@class='LU0q0itTx2613uiATSig InvalidDropTarget'])[2]");
        driver.findElement(locatorBtnBuscar).click();


        //Ingresar texto en el campo Buscar
        By locatorInputBuscar = By.xpath("//input[@class='Type__TypeElement-sc-goli3j-0 ieTwfQ QO9loc33XC50mMRUCIvf']");
        driver.findElement(locatorInputBuscar).sendKeys("Top 50 mas escuchado Chile");

        //Extraer texto deseado de la play list buscada
        String mensaje2 = driver.findElement(By.xpath("//a[@class='Nqa6Cw3RkDMV8QnYreTr']")).getText();
        System.out.println("Mensaje: "+mensaje2);


        driver.quit();

    }

}
