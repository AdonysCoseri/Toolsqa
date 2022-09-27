package com.example.StepDefinitions;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.xml.transform.sax.SAXSource;
import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class StepDefAlerts {

        WebDriver driver = null;
        @Given("^user is on ToolsqA main page$")
        public void user_is_on_ToolsqA_main_page() throws InterruptedException {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
            driver = new ChromeDriver();

            driver.get("https://demoqa.com/");
            String ActualTitle = driver.getTitle();
            Assert.assertEquals("ToolsQA", ActualTitle);
            Thread.sleep(500);
            driver.manage().window().maximize();
            Thread.sleep(1500);
        }
        @When("^user clicks on Alerts button$")
        public void user_clicks_on_Alerts_button(){
            WebElement alerts = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div[3]"));
            alerts.click();
        }
        @Then("^it opens five more options$")
        public void it_opens_five_more_options() throws InterruptedException {


            Thread.sleep(2000);
        }
        @Given("^user clicks on BW$")
        public void user_clicks_on_BW(){

            WebElement bw = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[3]/div/ul/li[1]"));
            bw.click();
            // driver.get("https://demoqa.com/browser-windows");
        }
        @When("^user clicks new tab$")
        public void user_clicks_new_tab() throws InterruptedException {

            String originalWindow = driver.getWindowHandle();
            WebElement Tab = driver.findElement(By.id("tabButton"));
            Tab.click();
            driver.getWindowHandles().forEach(tab -> driver.switchTo().window(tab));
            WebElement text = driver.findElement(By.id("sampleHeading"));
            Assert.assertEquals(text.getText(),"This is a sample page");
            Thread.sleep(2000);
            driver.close();
            driver.switchTo().window(originalWindow);
            System.out.println(driver.getCurrentUrl());

        }
        @Then("^user clicks new window$")
        public void user_clicks_new_window() throws InterruptedException {

            String originalWindow = driver.getWindowHandle();
            WebElement window = driver.findElement(By.id("windowButton"));
            window.click();
            driver.getWindowHandles().forEach(win -> driver.switchTo().window(win));
            driver.manage().window().maximize();
            Thread.sleep(2000);
            driver.close();
            driver.switchTo().window(originalWindow);
            System.out.println(driver.getCurrentUrl());


        }
        @Then("^user click window message$")
        public void user_click_window_message(){

            String originalWindow = driver.getWindowHandle();
            WebElement wmes = driver.findElement(By.id("messageWindowButton"));
            wmes.click();
        }
        @Given("^user clicks on alerts$")
        public void user_clicks_on_alerts(){
            WebElement alert = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[3]/div/ul/li[2]"));
            alert.click();
            Assert.assertEquals(driver.getCurrentUrl(),"https://demoqa.com/alerts");
        }
        @Then("^click on alert$")
        public void click_on_alert() throws InterruptedException {
            WebElement alertButton = driver.findElement(By.id("alertButton"));
            alertButton.click();
            Alert alert = driver.switchTo().alert();
            Assert.assertEquals(alert.getText(),"You clicked a button");
            Thread.sleep(2000);
            alert.accept();
        }
        @And("^click on timerAlert$")
        public void click_on_timerAlert() throws InterruptedException {
            WebElement timerAlertButton = driver.findElement(By.id("timerAlertButton"));
            timerAlertButton.click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.alertIsPresent());
            Alert tAlert = driver.switchTo().alert();
            Thread.sleep(2000);
            tAlert.accept();
            System.out.println("clicked the timed alert");
        }
        @Then("^clicks on confirmAlert$")
        public void clicks_on_confirmAlert() throws InterruptedException {
            WebElement confirmBtn = driver.findElement(By.id("confirmButton"));
            confirmBtn.click();
            Alert confirmAlert = driver.switchTo().alert();
            Thread.sleep(2000);
            confirmAlert.accept();
            WebElement succesText = driver.findElement(By.id("confirmResult"));
            Assert.assertEquals(succesText.getText(),"You selected Ok");

        }
        @Then("^clicks on prompt box$")
        public void clicks_on_prompt_box() throws InterruptedException {
            WebElement promptBtn = driver.findElement(By.id("promtButton"));
            promptBtn.click();
            Alert promptAlert  = driver.switchTo().alert();
            String alertText = promptAlert.getText();
            System.out.println("Alert text is " + alertText);
            Thread.sleep(2000);
            promptAlert.sendKeys("Bob Vance");
            Thread.sleep(2000);
            promptAlert.accept();
            WebElement promptTxt = driver.findElement(By.id("promptResult"));
            Assert.assertEquals(promptTxt.getText(),"You entered Bob Vance");

        }
        @Given("^user clicks on modal dialogs$")
        public void user_clicks_on_modal_dialogs(){

            WebElement ModalDialogs = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[3]/div/ul/li[5]"));
            ModalDialogs.click();
            Assert.assertEquals(driver.getCurrentUrl(),"https://demoqa.com/modal-dialogs");
        }
        @Then("^click small modal$")
        public void click_small_modal() throws InterruptedException {
            WebElement sModalbtn = driver.findElement(By.id("showSmallModal"));
            sModalbtn.click();
            Thread.sleep(2000);
            WebElement smodal = driver.findElement(By.className("modal-content"));
            WebElement smodalBody = driver.findElement(By.className("modal-body"));
            Assert.assertEquals(smodalBody.getText(),"This is a small modal. It has very less content", "Verify small modal body text");
            WebElement sClose = smodal.findElement(By.id("closeSmallModal"));
            Thread.sleep(2000);
            sClose.click();
        }
        @And("^click large modal$")
        public void click_large_modal() throws InterruptedException {
            String sample_text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
            WebElement lModalbtn = driver.findElement(By.id("showLargeModal"));
            Thread.sleep(2000);
            lModalbtn.click();
            WebElement lmodal = driver.findElement(By.className("modal-content"));
            WebElement lmodalBody = lmodal.findElement(By.className("modal-body"));
            Assert.assertEquals(lmodalBody.getText(),sample_text,"Verify Large modal body text");
            WebElement lClose = lmodal.findElement(By.id("closeLargeModal"));
            Thread.sleep(2000);
            lClose.click();

        }


}
