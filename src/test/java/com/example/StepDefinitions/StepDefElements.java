package com.example.StepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;

public class StepDefElements {
    WebDriver driver = null;

    @Given("^user is on ToolsQA main page$")
    public void user_is_on_ToolsQA_main_page() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();

        driver.get("https://demoqa.com/");
        String ActualTitle = driver.getTitle();
        Assert.assertEquals("ToolsQA", ActualTitle);
        Thread.sleep(500);
        driver.manage().window().maximize();
        Thread.sleep(1500);
    }
    @When("^user clicks on the Elements button$")
    public void user_clicks_on_the_Elements_button() throws InterruptedException{
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div[1]")).click();
        Thread.sleep(1000);
    }
    @Then("^it opens nine more options$")
    public void it_opens_nine_more_options() throws InterruptedException {
        Thread.sleep(2500);
    }
    ///checkbox funtionality
    @Given("^user clicks on check box$")
    public void user_clicks_on_check_box() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div/ul/li[2]")).click();
        Thread.sleep(1000);
    }
    @When("^user clicks on the button to see the full paths$")
    public void user_clicks_on_the_button_to_see_the_full_paths() throws InterruptedException{
        driver.getCurrentUrl();
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div/div/button[1]")).click();
        Thread.sleep(2000);
    }
    @And("^selects some random checkboxes$")
    public void selects_somerandom_checkboxes() throws InterruptedException{

        WebElement Public = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[2]/ol/li[1]/span/label"));
        WebElement Angular = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[1]/ol/li[2]/span/label"));
        Public.click();
        Angular.click();

    }
    @Then("^verifies if it worked$")
    public void verifies_if_it_worked() throws InterruptedException {

      List<WebElement> s =  driver.findElements(By.className("text-success"));
        for (WebElement e: s) {
            //System.out.println(e.getText());
            System.out.println(e.getText());
        }
      driver.close();
      //  System.out.println(primu + "  " +doilea);
    }

    @Given("^user clicks on web tables$")
    public void user_clicks_on_web_tables(){
        WebElement webtable = driver.findElement(By.xpath("//*[@id=\"item-3\"]"));
        webtable.click();
        WebElement table = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]"));
        Assert.assertTrue(table.isDisplayed());
    }
    @Then("^checks add$")
    public void checks_add() throws InterruptedException {
        WebElement add = driver.findElement(By.xpath("//*[@id=\"addNewRecordButton\"]"));
        add.click();
        WebElement fName = driver.findElement(By.xpath("//*[@id=\"firstName\"]"));
        WebElement lName = driver.findElement(By.xpath("//*[@id=\"lastName\"]"));
        WebElement email = driver.findElement(By.xpath("//*[@id=\"userEmail\"]"));
        WebElement age = driver.findElement(By.xpath("//*[@id=\"age\"]"));
        WebElement salary = driver.findElement(By.xpath("//*[@id=\"salary\"]"));
        WebElement department = driver.findElement(By.xpath("//*[@id=\"department\"]"));
        WebElement submit = driver.findElement(By.xpath("//*[@id=\"submit\"]"));
        WebElement isOk = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[4]/div/div[1]"));
        fName.sendKeys("Bob");
        lName.sendKeys("Vance");
        email.sendKeys("bobvance@refrigiration.com");
        age.sendKeys("45");
        salary.sendKeys("100000");
        department.sendKeys("refrigiration");
        submit.click();
        Assert.assertTrue(isOk.isDisplayed());


    }
    @And("^checks edit$")
    public void checks_edit() throws InterruptedException {
        WebElement edit = driver.findElement(By.xpath("//*[@id=\"edit-record-4\"]"));
        Thread.sleep(2000);
        edit.click();
        WebElement age = driver.findElement(By.xpath("//*[@id=\"age\"]"));
        WebElement Salary = driver.findElement(By.xpath("//*[@id=\"salary\"]"));
        WebElement submit = driver.findElement(By.xpath("//*[@id=\"submit\"]"));
        WebElement AGE = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[4]/div/div[3]"));
        WebElement SALARY = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[4]/div/div[5]"));
        Thread.sleep(2000);
        age.clear();
        Thread.sleep(2000);
        Salary.clear();
        Thread.sleep(2000);
        age.sendKeys("30");
        Salary.clear();
        Thread.sleep(2000);
        Salary.sendKeys("20000");
        Thread.sleep(2000);
        submit.click();
        Assert.assertEquals(AGE.getText(),"30");
        Assert.assertEquals(SALARY.getText(),"20000");
    }
    @Then("^checks delete$")
    public void checks_delete(){
        WebElement delete = driver.findElement(By.xpath("//*[@id=\"delete-record-4\"]"));
        delete.click();

    }
    @And("^prints a row$")
    public void prints_a_row(){
        List<WebElement> rows = driver.findElements(By.className("rt-tr-group"));
//        for (WebElement e : rows) {
//            System.out.println(e.getText());
//            System.out.println();
//        }
        String text = rows.get(0).getText();
        text = text.replaceAll("\n", " ");
        System.out.print("The first row :  ");
        System.out.println(text);
        System.out.println();
    }
    @Then("^prints a column$")
    public void prints_a_column(){
        List<WebElement> rows = driver.findElements(By.className("rt-tr-group"));
        String text = " ";
        for (WebElement e : rows) {
             text = text + e.getText();
        }
        text = text.replaceAll("\n", " ");
        System.out.println("The age column is : ");
        System.out.println(text.substring(13,16));
        System.out.println(text.substring(65,67));
        System.out.println(text.substring(116,119));
    }

    @Given("^user clicks on buttons$")
    public void user_clicks_on_buttons(){
        WebElement buttons = driver.findElement(By.xpath("//*[@id=\"item-4\"]"));
        buttons.click();

    }
    @And("^user double clicks first button$")
    public void user_double_clicks_first_button() throws InterruptedException {
        WebElement dclick = driver.findElement(By.xpath("//*[@id=\"doubleClickBtn\"]"));
        Actions action = new Actions(driver);
        Thread.sleep(2000);
        action.doubleClick(dclick).perform();
    }
    @Then("^right clicks the second button$")
    public void right_clicks_the_second_button() throws InterruptedException {
        WebElement rclick = driver.findElement(By.xpath("//*[@id=\"rightClickBtn\"]"));
        Actions action = new Actions(driver);
        Thread.sleep(2000);
        action.contextClick(rclick).perform();
    }
    @And("^simple clicks last button$")
    public void simple_clicks_last_button() throws InterruptedException {
        WebElement nclick = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[3]/button"));
        Thread.sleep(2000);
        nclick.click();
    }
    @Then("^all three messages should appear$")
    public void all_three_messages_should_appear() throws InterruptedException {
        WebElement mDClick = driver.findElement(By.id("doubleClickMessage"));
        WebElement mRClick = driver.findElement(By.id("rightClickMessage"));
        WebElement mNClick = driver.findElement(By.id("dynamicClickMessage"));
        Assert.assertTrue(mDClick.isDisplayed());
        Assert.assertTrue(mRClick.isDisplayed());
        Assert.assertTrue(mNClick.isDisplayed());
        Thread.sleep(2000);
        driver.close();

    }

}
