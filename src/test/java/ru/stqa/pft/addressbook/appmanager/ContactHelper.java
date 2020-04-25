package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

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

    public  void selectContact() {
        click(By.name("selected[]"));
    }
    public void initContactCreation() {
        click(By.name("new"));
    }

    public int getContactCount() {
        return driver.findElements(By.name("selected[]")).size();
    }

    public void createContact(ContactData contactData) {
        initContactCreation();
        fillContactForm(contactData, true);
        submitContactCreation();
    }

    public boolean isThereAContect() {
        return isElementPresent(By.name("selected[]"));
    }

    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<>();
        List<WebElement> elements = driver.findElements(By.xpath("/html/body/div/div[4]/form[2]/table/tbody/tr"));
        for (WebElement element : elements){
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.xpath("/html/body/div/div[4]/form[2]/table/tbody/tr[.]/td[.]/input")).getAttribute("value"));
            ContactData contact = new ContactData(id, name, null, null, null, null, null);
            contacts.add(contact);
        }
        return contacts;
    }
}
