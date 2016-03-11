package BE;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

/**
 * Created by subramanian.s on 1/21/2016.
 */
public class checkEligibilty  {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://be-qa.benefitalign.com/BrokerEngage/TCQA");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        boolean bValue = driver.findElement(By.partialLinkText("Individuals")).isDisplayed();
     /*  boolean bValue =  driver.findElement(By.xpath("//div[@class='ui-dialog-buttonset']//button[@type='button']")).isDisplayed();;
        System.out.println(bValue);
*/
        if (bValue = true) {

            driver.findElement(By.partialLinkText("Individuals")).click();
            boolean bValue1 = driver.findElement(By.xpath("//div[@class='ui-dialog-buttonset']")).isDisplayed();
            System.out.println(bValue1);
           /* if (driver.findElement(By.xpath("//div[@class='ui-dialog-buttonset']//button[@type='button']")).isDisplayed()==true) {
                driver.findElement(By.xpath("//div[@class='ui-dialog-buttonset']//button[@type='button']")).click();
            }*/
           try{
              //  driver.findElement(By.xpath("//div[@id='dialogSep']//button[contains(text(),Continue)]")).click();
               Actions actions = new Actions(driver);
               actions.sendKeys(Keys.ESCAPE).build().perform();

                System.out.println("Continue button >> true");
            }
           catch (Exception e){
               e.printStackTrace();
           }

        }
        driver.findElement(By.id("Zip")).clear();
        driver.findElement(By.id("Zip")).sendKeys("87001");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB).build().perform();

    }
}