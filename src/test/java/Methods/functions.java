package Methods;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


/**
 * Created by subramanian.s on 2/26/2016.
 */
public class functions {
public WebDriver driver;
    public String sZipCode;
    public String sAPTC;
    public void enterZip(WebDriver driver, String sZip){
        driver.findElement(By.id("Zip")).clear();
        driver.findElement(By.id("Zip")).sendKeys(sZip);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB).build().perform();
    }
    public void writeFile (String sEnv){

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
}
