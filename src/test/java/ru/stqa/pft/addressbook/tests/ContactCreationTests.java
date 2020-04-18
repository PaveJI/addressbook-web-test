package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreations()throws Exception{
        app.getNavigationHelper().gotoAddPage();
        app.getContactHelper().fillContactForm(new ContactData("John", "Silver", "Lenina str. 60a", "89991231212", "pishi@mail.com"));
        app.getNavigationHelper().moveToNeed();
        app.getContactHelper().submitContactCreation();
    }
}
