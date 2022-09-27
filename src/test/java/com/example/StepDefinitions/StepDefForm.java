package com.example.StepDefinitions;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.exc.InvalidTypeIdException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.zh_cn.假如;
import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class StepDefForm {

    public static WebDriver driver ;
    @Given("^you are on the toolsQA main page$")
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
    @Then("^click on form$")
    public void click_on_form(){
        driver.getCurrentUrl();
        WebElement form = driver.findElement(By.xpath("//h5[text()='Forms']"));
        form.click();

    }
    @Then("^click on practice forms$")
    public void click_on_practice_forms(){
        driver.getCurrentUrl();
        WebElement pForms = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        pForms.click();
    }
    @Given("^user inserts (.*) and (.*)$")
    public void user_inserts_fName_and_lName(String fName, String lName) {

        driver.getCurrentUrl();
        WebElement firstN = driver.findElement(By.xpath("//input[@id='firstName']"));
        WebElement lastN = driver.findElement(By.xpath("//input[@id='lastName']"));
        firstN.sendKeys(fName);
        lastN.sendKeys(lName);

    }
    @Then("^inserts (.*)$")
    public void inserts_email(String email) throws Exception {

        WebElement Email = driver.findElement(By.xpath("//input[@id='userEmail']"));
        if(email.matches("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$"))
             Email.sendKeys(email);
        else
            throw new Exception("Invalid email format");
    }
    @Given("^user selects (.*)$")
    public void user_selects_gender(String gender){


        if(gender.equals("Male")){
            WebElement male = driver.findElement(By.xpath("//label[text()='Male']"));
            male.click();
        } else if (gender.equals("Female")) {
            WebElement female = driver.findElement(By.xpath("//label[text()='Female']"));
            female.click();
        } else if (gender.equals("Other")) {
            WebElement other = driver.findElement(By.xpath("//label[text()='Other']"));
        }

    }
    @Then("^user selectss (.*)$")
    public void user_selects_number(String num) throws Exception {

        WebElement num_field = driver.findElement(By.xpath("//input[@placeholder='Mobile Number']"));
        if(num.matches("\\d*"))
             num_field.sendKeys(num);
        else
            throw new Exception("number is invalid");

    }
    @Given("^user clicks on birthPicker$")
    public void user_clicks_on_birthPicker(){

        WebElement birthdayPicker = driver.findElement(By.id("dateOfBirthInput"));
        birthdayPicker.click();

    }
    @Then("^Selects (.*) (.*) and (.*)$")
    public void selects_month_year_and_day(String month , String year, String day){



    }


}
