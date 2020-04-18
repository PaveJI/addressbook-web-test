package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase{

    public ContactHelper(WebDriver driver) {
        super(driver);
    }
    public void fillContactForm(ContactData contactDate){
        type(By.name("firstname"), contactDate.getName());
        type(By.name("lastname"), contactDate.getLastName());
        type(By.name("address"), contactDate.getAddress());
        type(By.name("mobile"), contactDate.getMobPhone());
        type(By.name("email"), contactDate.getEMail());
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void submitContactUpdate() {
        click(By.name("update"));
    }
}
