package BE;

import Methods.functions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by subramanian.s on 2/26/2016.
 */

    /**
     * Created by subramanian.s on 1/21/2016.
     */
public class APTC {


        public static void main(String[] args) {
            String sIncome = "65000";
            String sZip = "15480";
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
            functions functions = new functions();
            functions.enterZip(driver, sZip);
            String sZipCode = driver.findElement(By.id("Zip")).getAttribute("value");

            //input personal details.
            driver.findElement(By.id("FirstName")).sendKeys("Test");
            driver.findElement(By.xpath("//div[@id='Gender_chzn']")).click();
            driver.findElement(By.xpath("//div[@id='Gender_chzn']//input[@type ='text']")).sendKeys("Male");
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.ENTER).build().perform();
            driver.findElement(By.id("DateOfBirth")).click();
            driver.findElement(By.id("DateOfBirth")).sendKeys("01/01/1980");
            driver.findElement(By.id("addSpouse")).click();
//Add Spouse
            driver.findElement(By.id("AdditionalFamilyMembers_0__FirstName")).sendKeys("Missus");
            driver.findElement(By.xpath("//div[@id='AdditionalFamilyMembers_0__Gender_chzn']")).click();
            driver.findElement(By.xpath("//div[@id='AdditionalFamilyMembers_0__Gender_chzn']//input[@type ='text']")).sendKeys("Female");
            // Actions actions = new Actions(driver);
            actions.sendKeys(Keys.ENTER).build().perform();
            driver.findElement(By.id("AdditionalFamilyMembers_0__DateOfBirth")).click();
            driver.findElement(By.id("AdditionalFamilyMembers_0__DateOfBirth")).sendKeys("01/01/1986");
            driver.findElement(By.id("addDependents")).click();
            //Add Dependent
            driver.findElement(By.id("AdditionalFamilyMembers_1__FirstName")).sendKeys("Child");
            driver.findElement(By.xpath("//div[@id='AdditionalFamilyMembers_1__Gender_chzn']")).click();
            driver.findElement(By.xpath("//div[@id='AdditionalFamilyMembers_1__Gender_chzn']//input[@type ='text']")).sendKeys("Female");
            // Actions actions = new Actions(driver);
            actions.sendKeys(Keys.ENTER).build().perform();
            driver.findElement(By.id("AdditionalFamilyMembers_1__DateOfBirth")).click();
            driver.findElement(By.id("AdditionalFamilyMembers_1__DateOfBirth")).sendKeys("01/01/2006");
//click check eligibility
            driver.findElement(By.id("personalInfo")).click();
//Enter Income
            driver.findElement(By.id("EstimatedIncome")).sendKeys(sIncome);
//Calculate APTC
            driver.findElement(By.id("sudsidyCalcuatorBtn")).click();
//Get APTC value
            boolean sEstimatedAPTC = driver.findElement(By.xpath("//table[@class='minimal_table']")).isDisplayed();

            //driver.findElement(By.id("lblAPTCMonthly")).getAttribute("span");


            WebElement aptc = driver.findElement(By.id("lblAPTCMonthly"));
            WebDriverWait wait = new WebDriverWait(driver, 10);

            WebElement element = wait.until(ExpectedConditions.visibilityOf(aptc));
            String please = aptc.getText();
            driver.quit();
            functions.writeFile("BE");

//---------------------------------------------------------------------------------------------------
  /*aptc from ffm site*/

//----------------------------------------------------------------------------------------------------------------


        }
    }