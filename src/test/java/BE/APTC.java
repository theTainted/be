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

/**
 * Created by subramanian.s on 2/26/2016.
 */

public class APTC {


        public static void main(String[] args) throws InterruptedException {
            functions functions = new functions();
            String sZip = "07001";
            //String sIncome[] ={"17000","20000","25000","30000","40000"};
    String sIncome[] ={"23000","28000","35000","42000","48000"};
       // String sIncome[] ={"29000","35000","41000","52000","65000"};


for (int i=0;i<=4;i++) {

   WebDriver driver = new FirefoxDriver();
      functions.initialise(driver);
 /*driver.get("https://be-qa.benefitalign.com/BrokerEngage/TCQA");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().window().maximize();
*/
    boolean bValue = driver.findElement(By.partialLinkText("Individuals")).isDisplayed();


    if (bValue = true) {

        driver.findElement(By.partialLinkText("Individuals")).click();
        boolean bValue1 = driver.findElement(By.xpath("//div[@class='ui-dialog-buttonset']")).isDisplayed();
        System.out.println(bValue1);

        try {
            //  driver.findElement(By.xpath("//div[@id='dialogSep']//button[contains(text(),Continue)]")).click();
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.ESCAPE).build().perform();

            System.out.println("Continue button >> true");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    functions.enterZip(driver, sZip);
    String sZipCode = driver.findElement(By.id("Zip")).getAttribute("value");
//functions.aptcSubscriber(driver);
// functions.aptcSpouse(driver);
functions.aptcOneDependent(driver);

/*
//click check eligibility
    driver.findElement(By.id("personalInfo")).click();*/
//Enter Income

   driver.findElement(By.id("EstimatedIncome")).sendKeys(sIncome[i]);
/*
//Calculate APTC
    driver.findElement(By.id("sudsidyCalcuatorBtn")).click();*/

    //click check eligibility
    driver.findElement(By.id("personalInfo")).click();
/*Get APTC value
    boolean sEstimatedAPTC = driver.findElement(By.xpath("//table[@class='minimal_table']")).isDisplayed();*/

    //driver.findElement(By.id("lblAPTCMonthly")).getAttribute("span");
/*
    if (driver.findElement(By.id("mesgSpan")).isDisplayed()){
        WebElement text =driver.findElement(By.id("mesgSpan"));
        String zero = text.getText();
        functions.writeFile("BE",sZip,zero);
    }
    */
   // else {
        WebElement aptc = driver.findElement(By.xpath("//div[@id='main2']//div[@class='alert alert-info']/div/b"));
                //driver.findElement(By.id("alert alert-info"));
        //driver.findElement(By.id("lblAPTCMonthly"));
        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement element = wait.until(ExpectedConditions.visibilityOf(aptc));
        String sAPTC = aptc.getText();
        System.out.println(sAPTC);
        driver.quit();


        functions.writeFile("BE", sZip, sAPTC);
   // }
}
//---------------------------------------------------------------------------------------------------
  /*aptc from ffm site*/

//----------------------------------------------------------------------------------------------------------------
    }

 }

