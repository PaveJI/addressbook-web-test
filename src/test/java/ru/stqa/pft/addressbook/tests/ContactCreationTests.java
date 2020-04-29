package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.*;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreations()throws Exception{
        app.goTo().gotoHome();
        Set<ContactData> before = app.contact().all();
        app.goTo().gotoAddPage();
        ContactData contact = new ContactData().withName("John").withLastName("Silver");
        Set<ContactData> after = app.contact().initContact(contact, true);
        Assert.assertEquals(after.size(), before.size() + 1);


        contact.withId(after.stream().mapToInt((c) ->c.getId()).max().getAsInt());
        before.add(contact);
        Assert.assertEquals(after,before);
    }
}
