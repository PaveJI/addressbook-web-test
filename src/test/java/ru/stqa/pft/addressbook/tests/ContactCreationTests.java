package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase{

    @Test (enabled = false)
    public void testContactCreations()throws Exception{
        app.goTo().gotoAddPage();
        app.getContactHelper().fillContactForm(new ContactData("John", "Silver", "Lenina str. 60a", "89991231212", "pishi@mail.com", "test1"),true);
        app.goTo().moveToNeed();
        app.getContactHelper().submitContactCreation();
    }
}
