package utils;


import driver.DriverContext;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;



public class MetodosGenericos {


    public static boolean visualizarObjeto(WebElement elementName, int timeout) {
        try {
            System.out.println("Valida si Es visible el elemento a validar.");
            WebDriverWait wait = new WebDriverWait(DriverContext.getDriver(), Duration.ofSeconds(timeout));
            wait.until(ExpectedConditions.visibilityOf(elementName));
            System.out.println("Es visible el elemento a validar: " + elementName.getText());
            System.out.println("==============================================");
            System.out.println();
            return true;
        } catch (Exception var3) {
            System.out.println("No es visible el elemento a validar. " + var3 );
            return false;
        }
    }


    public static void verificarTexto(WebElement element, String mensaje){
        try{
            String dato = element.getText();
            if(dato.equals(mensaje)){
                Assertions.assertTrue(true, "Se comprueba que texto corresponde al mostrado en FRONT " + mensaje);
            }else {
                Assertions.fail("El texto no corresponde al que se encontro en el FRONT " + mensaje);
            }
        }catch (Exception e) {
            e.printStackTrace();
            Assertions.fail("Se genera el siguiente error, al intentar verificar sección: " + e.getMessage());
        }
    }

    //Scroll a un elemento
    public static void scrollElement(WebElement element){
        Actions actions = new Actions(DriverContext.getDriver());
        actions.moveToElement(element);
        actions.perform();
    }

    public static void click(WebElement element, int timeout){
        try {
            if(MetodosGenericos.visualizarObjeto(element,timeout)){
                System.out.println("se interactua correctamente con el elemento: " + element);
                element.click();
            }
            else {
                Assertions.fail("fallo la interacción con el elemento: " + element);
            }
        }
        catch (UnhandledAlertException e){
            System.out.println("aparecio una alerta inesperada" + e);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
