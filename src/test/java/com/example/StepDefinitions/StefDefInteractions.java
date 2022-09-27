package com.example.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class StefDefInteractions {
    WebDriver driver = null;
    @Given("^you are on the ToolsQA main page$")
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
    @Then("^click on interactions$")
    public void click_on_interactions(){
        WebElement interactions = driver.findElement(By.xpath("//h5[text()='Interactions']"));
        interactions.click();
    }
    @Given("^click on Sortable$")
    public void click_on_Sortable(){
        WebElement sortable = driver.findElement(By.xpath("//span[@class='text' and text()='Sortable']"));
        sortable.click();
    }
    @And("^mixes them$")
    public void mixes_them() throws InterruptedException {


        List<WebElement> elements = driver.findElements(By.xpath("//div[@id='demo-tabpane-list']/div/div"));
        Actions action = new Actions(driver);
        Collections.shuffle(elements);
        for (int i=0; i<6; i++){
            if(i==5){

                action.dragAndDrop(elements.get(0),elements.get(3)).perform();

            }

            else{

                action.dragAndDrop(elements.get(i),elements.get(elements.size()-1)).perform();
            }

        }



        Thread.sleep(2000);

    }
    @Then("^sorts them (.*)$")
    public void sorts(String type) throws InterruptedException {

        String[] s = {"One","Two","Three","Four","Five","Six"};
        List<WebElement> list = driver.findElements(By.xpath("//* [@id='demo-tabpane-list']/div/div"));
        Actions action = new Actions(driver);
        int index= list.size()-1;
        if(type.equals("Crescator")){
            for(int i =0;i<list.size()-1;i++) {

                WebElement element = driver.findElement(By.xpath("//div[@id='demo-tabpane-list']/div/div[text()='" + s[i] + "']"));
                Thread.sleep(1000);
                action.dragAndDrop(element, list.get(i)).perform();

            }

        } else if (type.equals("Descrescator")) {

            for(int i =0 ; i<list.size()-1; i++) {

                WebElement element = driver.findElement(By.xpath("//div[@id='demo-tabpane-list']/div/div[text()='" + s[i] + "']"));
                Thread.sleep(1000);
                action.dragAndDrop(element, list.get(index-i)).perform();

            }

            }
        driver.close();
        }
    @Given("^click on selectable$")
    public void click_on_selectable(){
        WebElement selectable = driver.findElement(By.xpath("//span[@class='text' and text()='Selectable' ]"));
        selectable.click();
    }
    @And("^slects (.*) and (.*)$")
    public void Selects(Integer one,Integer second){
        List<WebElement> selects=driver.findElements(By.xpath("//ul[@id='verticalListContainer']/li"));
        selects.get(one).click();
        selects.get(second).click();

    }
    @Then("^(.*) and (.*) should be selected$")
    public void should_be_selected(Integer one,Integer second){

        List<WebElement> selects=driver.findElements(By.xpath("//ul[@id='verticalListContainer']/li"));
        List<WebElement> fSelected = driver.findElements(By.xpath("//ul[@id='verticalListContainer']/li[@class='mt-2 list-group-item active list-group-item-action']"));
        Assert.assertEquals(fSelected.size(),2);
        driver.close();

    }
    @Given("click on droppable")
    public void click_on_droppable() {
        WebElement droppable = driver.findElement(By.xpath("//span[text()='Droppable']"));
        droppable.click();
    }
    @When("drops box")
    public void drops_box() throws InterruptedException {
        Thread.sleep(2000);
        WebElement drag_box = driver.findElement(By.xpath("//div[@id='draggable']"));
        Thread.sleep(2000);
        WebElement drop_box = driver.findElement(By.xpath("//div[@class='simple-drop-container']/div/p"));
        Actions action = new Actions(driver);
        action.dragAndDrop(drag_box,drop_box).perform();
    }
    @Then("box should be dropped")
    public void box_should_be_dropped() {

        WebElement drop_box = driver.findElement(By.xpath("//div[@class='simple-drop-container']/div/p"));
        Assert.assertEquals(drop_box.getText(),"Dropped!");

    }
    @Given("^clicks on droppable and accept$")
    public void clicks_on_droppable_and_accept(){
        WebElement droppable = driver.findElement(By.xpath("//span[text()='Droppable']"));
        droppable.click();
        WebElement accept = driver.findElement(By.xpath("//a[text()='Accept']"));
        accept.click();

    }
    @Then("^moves notAcceptable$")
    public void moves_notAcceptable(){
        WebElement nAcceptable = driver.findElement(By.xpath("//div[text()='Not  Acceptable']"));
        WebElement drop_box = driver.findElement(By.xpath("//div[@class='accept-drop-container']/div/p"));
        Actions action = new Actions(driver);
        action.dragAndDrop(nAcceptable,drop_box).perform();
        Assert.assertEquals(drop_box.getText(),"Drop here");
    }
    @Then("^moves acceptable$")
    public void moves_acceptable(){


        WebElement acceptable = driver.findElement(By.xpath("//div[text()='Acceptable']"));
        WebElement drop_box = driver.findElement(By.xpath("//div[@class='accept-drop-container']/div/p"));
        Actions action = new Actions(driver);
        action.dragAndDrop(acceptable,drop_box).perform();
        Assert.assertEquals(drop_box.getText(),"Dropped!");



    }
    @Given("^click on draggable$")
    public void click_on_draggable() throws InterruptedException {

        WebElement draggable = driver.findElement(By.xpath("//span[text()='Dragabble']"));
        draggable.click();
        Thread.sleep(2000);

    }
    @Then("^moves the box to (.*) and (.*)$")
    public void moves_box(Integer xoff,Integer yoff){

        WebElement box = driver.findElement(By.xpath("//div[@id='dragBox']"));
        Actions action = new Actions(driver);
        action.dragAndDropBy(box,xoff,yoff).perform();

    }

    @Given("^click on draggable and Axis Restricted$")
    public void click_on_draggable_and_Axis_Restricted(){

        WebElement draggable = driver.findElement(By.xpath("//span[text()='Dragabble']"));
        draggable.click();
        WebElement axisR = driver.findElement(By.xpath("//a[text()='Axis Restricted']"));
        axisR.click();
    }

    @Then("^moves xbox to (.*) and (.*)$")
    public void moves_the_boxes(Integer xoff, Integer yoff) throws InterruptedException {

        WebElement xbox = driver.findElement(By.xpath("//div[text()='Only X']"));
        WebElement ybox = driver.findElement(By.xpath("//div[text()='Only Y']"));
        Actions action = new Actions(driver);
        Thread.sleep(2000);
        action.dragAndDropBy(xbox,xoff,0).perform();
        Thread.sleep(2000);
        action.dragAndDropBy(ybox,0,yoff).perform();
        driver.close();

    }

}
