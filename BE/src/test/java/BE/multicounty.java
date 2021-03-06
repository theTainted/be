package BE;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by subramanian.s on 2/29/2016.
 */
public class multicounty {


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
            try {
                //  driver.findElement(By.xpath("//div[@id='dialogSep']//button[contains(text(),Continue)]")).click();
                Actions actions = new Actions(driver);
                actions.sendKeys(Keys.ESCAPE).build().perform();

                System.out.println("Continue button >> true");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        driver.findElement(By.id("Zip")).clear();
        driver.findElement(By.id("Zip")).sendKeys("60007");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB).build().perform();
        Select se = new Select(driver.findElement(By.id("spanCounty")));

        List<WebElement> l = se.getOptions();
       System.out.println(l.size());
        if(l.size() >2 ){
            driver.findElement(By.id("spanCounty")).click();
           se.selectByIndex(1);

            actions.sendKeys(Keys.RETURN).build().perform();

        }

       // String sText = driver.findElement(By.id("spanCounty")).getText();
      // System.out.println(sText);


    }
}

