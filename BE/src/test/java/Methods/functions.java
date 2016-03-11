package Methods;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


/**
 * Created by subramanian.s on 2/26/2016.
 */
public class functions {
public WebDriver driver;
    public String sZipCode;
    public String sAPTC;
    public void enterZip(WebDriver driver, String sZip) {
        driver.findElement(By.id("Zip")).clear();
        driver.findElement(By.id("Zip")).sendKeys(sZip);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB).build().perform();
        Select se = new Select(driver.findElement(By.id("spanCounty")));

        List<WebElement> l = se.getOptions();
        System.out.println(l.size());
        if (l.size() > 2) {
            driver.findElement(By.id("spanCounty")).click();
            se.selectByIndex(1);

            actions.sendKeys(Keys.RETURN).build().perform();
        }
    }
    public void writeFile (String sEnv,String sZipCode,String sAPTC){

        try {
            File file = new File("C:\\Syam\\APTC.txt");
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("Estimated APTC for Zip for "+ sEnv+ " for  " + sZipCode + ": " + sAPTC);
            bw.newLine();
//           bw.write("\\n");
            bw.close();

            System.out.println("Done");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void aptcSubscriber(WebDriver driver){

        driver.findElement(By.id("FirstName")).sendKeys("Test");
        driver.findElement(By.xpath("//div[@id='Gender_chzn']")).click();
        driver.findElement(By.xpath("//div[@id='Gender_chzn']//input[@type ='text']")).sendKeys("Male");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).build().perform();
        driver.findElement(By.id("DateOfBirth")).click();
        driver.findElement(By.id("DateOfBirth")).sendKeys("01/01/1980");



        }
public void aptcSpouse(WebDriver driver) {
   aptcSubscriber(driver);
    driver.findElement(By.id("addSpouse")).click();
//Add Spouse
    driver.findElement(By.id("AdditionalFamilyMembers_0__FirstName")).sendKeys("Missus");
    driver.findElement(By.xpath("//div[@id='AdditionalFamilyMembers_0__Gender_chzn']")).click();
    driver.findElement(By.xpath("//div[@id='AdditionalFamilyMembers_0__Gender_chzn']//input[@type ='text']")).sendKeys("Female");
  Actions actions = new Actions(driver);
    actions.sendKeys(Keys.ENTER).build().perform();
    driver.findElement(By.id("AdditionalFamilyMembers_0__DateOfBirth")).click();
    driver.findElement(By.id("AdditionalFamilyMembers_0__DateOfBirth")).sendKeys("01/01/1986");
}
 public void aptcOneDependent(WebDriver driver){
aptcSpouse(driver);
     driver.findElement(By.id("addDependents")).click();
     //Add Dependent
     driver.findElement(By.id("AdditionalFamilyMembers_1__FirstName")).sendKeys("Child");
     driver.findElement(By.xpath("//div[@id='AdditionalFamilyMembers_1__Gender_chzn']")).click();
     driver.findElement(By.xpath("//div[@id='AdditionalFamilyMembers_1__Gender_chzn']//input[@type ='text']")).sendKeys("Female");
   Actions actions = new Actions(driver);
     actions.sendKeys(Keys.ENTER).build().perform();
     driver.findElement(By.id("AdditionalFamilyMembers_1__DateOfBirth")).click();
     driver.findElement(By.id("AdditionalFamilyMembers_1__DateOfBirth")).sendKeys("01/01/2006");
 }
public void checkEligibility(){
    driver.findElement(By.id("personalInfo")).click();
}


    }

