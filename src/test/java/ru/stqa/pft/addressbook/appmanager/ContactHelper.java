package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static ru.stqa.pft.addressbook.tests.TestBase.app;

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
        attach(By.name("photo"), contactDate.getPhoto());

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
    public Set<ContactData> initContact(ContactData contact, boolean b) {
        fillContactForm(contact, true);
        app.goTo().moveToNeed();
       submitContactCreation();
       return all();
    }

    public boolean isThereAContect() {
        return isElementPresent(By.name("selected[]"));
    }

    public List<ContactData> list() {
        List<ContactData> contacts = new ArrayList<>();
        List<WebElement> elements = driver.findElements(By.name("entry"));
        for (WebElement element : elements){
            List<WebElement> cells = element.findElements(By.tagName("td"));
            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
            String name = cells.get(2).getText();
            String lastName = cells.get(1).getText();
            contacts.add(new ContactData().withId(id).withName(name).withLastName(lastName));
        }
        return contacts;
    }

//    private Contacts contactCache(){
//        if (contactCache != null){
//            return new Contacts(contactCache);
//        }
//    }

    public Contacts all() {
        Contacts contacts = new Contacts();
        List<WebElement> elements = driver.findElements(By.name("entry"));
        for (WebElement element : elements){
            List<WebElement> cells = element.findElements(By.tagName("td"));
            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
            String name = cells.get(2).getText();
            String lastName = cells.get(1).getText();
            String allPhones = cells.get(5).getText();

            contacts.add(new ContactData().withId(id).withName(name).withLastName(lastName).withAllPhones(allPhones));
        }
        return contacts;
    }

    public ContactData infoFromEditForm(ContactData contact) {
        initContactModificationById(contact.getId());
        String firstname = driver.findElement(By.name("firstname")).getAttribute("value");
        String lastname = driver.findElement(By.name("lastname")).getAttribute("value");
        String home = driver.findElement(By.name("home")).getAttribute("value");
        String mobile = driver.findElement(By.name("mobile")).getAttribute("value");
        String work = driver.findElement(By.name("work")).getAttribute("value");
        driver.navigate().back();
        return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname)
                .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work);
    }

    public void initContactModificationById(int id){
        WebElement checkbox = driver.findElement(By.cssSelector(String.format("input[value='%s']",id)));
        WebElement row = checkbox.findElement(By.xpath("./../.."));
        List<WebElement> cells = row.findElements(By.tagName("td"));
        cells.get(7).findElement(By.tagName("a")).click();
    }
}
