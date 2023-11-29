package utils;


import driver.DriverContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


import java.nio.charset.StandardCharsets;

public class MetodosGenericos {


    public static String correjirFormato(String textoIncorrecto){
        byte[] bytes= textoIncorrecto.getBytes(StandardCharsets.UTF_8);
        String textoCorrejido = new String(bytes,StandardCharsets.ISO_8859_1 );
        return textoCorrejido;
    }

    //Scroll a un elemento
    public static void scrollElement(WebElement element){
        Actions actions = new Actions(DriverContext.getDriver());
        actions.moveToElement(element);
        actions.perform();
    }

}
