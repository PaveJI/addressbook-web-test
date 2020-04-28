package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.*;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreations()throws Exception{
        app.goTo().gotoHome();
        List<ContactData> before = app.getContactHelper().getContactList();
        app.goTo().gotoAddPage();
        ContactData contact = new ContactData("John", "Silver", null, null, null, null);
        app.getContactHelper().fillContactForm(contact, true);
        app.goTo().moveToNeed();
        app.getContactHelper().submitContactCreation();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);


//        contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        before.add(contact);
        before.sort((o1, o2) -> Integer.compare(o1.getId(), o2.getId()));
        after.sort((o1, o2) -> Integer.compare(o1.getId(), o2.getId()));
        Assert.assertEquals(after,before);
    }
}
