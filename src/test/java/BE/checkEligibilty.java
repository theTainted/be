package BE;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by subramanian.s on 1/21/2016.
 */
public class checkEligibilty {
    public static void main(String[] args){
        WebDriver driver = new FirefoxDriver();
        driver.get("https://be-qa.benefitalign.com/BrokerEngage/TCQA");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        boolean bValue =driver.findElement(By.partialLinkText("Individuals")).isDisplayed();
     /*  boolean bValue =  driver.findElement(By.xpath("//div[@class='ui-dialog-buttonset']//button[@type='button']")).isDisplayed();;
        System.out.println(bValue);
*/
        if (bValue = true){
            driver.findElement(By.partialLinkText("Individuals")).click();

            driver.findElement(By.xpath("//div[@class='ui-dialog-buttonset']//button[@type='button']")).click();
            System.out.println("true");
        }

    }
}
