package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void fillContactForm(ContactData contactDate, boolean creation) {
        type(By.name("firstname"), contactDate.getName());
        type(By.name("lastname"), contactDate.getLastName());
        type(By.name("address"), contactDate.getAddress());
        type(By.name("mobile"), contactDate.getMobPhone());
        type(By.name("email"), contactDate.getEMail());

        if (creation){
            Assert.assertTrue(isElementPresent(By.name("new_group")));
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void submitContactUpdate() {
        click(By.name("update"));
    }
}
