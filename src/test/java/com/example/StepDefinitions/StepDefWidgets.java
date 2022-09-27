package com.example.StepDefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StepDefWidgets {
    WebDriver driver = null;

    @Given("^you are on ToolsQA main page$")
    public void you_are_on_ToolsQA_main_page() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();

        driver.get("https://demoqa.com/");
        String ActualTitle = driver.getTitle();
        Assert.assertEquals("ToolsQA", ActualTitle);
        Thread.sleep(500);
        driver.manage().window().maximize();
        Thread.sleep(1500);
    }
    @When("^click on widgets$")
    public void click_on_widgets(){
        WebElement widgetbtn = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div[4]"));
        widgetbtn.click();
    }
    @Then("^it opens the widgets tab$")
    public void it_opens_the_widgets_tab(){
        Assert.assertEquals(driver.getCurrentUrl(),"https://demoqa.com/widgets");
    }

    @Given("^click on auto complete$")
    public void click_on_auto_complete(){
        WebElement autoComplete = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[4]/div/ul/li[2]"));
        autoComplete.click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://demoqa.com/auto-complete");
    }
    @Then("^user writes a single color first letter$")
    public void  user_writes_a_single_color_first_letter() throws InterruptedException {
        WebElement singleField = driver.findElement(By.id("autoCompleteSingleContainer"));
        Actions action = new Actions(driver);
        Thread.sleep(2000);
        singleField.click();
        Thread.sleep(2000);
        action.sendKeys("r").perform();
        Thread.sleep(2000);
        action.sendKeys(Keys.ARROW_DOWN).perform();
        action.sendKeys(Keys.ENTER).perform();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"autoCompleteSingleContainer\"]/div/div[1]/div[1]")).getText(),"Green");
    }
    @Then("^user writes multiple colors$")
    public void user_writes_multiple_colors() throws InterruptedException {
        WebElement mutipleField = driver.findElement(By.id("autoCompleteMultipleContainer"));
        Actions action = new Actions(driver);
        List<String> colors = Arrays.asList("r", "g", "b", "b");
        Thread.sleep(2000);
        mutipleField.click();
        Thread.sleep(2000);
        for (String letter : colors) {
            action.sendKeys(letter).perform();
            Thread.sleep(2000);
            action.sendKeys(Keys.ENTER).perform();
        }
        Thread.sleep(2000);
        WebElement deletete_last = driver.findElement(By.xpath("//*[@id=\"autoCompleteMultipleContainer\"]/div/div[1]/div[4]/div[2]"));
        deletete_last.click();


    }

    @Given("^clicks on date picker$")
    public void clicks_on_date_picker(){
        WebElement datePicker = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[4]/div/ul/li[3]"));
        datePicker.click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://demoqa.com/date-picker");
    }
    @Then("^clicks on select date$")
    public void clicks_on_select_date(){
        WebElement date = driver.findElement(By.id("datePickerMonthYearInput"));
        date.click();
    }
    @And("^selects a (.+) and (.+) and (.+)$")
    public void selects_a_year_and_month_and_day(String year, String month, String day) throws InterruptedException {
        Select s = new Select(driver.findElement(By.xpath("//*[@id=\"datePickerMonthYear\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/select")));
        Thread.sleep(2000);
        s.selectByVisibleText(month);
        s = new Select(driver.findElement(By.xpath("//*[@id=\"datePickerMonthYear\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/select")));
        Thread.sleep(2000);
        s.selectByValue(year);


        WebElement sday = driver
                .findElement(By.xpath("//div[contains(@class, 'react-datepicker__day react-datepicker__day') and contains(@aria-label, '" + month + "') and text()='" + day + "']"));
        sday.click();


        //WebElement months = driver.findElement(By.className("react-datepicker__month"));
//        List<WebElement> weeks = driver.findElements(By.className("react-datepicker__week"));
//        List<WebElement> ex = Collections.<WebElement>emptyList();
//        for (WebElement e:weeks) {
//
   //     }



    }
    @Given("clicks on slider")
    public void clicks_on_slider() {
        WebElement slider = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[4]/div/ul/li[4]"));
        slider.click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://demoqa.com/slider");
    }
    @Then("moves slider to {int}")
    public void moves_slider_to(Integer value) throws InterruptedException {
        WebElement slider = driver.findElement(By.xpath("//*[@id=\"sliderContainer\"]/div[1]/span/input"));
        System.out.println(driver.findElement(By.xpath("//input[@id='sliderValue']")).getText());
        slider.click();
        for (int i = 100; i >= 0 ; i--){
            slider.sendKeys(Keys.ARROW_LEFT);
        }
        for (int i = 1; i <= value ; i++) {
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
        Thread.sleep(2000);


    }
    @Given("clicks on progress bar")
    public void clicks_on_progress_bar() {
       WebElement progressbar = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[4]/div/ul/li[5]"));
       progressbar.click();
    }

    @When("clicks start and waits until {string}")
    public void clicks_start_and_waits_until(String end) {
        WebElement start = driver.findElement(By.xpath("//button[@id='startStopButton']"));
        start.click();
        WebElement progressbar = driver.findElement(By.xpath("//div[@role='progressbar']"));
        WebDriverWait wait =  new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofMillis(100));
        wait.until(ExpectedConditions.attributeToBe(progressbar,"aria-valuenow",end));
        start.click();
    }

    @Then("progress bar should be at {string}")
    public void progress_bar_should_be_at(String end) {

        WebElement real_value= driver.findElement(By.xpath("//div[@aria-valuenow]"));
        Assert.assertEquals(real_value.getText(),end+"%");

        driver.close();
    }
    @Given("clicks on menu")
    public void clicks_on_menu() {
        WebElement menu = driver.findElement(By.xpath("//span[@class='text' and  text()='Menu']"));
        menu.click();
    }
    @When("hover over item two")
    public void hover_over_item_two() throws InterruptedException {

        WebElement main2 = driver.findElement(By.xpath("//a[ text()='Main Item 2']"));
        Actions action = new Actions(driver);
        Thread.sleep(2000);
        action.moveToElement(main2);
        Thread.sleep(2000);
        WebElement subList = driver.findElement(By.xpath("//a[ text()='SUB SUB LIST »']"));
        Thread.sleep(2000);
        action.moveToElement(subList);
        Thread.sleep(2000);
        WebElement subItem = driver.findElement(By.xpath("//a[ text()='Sub Sub Item 1']"));
        Thread.sleep(2000);
        action.moveToElement(subItem).build().perform();
    }





}
