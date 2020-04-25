package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase{

    public NavigationHelper(WebDriver driver) {
        super(driver);
    }

    public void groupPage() {
      click(By.linkText("groups"));
    }

    public void gotoAddPage() {
        if (isElementPresent(By.tagName("h1")) && driver.findElement(By.tagName("h1")).getText().equals("Groups")
                && isElementPresent(By.name("new")))
        {
            return;
        }
        click(By.linkText("add new"));
    }
    public void gotoHome(){
        click(By.linkText("home"));
    }

    public void gotoHomePage() {
        if (isElementPresent(By.id("maintable"))){
            return;
        }
        click(By.linkText("home"));
    }
    public void moveToNeed(){
//        JavascriptExecutor s = (JavascriptExecutor)driver;
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
    public void changeContract(){
        click(By.xpath("//*[@id=\"maintable\"]/tbody/tr[2]/td[8]/a/img"));
    }
}
